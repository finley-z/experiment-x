package com.finley.concurrent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 郑远锋 on 2017/8/22.
 */
public class MessagePool {
    private static List<String> messagePool=new ArrayList<String>();

    public static String getMessage(){
        if(messagePool.size()>0){
            String msg=messagePool.get(0);
            messagePool.remove(0);
            return msg;
        }
        return "";
    }

    public static void setMessage(String msg){
        if(messagePool.size()<1){
            messagePool.add(0,msg);
        }
    }
}
