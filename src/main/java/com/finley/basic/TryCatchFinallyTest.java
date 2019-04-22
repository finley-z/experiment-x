package com.finley.basic;

/**
 * @author zyf
 * @date 2017/9/18
 */
public class TryCatchFinallyTest {

    public static void main(String []args){
        System.out.print(TryCatchFinallyTest.class.getClassLoader());
        int i=returnTest();
        System.out.print("value="+i);
    }



    public static int returnTest(){
        try{
            return 1;
        }catch (Exception e){
            return 2;
        }finally {
            return 3;
        }
    }
}
