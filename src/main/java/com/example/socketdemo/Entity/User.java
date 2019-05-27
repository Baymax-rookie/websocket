package com.example.socketdemo.Entity;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 12589
 */
@Data
public class User {
    public static Map<String,String>friends=new HashMap<>();
}
