package com.finley.basic;

import java.util.Scanner;

/**
 * Created by 郑远锋 on 2017/11/2.
 */
public class ThreadStateTest {
    public static void main(String []args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("please input a char....");
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String s=scanner.next();
    }

}
