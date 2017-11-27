package com.finley.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author zyf
 * @date 2017/11/27
 */
public class Server {
    ServerSocket serverSocket;

    public Server(int port){
        try {
            this.serverSocket=new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(".....服务初始化失败......");
        }
    }

    public void service(){
        while(true){
            try {
                Socket socket=serverSocket.accept();
                InputStream inputStream;
                byte []buffer=new byte[8192];
                if(socket.isConnected()){
                    inputStream=socket.getInputStream();
                    InputStreamReader reader=new InputStreamReader(inputStream);
                    BufferedReader br =new BufferedReader(reader);
                    String info=null;
                    while((info=br.readLine())!=null){
                        System.out.println("info:"+info);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String []args){
        Server server=new Server(8080);
        server.service();
    }

}
