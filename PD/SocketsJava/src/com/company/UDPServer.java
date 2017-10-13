package com.company;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPServer {

    public void run (String args[]) {
        try {
            System.out.println("Binding to local port 2000");

            DatagramSocket socket = new DatagramSocket (2000);
            DatagramPacket packet = new DatagramPacket (new byte[256], 256);

            socket.receive(packet);

            InetAddress remote_addr = packet.getAddress();
            System.out.println ("Sent by: " + remote_addr.getHostAddress());
            System.out.println ("Sent from port: " + packet.getPort());

            ByteArrayInputStream bin = new ByteArrayInputStream (packet.getData());
            int data;
            while ((data = bin.read()) != -1)
                System.out.print((char)data);

            // String msg = new String(packet.getData(), 0, packet.getLength());
            // System.out.println(msg);
        } catch (SocketException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
