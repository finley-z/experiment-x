package com.finley.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author zyf
 * @date 2017/8/23
 */
public class MessageQueue {
   private static BlockingQueue<String> messageQueue=new ArrayBlockingQueue<String>(1);
    public static String getMessage(){
        try {
            return   messageQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void setMessage(String msg){
        try {
            messageQueue.put(msg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
