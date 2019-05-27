package com.example.socketdemo.controller;


import com.example.socketdemo.Entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 12589
 */
@RestController
@RequestMapping("Service")
public class MainController {
    @RequestMapping("/login")
    public void login(HttpServletRequest request){
        /*
         * 没有界面就不做什么操作了
         * */
        String username=request.getParameter("username");
        request.getSession().setAttribute("username", username);

    }
    @GetMapping("/add")
    public void add(String username,String friendName){
        User.friends.put(username,friendName);
    }

}
