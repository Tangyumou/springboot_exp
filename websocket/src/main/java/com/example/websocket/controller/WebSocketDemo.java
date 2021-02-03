package com.example.websocket.controller;

import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint("/WebSocket/Websocket")
@Component
public class WebSocketDemo {
    @OnMessage
    public void onMessage(String message, Session session){
        try{
            if(session.isOpen()) {
                System.out.println("发送消息"+message);
                session.getBasicRemote().sendText(message);
            }
        }catch (IOException e) {
            try {
                session.close();
            } catch (IOException e1) {
                e.printStackTrace();
            }
        }
    }
    @OnOpen
    public void onOpen() {
        System.out.println("open");
    }
    @OnClose
    public void onClose() {
        System.out.println("close");
    }

}
