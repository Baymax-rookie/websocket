package com.example.socketdemo.controller.socket;

import com.example.socketdemo.Entity.Message;
import com.example.socketdemo.aspect.Broad;

import javax.servlet.http.HttpSession;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 12589
 */
@ServerEndpoint("/chatsocket")
public class PublicSocket {
    private String username;

    private static List<String>list=new ArrayList<>();
    public static List<Session>sessions=new ArrayList<>();


    @OnOpen
    public void open(Session session, EndpointConfig config){
        HttpSession httpSession= (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
        this.username= (String) httpSession.getAttribute("username");
        list.add(username);
        sessions.add(session);
        Message message=new Message();
        message.setWelcome(username);
        message.setList(list);
        broadcast(sessions,message.toJson());
    }

    public static void broadcast(List<Session>list,String msg){
        for (Session session : list) {
            try {
                session.getBasicRemote().sendText(msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @OnClose
    public void close(Session session){
        sessions.remove(session);
        list.remove(this.username);
        Message message=new Message();
        message.setGoodbye(username);
        message.setList(list);
        broadcast(sessions,message.toJson());
    }

    @OnMessage
    public void msg(String msg){
        Message message=new Message();
        message.setList(list);
        message.setContext(this.username,msg);
        broadcast(sessions,message.toJson());
    }
}
