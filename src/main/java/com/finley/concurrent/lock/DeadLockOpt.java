package com.finley.concurrent.lock;

/**
 * Created by 郑远锋 on 2017/8/25.
 */
public class DeadLockOpt {

    public synchronized void synch1() {
        System.out.println("start synch1。。。");

        synchronized (Integer.class) {
            System.out.println("synchronized   Integer。。。");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (Long.class) {
                System.out.println("synchronized Long。。。");
            }
        }
        System.out.println("end synch1。。。");
    }

    public synchronized void synch2() {
        System.out.println("start synch2。。。");
        synchronized (Long.class) {
            System.out.println("synchronized   Long。。。");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (Integer.class) {
                System.out.println("synchronized Integer。。。");
            }
        }
        System.out.println("end synch2。。。");
    }
}
