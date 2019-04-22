package com.finley.server;

import java.io.*;
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
            System.out.println(".....服务已启动......");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(".....服务初始化失败......");
        }
    }

    public void service(){
        while(true){
            try {
                Socket socket=serverSocket.accept();
                if(socket.isConnected()){
                    new Thread(new Acceptor(socket)).start();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public boolean isBlank(String str){
        if(str==null||"".equals(str)){
            return true;
        }
        return false;
    }

    public static void main(String []args){
        Server server=new Server(8080);
        server.service();
    }

    class Acceptor implements  Runnable{
        private Socket socket;

        public Acceptor(Socket socket){
            this.socket=socket;
        }

        @Override
        public void run() {
                try {
                    InputStream inputStream;
                    OutputStream outputStream;
                    if(socket.isConnected()){
                        inputStream=socket.getInputStream();
                        outputStream= socket.getOutputStream();
                        InputStreamReader reader=new InputStreamReader(inputStream);
                        BufferedReader br =new BufferedReader(reader);
                        String info="";
                        while(!isBlank(info=br.readLine())){
                            System.out.println("info:"+info);
                        }
                        outputStream.write("HTTP/1.1 200 OK \n Server: Microsoft-IIS/4.0 \n Date: Mon, 5 Jan 2004 13:13:33 GMT \n Content-Type: text/html \n Last-Modified: Mon, 5 Jan 2004 13:13:12 GMT \n Content-Length: 112 \n <html> \n <head> \n <title>HTTP Response Example</title> \n </head> \n <body> \n Welcome to Brainy Software \n </body> \n </html>".getBytes());
                        outputStream.flush();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (socket != null){
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
        }
    }

}
