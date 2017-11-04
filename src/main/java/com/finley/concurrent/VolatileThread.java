package com.finley.concurrent;

/**
 * @author zyf
 * @date 2017/8/23
 */
public class VolatileThread implements Runnable {
    private VolatileOpt volatileOpt;

    public VolatileThread(VolatileOpt volatileOpt){
        this.volatileOpt=volatileOpt;
    }
    @Override
    public void run() {
//        while(true){
            volatileOpt.increment();
//        }
    }
}
