package com.finley.jni;

/**
 * @author zyf
 * @date 2017/9/27
 */
public class TestJNI {
    public static  native void sayHello(String text);

    static {
        System.loadLibrary("hello");
    }

    public static void main(String[] args) {
        new TestJNI().sayHello("hello world");
    }
}
