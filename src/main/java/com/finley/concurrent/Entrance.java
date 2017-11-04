package com.finley.concurrent;

/**
 * Created by 郑远锋 on 2017/8/22.
 */
public class Entrance {
    public static void main(String []args){
        Thread sender=new Thread(new SendMsgTask());
        Thread reciver=new Thread(new ReciverMsgTask());
        sender.start();
        reciver.start();
    }
}
