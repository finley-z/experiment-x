package com.finley.database.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 郑远锋 on 2017/8/1.
 */
@Service
public class DataBaseTestEntrace {
    // 封装Bean中注入服务
    @Autowired
    DataBaseTestService service;

    public void execute() {
        new Worker(true).start();
        new Worker(false).start();
    }
    // 线程内部类，Thread或者Runnable均可
    private class Worker extends Thread {
        boolean who;
        public Worker(boolean who){
            this.who=who;
        }
        @Override
        public void run() {
            // do something...
            if(who){
                DataBaseTestEntrace.this.service.testDeadlock();
            }else{
                DataBaseTestEntrace.this.service.testDeadlock1();
            }
            // 此时someService已被注入，非null.
        }
    }
}