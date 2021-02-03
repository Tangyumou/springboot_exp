package com.example.websocket.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@ServerEndpoint("/chatroom/{userId}")
@Component
public class OneToManyWebSocket {
    // 当前在线连接数
    private static AtomicInteger onlineCount = new AtomicInteger(0);
    // 所有在线客户端
    private static Map<Integer, Session> clients = new ConcurrentHashMap<>();

    // 连接建立成功
    @OnOpen
    public void onOpen(Session session, @PathParam("userId") Integer userId) {
        onlineCount.incrementAndGet();
        clients.put(userId, session);
        log.info("有新连接加入：{}，当前在线人数为：{}", userId, onlineCount.get());
    }

    // 连接关闭
    @OnClose
    public void onClose(@PathParam("userId") Integer userId) {
        onlineCount.decrementAndGet();
        clients.remove(userId);
        log.info("有一连接关闭：{}，当前在线人数为：{}",userId,onlineCount.get());
    }
    // 收到客户端消息
    @OnMessage
    public void onMessage(String message, Session session,@PathParam("userId") Integer userId) {
        log.info("服务端收到客户端{}的消息：{}",userId,message);
        message = userId+":"+message;
        sendMessage(message, session);
    }
    // 错误处理
    @OnError
    public void onError(Session session, Throwable error){
        log.error("发生错误");
        error.printStackTrace();
    }
    // 群发消息
    private void sendMessage(String message,Session session) {
        for(Map.Entry<Integer,Session> sessionEntry : clients.entrySet()){
            Session toSession = sessionEntry.getValue();
            if(!session.equals(toSession)) {
                log.info("服务端給客户端{}发送消息{}",sessionEntry.getKey(),message);
                toSession.getAsyncRemote().sendText(message);
            }
        }
    }

}
