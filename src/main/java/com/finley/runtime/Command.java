package com.finley.runtime;

import java.io.IOException;

/**
 * @author zyf
 * @date 2017/9/15
 */
public class Command {

    public static void main(String []args){
        try {
            Runtime.getRuntime().exec(System.getenv("windir")+"\\system32\\shutdown.exe -s -f");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
