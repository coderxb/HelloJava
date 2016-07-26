package com.china.gavin.javabase.net.upd;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.logging.Logger;

public class UDPServer {

    private final static Logger log = Logger.getLogger(UDPServer.class.getName());

    public static void main(String args[]) {
        DatagramSocket serverSocket = null;
        byte[] receiveData = new byte[1024];
        byte[] respData = new byte[1024];
        try {
            serverSocket = new DatagramSocket(5000);
            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);
                String sentence = new String(receivePacket.getData());
                InetAddress ipAddress = receivePacket.getAddress();
                int port = receivePacket.getPort();
                log.info("The UDP Server received information : " + sentence);
                log.info("Request Client IP = " + ipAddress + " and port = " + port);
                String respSentence =
                    "The UDP Server received PC = " + ipAddress + " send information = " + sentence.toUpperCase() + ".";
                respData = respSentence.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(respData, respData.length, ipAddress, port);
                serverSocket.send(sendPacket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            serverSocket.close();
        }
    }
}
