package com.finley.database;

/**
 * @author zyf
 * @date 2017/8/23
 */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 郑远锟斤拷 on 2017/8/1.
 * 数据库死锁测试线程
 *
 *
 */
@Service
public class DeadLockThread {
    @Autowired
    DataBaseTestService service;

    public void execute() {
        new Worker(true).start();
        new Worker(false).start();
    }

    private class Worker extends Thread {
        boolean who;
        public Worker(boolean who){
            this.who=who;
        }
        @Override

        public void run() {
            // do something...
            if(who){
                DeadLockThread.this.service.testDeadlockTransaction1();
            }else{
                DeadLockThread.this.service.testDeadlockTransaction2();
            }
        }
    }
}