package com.finley.runtime;

/**
 * @author zyf
 * @date 2017/9/12
 */
public class MachineInfo {
    public static void main(String []args){
        int num= Runtime.getRuntime().availableProcessors();
        Runtime.getRuntime().addShutdownHook(new ShutHook());

        System.out.println("cpu number:"+num);

        System.out.println("free memory:"+Runtime.getRuntime().freeMemory());
        Runtime.getRuntime().exit(1);
    }
}
