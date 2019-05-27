package com.example.socketdemo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import static com.example.socketdemo.controller.socket.PublicSocket.sessions;

/**
 * @author 12589
 */
@Component
@Aspect
@Slf4j
public class Distinguish {
    @Pointcut("@annotation(broad)")
    public void doCut(Broad broad){
    }
    @Around("doCut(broad)")
    public static Object doBefore(ProceedingJoinPoint joinPoint, Broad broad) throws Throwable {
        if (sessions.size()==broad.count()){
            log.info("当前聊天室为单对单聊天室");
            return joinPoint.proceed();
        }else {
            log.info("聊天室人数异常");
            return "非单对单聊天室";
        }
    }


}
