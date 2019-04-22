package com.finley.io.bio.pipe;

import java.io.*;

/**
 * @author zyf
 * @date 2017/9/18
 */
public class PipeExample {

    public static void main(String[] args) throws IOException {
        test2();
    }


    public static void test1() throws IOException {
        final PipedOutputStream outputStream = new PipedOutputStream();
        final PipedInputStream inputStream = new PipedInputStream(outputStream);

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    outputStream.write("测试流的中文读写！".getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    int data =0;
                    while((data=inputStream.read())!= -1) {
                        System.out.print((char) data);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();
        thread2.start();
    }


    public static void test2() throws IOException {
        final PipedWriter writer = new PipedWriter();
        final PipedReader reader = new PipedReader(writer);

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    writer.write("测试流的中文读写！");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    int data =0;
                    while((data=reader.read())!= -1) {
                        System.out.print((char) data);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();
        thread2.start();

    }

}
