package com.example.socketdemo.controller.socket;

import com.example.socketdemo.Entity.Message;
import com.example.socketdemo.Entity.User;
import com.example.socketdemo.aspect.Broad;
import lombok.extern.slf4j.Slf4j;
import javax.servlet.http.HttpServletRequest;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 12589
 */
@Slf4j
@ServerEndpoint("chatsocket_p")
public class PrivateSocket {
    private static String username;
    private static List<String> list=new ArrayList<>(2);
    private static List<Session>sessions=new ArrayList<>(2);
    @OnError
    public void access(){
        for (String name:list) {
            if (User.friends.get(name)==null){
                log.error("非好友，有内鬼");
            }
        }
    }
    @Broad
    @OnOpen
    public void open(Session session, HttpServletRequest request){
        username=request.getParameter("username");
        list.add(username);
        sessions.add(session);
        Message message=new Message();
        message.setWelcome(username);
        message.setList(list);
        PublicSocket.broadcast(sessions,message.toJson());
    }
    @OnClose
    public void close(Session session){
        sessions.remove(session);
        list.remove(username);
        Message message=new Message();
        message.setGoodbye(username);
        message.setList(list);
        PublicSocket.broadcast(sessions,message.toJson());
    }
    @OnMessage
    public void msg(String msg){
        Message message=new Message();
        message.setList(list);
        message.setContext(username,msg);
        PublicSocket.broadcast(sessions,message.toJson());
    }

}
