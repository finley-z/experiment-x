package com.finley.concurrent;

/**
 * Created by 郑远锋 on 2017/8/22.
 */
public class ReciverMsgTask  implements Runnable {

    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()){
//            String msg=MessagePool.getMessage();
            System.out.println("开始读取消息。。。。");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String msg=MessageQueue.getMessage();
            System.out.println("消息内容:"+msg);
            System.out.println("消息读取完成。。。。");
        }
    }
}
