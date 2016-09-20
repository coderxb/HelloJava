package com.china.gavin.javabase.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created by LIXUEBING on 2016/9/20.
 */
public class UDPReceive {

    public static void main(String[] args) {
        try {
            DatagramSocket ds = new DatagramSocket(10000);
            byte[] buf = new byte[1024];
            DatagramPacket dp = new DatagramPacket(buf, buf.length);
            //ds.receive是一个阻塞式方法
            ds.receive(dp);
            String ip = dp.getAddress().getHostAddress();
            Integer port = dp.getPort();
            String message = new String(dp.getData(), 0, dp.getLength());
            System.out.println(ip + ":" + port + " -->> " + message);
            ds.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}