package com.finley.io.bio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * @author zyf
 * @date 2017/9/18
 */
public class out {
    public static void main(String []args){
        try {
            File directory=new File("H:/go/test");
            if(!directory.exists()){
                directory.mkdirs();
            }
            File file=new File(directory,"info.log");
            if(!file.exists()){
                file.createNewFile();
            }
            FileOutputStream log=new FileOutputStream(file,true);
            PrintStream printStream=new PrintStream(log);
            System.setOut(printStream);
            System.out.println("the jvm has an fatal error");
            System.out.println("times:"+System.currentTimeMillis());
            log.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
