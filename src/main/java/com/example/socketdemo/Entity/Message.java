package com.example.socketdemo.Entity;

import com.google.gson.Gson;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author 12589
 */
@Data
public class Message {
    private String welcome;
    private String goodbye;
    private List<String>list;
    private static Gson gson;
    private String context;
    public Message(){}
    public void setWelcome(String username) {
        this.welcome = "欢迎"+username+"来到聊天室";
    }
    public void setGoodbye(String username){
        this.goodbye=username+"离开了聊天室";
    }
    public void setContext(String username,String msg){
        this.context=username+new Date().toLocaleString()+ ":\\n"+
                        "  "+msg;
    }
    public String toJson(){
        return gson.toJson(this);
    }
}
