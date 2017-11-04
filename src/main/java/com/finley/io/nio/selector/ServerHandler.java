package com.finley.io.nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Iterator;

/**
 * @author zyf
 * @date 2017/9/22
 */
public class ServerHandler {
    private Selector selector;
    private int serverPort;

    public ServerHandler() {
        this(8080);
    }

    public ServerHandler(int serverPort) {
        this.serverPort = serverPort;
    }

    public void startServer() {
        try {
            selector = Selector.open();
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(serverPort));
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            while (true) {
                if (selector.selectNow() == 0) {
                    continue;
                }
                Iterator<SelectionKey> it = selector.selectedKeys().iterator();
                while (it.hasNext()) {
                    SelectionKey key = it.next();
                    if (key.isConnectable()) {
                        handleConnect(key);
                    }
                    if (key.isAcceptable()) {
                        handleAccept(key);
                    }
                    if (key.isReadable()) {
                        handleRead(key);
                    }
                    if (key.isWritable()) {
                        handleWrite(key);
                    }
                    it.remove();
                }
            }

        } catch (IOException e) {
            System.out.println("server init fail......");
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    public void handleConnect(SelectionKey key) {
        SocketChannel channel = (SocketChannel) key.channel();
        try {
            System.out.println(channel.getRemoteAddress() + " 上线了");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handleAccept(SelectionKey key) throws IOException, InterruptedException {
        ServerSocketChannel server = (ServerSocketChannel) key.channel();
        SocketChannel client = server.accept();
        client.configureBlocking(false);
        //给客户端反馈，连接成功
        System.out.print("客户端:"+client.getRemoteAddress()+"上线了");
        client.write(ByteBuffer.wrap(new String("。。。连接成功。。。").getBytes()));
        // 在客户端 连接成功之后，为了可以接收到客户端的信息，需要给通道设置读的权限
        client.register(this.selector, SelectionKey.OP_READ);
        client.register(this.selector, SelectionKey.OP_WRITE);
    }

    public void handleRead(SelectionKey key) {
        SocketChannel channel = (SocketChannel) key.channel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        CharBuffer charBuffer = CharBuffer.allocate(1024);
        CharsetDecoder decoder = Charset.defaultCharset().newDecoder();
        long length = 0;
        try {
            System.out.print("客户端:"+channel.getRemoteAddress()+"说");
            while ((length = channel.read(buffer)) > 0) {
                buffer.flip();
                while (buffer.hasRemaining()) {
                    decoder.decode(buffer, charBuffer, false);
                    charBuffer.flip();
                    System.out.print(charBuffer);
                }
            }
            if (length == -1) {
                channel.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handleWrite(SelectionKey key) {
        SocketChannel channel = (SocketChannel) key.channel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        CharsetEncoder decoder = Charset.defaultCharset().newEncoder();
        buffer.flip();
        try {
            while (buffer.hasRemaining()) {
                channel.write(buffer);
            }
            buffer.compact();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[]args){
        new ServerHandler().startServer();
    }
}
