package com.example.socketdemo.aspect;

import java.lang.annotation.*;

/**
 * @author 12589
 */
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Broad {
    int count ()default 2;
}
