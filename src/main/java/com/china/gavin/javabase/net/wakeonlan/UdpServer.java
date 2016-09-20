package com.china.gavin.javabase.net.wakeonlan;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.logging.Logger;

public class UdpServer {

    private static final Logger log = Logger.getLogger(UdpServer.class.getName());

    private byte[] buffer = new byte[1024];
    private DatagramSocket ds = null;
    private DatagramPacket packet = null;
    private InetSocketAddress socketAddress = null;

    /**
     * UDP Server Constructor
     * @param host
     * @param port
     */
    public UdpServer(String host, int port) {
        if (host == null) {
            throw new NullPointerException("Host is null.");
        }
        // socketAddress = new InetSocketAddress(host, port);
        try {
            // ds = new DatagramSocket(socketAddress);
            ds = new DatagramSocket(port);
            log.info("The UDP Server is running...");
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    /**
     * 
     * Get Timeout time.
     * <p>
     * If necessary, describe how it does and how to use it.
     * </P>
     * @author <a href="mailto:lixuebing@cienet.com.cn">lixuebing</a>
     * @return timeout
     * @throws SocketException
     */
    public final int getTimeout() throws SocketException {
        return ds.getSoTimeout();
    }

    /**
     * Set Timeout time, It must .
     * <p>
     * If necessary, describe how it does and how to use it.
     * </P>
     * @param second
     * @throws SocketException
     */
    public final void setTimeout(int second) throws SocketException {
        ds.setSoTimeout(second);
    }

    /**
     * 
     * Briefly describe what it does.
     * <p>
     * If necessary, describe how it does and how to use it.
     * </P>
     * @return info
     */
    public String receive() {
        try {
            packet = new DatagramPacket(buffer, buffer.length);
            ds.receive(packet);
            String info = new String(packet.getData(), 0, packet.getLength());
            log.info("The Server received message : " + info);
            return info;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 
     * Briefly describe what it does.
     * <p>
     * If necessary, describe how it does and how to use it.
     * </P>
     * @param info
     * @throws IOException
     */
    public void response(String info) throws IOException {
        if (packet.getAddress() == null) {
            return;
        }
        log.info("Client address : " + packet.getAddress().getHostAddress() + " , Port : " + packet.getPort());
        DatagramPacket dp = new DatagramPacket(buffer, buffer.length, packet.getAddress(), packet.getPort());
        dp.setData(info.getBytes());
        ds.send(dp);
    }

    /**
     * 
     * Briefly describe what it does.
     * <p>
     * If necessary, describe how it does and how to use it.
     * </P>
     */
    public void close() {
        ds.close();
    }

    public static void main(String[] args) {
        String serverHost = "localhost";
        int serverPort = 3344;
        try {
            UdpServer udp = new UdpServer(serverHost, serverPort);
            while (true) {
                udp.receive();
                udp.response("Hi, your message was recieved.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
