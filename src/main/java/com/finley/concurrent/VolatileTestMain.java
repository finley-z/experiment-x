package com.finley.concurrent;

/**
 * @author zyf
 * @date 2017/8/23
 */
public class VolatileTestMain {

    public static void main(String []args){
        VolatileOpt volatileOpt=new VolatileOpt();
        for(int i=0;i<100;i++) {
            Thread thread=new Thread(new VolatileThread(volatileOpt));
            thread.start();
        }
    }
}
