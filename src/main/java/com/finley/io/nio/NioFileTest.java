package com.finley.io.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * Created by 郑远锋 on 2017/9/5.
 */
public class NioFileTest {

    public void readFile(){
        FileChannel fileChannel=null;
        try {
            RandomAccessFile file=new RandomAccessFile("F:/java/logs/error.log","rw");
            fileChannel=file.getChannel();
//            ByteBuffer buffer=ByteBuffer.allocate(1024);
            ByteBuffer buffer=ByteBuffer.allocateDirect(1024);
            CharBuffer charBuffer=CharBuffer.allocate(1024);
            CharsetDecoder decoder = Charset.defaultCharset().newDecoder();
            int length=fileChannel.read(buffer);
            while (length != -1) {
                while(buffer.hasRemaining()){
                    buffer.flip();
//                    Charset.defaultCharset().decode();
                    decoder.decode(buffer, charBuffer, false);
                    charBuffer.flip();
                    System.out.print(charBuffer);
                }
                buffer.clear();
                length = fileChannel.read(buffer);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileChannel != null){
                try {
                    fileChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void writeFile(){
        FileChannel fileChannel=null;
        try {
            RandomAccessFile file=new RandomAccessFile("F:/java/logs/error.log","rw");
            fileChannel=file.getChannel();
            ByteBuffer buffer=ByteBuffer.allocate(96);
            long length=file.length();
            file.seek(length);
            for(int i=0;i<10;i++){
                buffer.put((System.currentTimeMillis()+":系统第行出现故障 "+i+" \n").getBytes());
                buffer.flip();
                fileChannel.write(buffer);
                buffer.clear();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileChannel != null){
                try {
                    fileChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public void transForm(){
        FileChannel fromChannel=null;
        FileChannel toChannel=null;
        try {
            RandomAccessFile from=new RandomAccessFile("H:/java/logs/error.log","rw");
            RandomAccessFile to=new RandomAccessFile("H:/java/logs/info.log","rw");
            fromChannel=from.getChannel();
            toChannel=to.getChannel();
            fromChannel.transferTo(0,from.length(),toChannel);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fromChannel != null&&toChannel!=null){
                try {
                    fromChannel.close();
                    toChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void transForm2(){
        ReadableByteChannel fromChannel=null;
        WritableByteChannel toChannel=null;
        try {
            InputStream from=new FileInputStream("H:/java/logs/error.log");
            OutputStream to=new FileOutputStream("H:/java/logs/info.log");
            fromChannel= Channels.newChannel(from);
            toChannel= Channels.newChannel(to);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fromChannel != null&&toChannel!=null){
                try {
                    fromChannel.close();
                    toChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void main(String []args){
        new NioFileTest().readFile();
    }
}
