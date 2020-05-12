package com.finley.io.nio.buffer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author zyf
 * @date 2017/10/13
 */
public class MappedByteBufferTest {
    public static void main(String []args){
        try {
            RandomAccessFile file=new RandomAccessFile("H:/quote.log","rw");
            FileChannel fileChannel=file.getChannel();
            MappedByteBuffer mappedByteBuffer=fileChannel.map(FileChannel.MapMode.READ_WRITE,0,fileChannel.size());

            mappedByteBuffer.load();
            System.out.println("文件缓冲是否已载入内存:"+mappedByteBuffer.isLoaded());
            byte [] des=new byte[(int) fileChannel.size()];
            while(mappedByteBuffer.hasRemaining()){
//                System.out.println(new String(mappedByteBuffer.array(),"UTF-8"));
              mappedByteBuffer.get(des);
            }
            System.out.println(new String(des,"UTF-8"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
