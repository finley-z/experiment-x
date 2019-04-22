package com.finley.concurrent;

/**
 * @author zyf
 * @date 2017/9/11
 */
public class WaitExceptionTest {
    public static void main(String []args){
        WaitExceptionTest waitExceptionTest=new WaitExceptionTest();
        try {
            waitExceptionTest.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
