package com.china.gavin.javabase.net.weather;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Receive extends JFrame implements Runnable, ActionListener {

    private static final long serialVersionUID = 1L;
    int port = 5050;
    InetAddress group;
    MulticastSocket socket; // socket sends and receives the packet.
    DatagramPacket packet;
    JButton ince = new JButton("START");
    JButton stop = new JButton("STOP");
    JTextArea inceAr = new JTextArea(10, 20);
    JTextArea inced = new JTextArea(10, 20);
    Thread thread;
    boolean b = false;
    byte[] buf = new byte[1024]; // If the message is longer than the packet's length, the message is truncated.

    public Receive() {
        super("MultiCast UDP");
        thread = new Thread(this);
        ince.addActionListener(this);
        stop.addActionListener(this);
        inceAr.setForeground(Color.blue);
        JPanel north = new JPanel();
        north.add(ince);
        north.add(stop);
        add(north, BorderLayout.NORTH);
        JPanel center = new JPanel();
        JScrollPane sp = new JScrollPane(inceAr);
        JScrollPane sp2 = new JScrollPane(inced);
        inceAr.setLineWrap(true);
        inceAr.setEditable(false);
        inced.setLineWrap(true);
        inced.setEditable(false);
        center.add(sp);
        center.add(sp2);
        add(center, BorderLayout.CENTER);
        pack(); // JFrame inherited from Window
        validate();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        try {
            socket = new MulticastSocket(port);
            // A multicast group is specified by a class D IP address
            // and by a standard UDP port number.
            // Class D IP addresses are in the range 224.0.0.0 to 239.255.255.255, inclusive.
            // The address 224.0.0.0 is reserved and should not be used.
            group = InetAddress.getByName("233.0.0.0");
            socket.joinGroup(group);
            packet = new DatagramPacket(buf, buf.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object object = e.getSource();
        if (object == ince) {
            // If this thread is already on the state "run", do nothing.
            if (!thread.isAlive()) {
                thread = new Thread(this);
                thread.start();
                ince.setBackground(Color.red);
                stop.setBackground(Color.yellow);
                b = false;
            }
        }
        if (object == stop) {
            ince.setBackground(Color.yellow);
            stop.setBackground(Color.red);
            b = true;
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                socket.receive(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }
            // String message=new String(buf);
            String message = new String(packet.getData(), 0, packet.getLength());// very important !!
            // System.out.println(message.length());
            inceAr.setText("正在接受的内容： \n" + message);
            inced.append(message + "\n");
            if (b == true) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        @SuppressWarnings("unused")
        Receive rec = new Receive();
    }
}
