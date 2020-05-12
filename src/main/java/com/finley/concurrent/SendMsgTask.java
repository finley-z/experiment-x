package com.finley.concurrent;

/**
 * Created by 郑远锋 on 2017/8/22.
 */
public class SendMsgTask implements Runnable {

    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()){
//           MessagePool.setMessage("Hello Java!");
            try{
                System.out.println("开始发送消息。。。。");
                Thread.sleep(5000);
                MessageQueue.setMessage("Hello Java!");
                System.out.println("消息发送完成。。。。");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
