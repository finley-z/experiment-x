package com.finley.io.bio.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author zyf
 * @date 2017/9/20
 */
public class Client {

    Socket socket;
    InputStream inputStream;
    OutputStream outputStream;

    public Client(){
        try {
            socket=new Socket("127.0.0.1",80);
            inputStream=socket.getInputStream();
            outputStream=socket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("客户端初始化失败！");
        }
    }

    public void chat(){
        Scanner scanner=new Scanner(System.in);
        OutputStreamWriter streamWriter=new OutputStreamWriter(outputStream);
        System.out.println("请输入您要发送的内容！");
        while(scanner.hasNext()){
            String content=scanner.nextLine();
            try {
                System.out.print("content:"+content);
                streamWriter.write(content);
                streamWriter.flush();
                System.out.println("发送成功！");

            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("发送失败！");
            }
        }
    }

    public static void main(String[]args){
        new Client().chat();
    }
}
