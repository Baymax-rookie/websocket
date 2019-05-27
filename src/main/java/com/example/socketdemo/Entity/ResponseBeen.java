package com.example.socketdemo.Entity;

import lombok.Data;

/**
 * @author 12589
 */
@Data
public class ResponseBeen {
    private int code;
    private Object obj;
    private String message;
    public ResponseBeen(int code,Object obj,String message){
        this.code=code;
        this.obj=obj;
        this.message=message;
    }
    public ResponseBeen(Object obj,String message){
        this.obj=obj;
        this.message=message;
    }
}
