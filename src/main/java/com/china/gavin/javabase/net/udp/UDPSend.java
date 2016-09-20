package com.china.gavin.javabase.net.udp;

import java.io.IOException;
import java.net.*;

/**
 * Created by LIXUEBING on 2016/9/20.
 */
public class UDPSend {

    public static void main(String[] args) {

        try {
            DatagramSocket ds = new DatagramSocket(8888);
            String message = "UDP传输演示数据";
            byte[] buf = message.getBytes();
            DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("127.0.0.1"), 10000);
            ds.send(dp);
            ds.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}