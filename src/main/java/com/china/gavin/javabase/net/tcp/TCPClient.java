package com.china.gavin.javabase.net.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by LIXUEBING on 2016/9/20.
 */
public class TCPClient {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("127.0.0.1", 10000);
            OutputStream os = s.getOutputStream();
            os.write("TCP演示，发送数据...".getBytes());
            s.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
