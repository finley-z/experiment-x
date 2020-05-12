package com.finley.io.bio.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author zyf
 * @date 2017/9/20
 */
public class Sever {

    ServerSocket serverSocket;
    InputStream inputStream;
    OutputStream outputStream;

    public Sever(){
        try {
            serverSocket =new ServerSocket(80);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("客户端初始化失败！");
        }
    }

    public void handle(){
        try {
            while(true){
                Socket socket=serverSocket.accept();
                inputStream= socket.getInputStream();
                outputStream= socket.getOutputStream();
                    System.out.println("connect success!");
                    InputStreamReader reader=new InputStreamReader(inputStream);
                    BufferedReader br =new BufferedReader(reader);
                    String info=null;
                    while((info=br.readLine())!=null){
                         System.out.println("我是服务器，客户端说："+info);
                    }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void main(String[]args){
        new Sever().handle();
    }
}
