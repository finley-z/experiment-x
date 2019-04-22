package com.finley.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ShutDownSocket {

    public static void main(String []args) throws IOException {

        Socket socket=new Socket("119.29.48.212",8005);
        InputStream inputStream=socket.getInputStream();
        OutputStream outputStream=socket.getOutputStream();
        outputStream.write("SHUTDOWN".getBytes());
        outputStream.flush();
        byte []buffer=new  byte[8192];
        while(inputStream.read(buffer)!=-1){
                System.out.println(new String(buffer));
                }

                }
                }
