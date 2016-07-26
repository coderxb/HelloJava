package com.china.gavin.javabase.net.upd.wakeonlan;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Logger;

public class UdpClient {

    private static final Logger log = Logger.getLogger(UdpClient.class.getName());

    private byte[] buffer = new byte[1024];
    private DatagramSocket ds = null;

    public UdpClient() throws SocketException {
        ds = new DatagramSocket();
    }

    public final DatagramPacket send(final String host, final int port, final byte[] bytes) throws IOException {
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length, InetAddress.getByName(host), port);
        ds.send(dp);
        return dp;
    }

    public final String receive(final String host, final int port) throws IOException {
        DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
        ds.receive(dp);
        String info = new String(dp.getData(), 0, dp.getLength());
        return info;
    }

    public static void main(String[] args) {
        UdpClient client;
        try {
            client = new UdpClient();
            // String serverHost = "255.255.255.255";
            String serverHost = "192.168.1.255";
            int serverPort = 3344;
            client.send(serverHost, serverPort, ("Hello World.").getBytes());
            String info = client.receive(serverHost, serverPort);
            log.info("Server response information = " + info);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
