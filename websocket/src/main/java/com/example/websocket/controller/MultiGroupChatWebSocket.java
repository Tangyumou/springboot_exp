package com.example.websocket.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * websocket实现多个群聊
 */
@Slf4j
@ServerEndpoint("/chatroom/{roomId}/{userId}")
@Component
public class MultiGroupChatWebSocket {
    private static Map<Integer,MultiGroupChatWebSocket> chatRoomMap = new ConcurrentHashMap<>();
    // 当前在线连接数
    private AtomicInteger onlineCount = new AtomicInteger(0);
    // 所有在线客户端
    private Map<Integer, Session> clients = new ConcurrentHashMap<>();
    // 连接建立成功
    @OnOpen
    public void onOpen(Session session, @PathParam("roomId") Integer roomId, @PathParam("userId") Integer userId) {
        MultiGroupChatWebSocket groupChatWebSocket;
        if(chatRoomMap.containsKey(roomId)) {
             groupChatWebSocket = chatRoomMap.get(roomId);
        }else{
            groupChatWebSocket = new MultiGroupChatWebSocket();
            chatRoomMap.put(roomId,groupChatWebSocket);
            log.info("新聊天室：{}被创建",roomId);
            log.info("当前聊天室个数为：{}",chatRoomMap.size());
        }
        // 当前房间在线人数
        int onlineNum = groupChatWebSocket.addOnlineCount();
        groupChatWebSocket.addSession(userId,session);
        log.info("有新连接{}加入{}聊天室，该聊天室当前在线人数为：{}", userId,roomId, onlineNum);
    }

    // 连接关闭
    @OnClose
    public void onClose(@PathParam("roomId") Integer roomId, @PathParam("userId") Integer userId) {
        MultiGroupChatWebSocket groupChatWebSocket = chatRoomMap.get(roomId);
        groupChatWebSocket.subOnlineCount();
        groupChatWebSocket.removeSession(userId);
        int onlineNum = groupChatWebSocket.getRoomPeopleNum();
        log.info("{}房间有一连接关闭：{}，当前在线人数为：{}",roomId,userId,onlineNum);
        if(onlineNum==0){
            chatRoomMap.remove(roomId);
            log.info("{}房间人数为0被关闭",roomId);
            log.info("当前房间数为{}",chatRoomMap.size());
        }
    }
    // 收到客户端消息
    @OnMessage
    public void onMessage(String message, Session session,@PathParam("roomId") Integer roomId, @PathParam("userId") Integer userId) {
        log.info("服务端收到房间{}客户端{}的消息：{}",roomId,userId,message);
        message = userId+":"+message;
        sendMessage(roomId,message, session);
    }
    // 错误处理
    @OnError
    public void onError(Session session, Throwable error){
        log.error("发生错误");
        error.printStackTrace();
    }
    // 群发消息
    private void sendMessage(Integer roomId,String message,Session session) {
        MultiGroupChatWebSocket groupChatWebSocket = chatRoomMap.get(roomId);
        Map<Integer,Session> sessionMap = groupChatWebSocket.getClients();
        for(Map.Entry<Integer,Session> sessionEntry : sessionMap.entrySet()){
            Session toSession = sessionEntry.getValue();
            if(!session.equals(toSession)) {
                log.info("服务端給{}房间客户端{}发送消息{}",roomId,sessionEntry.getKey(),message);
                toSession.getAsyncRemote().sendText(message);
            }
        }
    }

    public int addOnlineCount(){
        return onlineCount.incrementAndGet();
    }

    public int subOnlineCount(){
        return onlineCount.decrementAndGet();
    }

    public void addSession(Integer userId, Session session){
        clients.put(userId,session);
    }

    public void removeSession(Integer userId){
        clients.remove(userId);
    }

    public Map<Integer, Session> getClients() {
        return clients;
    }

    public int getRoomPeopleNum(){
        return onlineCount.get();
    }

}
