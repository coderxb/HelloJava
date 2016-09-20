package com.china.gavin.javabase.net.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by LIXUEBING on 2016/9/20.
 */
public class TCPServer {

    public static void main(String[] args) {

        try {
            ServerSocket ss = new ServerSocket(10000);
            Socket s = ss.accept();
            String ip = s.getInetAddress().getHostAddress();
            System.out.println(ip + ".......connected");
            InputStream is = s.getInputStream();
            byte[] buf = new byte[1024];
            int len = is.read(buf);
            String message = new String(buf, 0, len);
            System.out.println("Receive data ==> " + message);
            s.close();
            ss.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}