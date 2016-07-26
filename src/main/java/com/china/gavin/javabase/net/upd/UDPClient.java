package com.china.gavin.javabase.net.upd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.logging.Logger;

public class UDPClient {

    private final static Logger log = Logger.getLogger(UDPClient.class.getName());

    public static void main(String args[]) {
        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];
        try {
            BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
            DatagramSocket clientSocket = new DatagramSocket();
            InetAddress ipAddress = InetAddress.getByName("localhost");
            String sentence = inFromUser.readLine();
            sendData = sentence.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ipAddress, 5000);
            clientSocket.send(sendPacket);
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);
            String modifiedSentence = new String(receivePacket.getData());
            log.info("UDP Server response : " + modifiedSentence);
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}