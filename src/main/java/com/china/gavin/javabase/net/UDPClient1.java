package com.china.gavin.javabase.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPClient1 {
    private static final int PORT = 5000;
    private DatagramSocket dataSocket;
    private DatagramPacket dataPacket;
    private byte sendDataByte[];
    private String sendStr;

    public UDPClient1() {
        Init();
    }

    public void Init() {
        try {
            dataSocket = new DatagramSocket(PORT + 1);
            sendDataByte = new byte[1024];
            sendStr = "UDP Client send information.";
            sendDataByte = sendStr.getBytes();
            dataPacket = new DatagramPacket(sendDataByte, sendDataByte.length, InetAddress.getByName("localhost"), PORT);
            dataSocket.send(dataPacket);
        } catch (SocketException se) {
            se.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }

    public static void main(String args[]) {
        new UDPClient1();
    }
}
