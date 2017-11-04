package com.finley.runtime;

/**
 * @author zyf
 * @date 2017/9/12
 */
public class ShutHook extends  Thread{
    @Override
    public void run() {
        System.out.println("JVM Try To Shutdown!");
    }
}
