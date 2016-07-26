package com.china.gavin.javabase.net.upd;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
import java.util.logging.Logger;

public class Weather implements Runnable {

    private final static Logger log = Logger.getLogger(Weather.class.getName());
    String weather = "The weather is good.";
    int port = 5050;
    InetAddress ipAddress;
    MulticastSocket socket;

    public Weather() {
        try {
            ipAddress = InetAddress.getByName("233.0.0.0");
            socket = new MulticastSocket(port);
            socket.setTimeToLive(1);
            socket.joinGroup(ipAddress);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            byte[] data = weather.getBytes();
            DatagramPacket packet = new DatagramPacket(data, data.length, ipAddress, port);
            log.info(new String(data));
            try {
                socket.send(packet);
                Thread.sleep(3000);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Weather w = new Weather();
        Thread thread = new Thread(w);
        thread.start();
    }

}
