package com.finley.concurrent.lock;

/**
 * Created by 郑远锋 on 2017/8/25.
 */
public class DeadLockMain {
    public static void main(String []args){
        final DeadLockOpt deadLockOpt=new DeadLockOpt();
        final DeadLockOpt deadLockOpt1=new DeadLockOpt();
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                deadLockOpt.synch1();
            }
        });
        thread.start();

        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                deadLockOpt1.synch2();
            }
        });
        thread1.start();

    }

}
