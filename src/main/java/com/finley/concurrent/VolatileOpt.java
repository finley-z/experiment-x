package com.finley.concurrent;

/**
 * @author zyf
 * @date 2017/8/23
 */
public class VolatileOpt {
    private volatile  int i=0;
//    private final AtomicInteger i=new AtomicInteger(0);


    public  void increment(){
//        synchronized (this){

            System.out.println("i="+ i++);
//            System.out.println("i="+ i.incrementAndGet());
//        }
    }

    public int getCount(){
        synchronized (this){
            return i;
//            return i.get();
        }
    }
}
