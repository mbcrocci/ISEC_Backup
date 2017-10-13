package com.company;

import java.io.*;
import java.net.*;

public class UDPClient {

    public static final int SERVICE_PORT = 7000;

    public static final int BUFSIZE = 256;

    public void run(String hostname, int port) {
        InetAddress addr = null;
        try {
            addr = InetAddress.getByName(hostname);

        } catch (UnknownHostException e) {
            System.out.println("Unable to resolve host");
            return;
        }

        try {
            DatagramSocket socket = new DatagramSocket();

            socket.setSoTimeout (2*1000);

            for (int i=0; i <= 0; i++) {
                String message = "TIME test12";
                byte[] sendbuf = message.getBytes();

                DatagramPacket packet = new DatagramPacket(sendbuf, sendbuf.length, addr, port);

                System.out.println("Waiting for packet...");

                byte[] recvbuf = new byte[BUFSIZE];
                DatagramPacket recvPacket = new DatagramPacket (recvbuf, BUFSIZE);
                boolean timeout = false;

                try {
                    socket.receive(recvPacket);
                } catch (IOException e) {
                    System.out.println("Cant receive");
                    timeout = true;
                }

                if (!timeout) {
                    System.out.println ("Packet received!");
                    System.out.println ("Details: " + recvPacket.getAddress());

                    String msg = new String (recvPacket.getData(), 0 , recvPacket.getLength());
                    System.out.println (msg);
                } else {
                    System.out.println("packet lost");
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
        } catch (SocketException e ) {

        }
    }
}
