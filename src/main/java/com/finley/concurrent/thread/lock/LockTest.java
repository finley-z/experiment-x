package com.finley.concurrent.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by 郑远锋 on 2017/9/11.
 */
public class LockTest {
    Lock lock=new ReentrantLock();
    public void method1(){
        synchronized (this){
            System.out.print("1");
        }
    }

    public void method2(){
        lock.lock();
        System.out.print("1");
        lock.unlock();
    }

}
