package com.china.gavin.javabase.net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer1 {
    private static final int PORT = 5000;
    private DatagramSocket dataSocket;
    private DatagramPacket dataPacket;
    private byte receiveByte[];
    private String receiveStr;

    public UDPServer1() {
        Init();
    }

    public void Init() {
        try {
            dataSocket = new DatagramSocket(PORT);
            receiveByte = new byte[1024];
            dataPacket = new DatagramPacket(receiveByte, receiveByte.length);
            receiveStr = "";
            while (true) {
                dataSocket.receive(dataPacket);
                receiveStr = new String(receiveByte, 0, dataPacket.getLength());
                System.out.println(receiveStr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        new UDPServer1();
    }
}