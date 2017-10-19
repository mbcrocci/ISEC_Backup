package com.company;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class UDPServer {
    public static final int BUFSIZE = 4096;
    private DatagramSocket socket;

    public  UDPServer(int port) {
        try {
            socket = null;

            socket = new DatagramSocket(port);
        } catch (Exception e) {
            System.err.println("Unable to bind to port");
        }
    }

    public void run () {

        if (socket == null);

        byte []buffer = new byte[BUFSIZE];

        System.out.println("[SERVER]: Running");
        for (;;)
            try {
                DatagramPacket packet = new DatagramPacket(buffer, BUFSIZE);

                System.out.println("\n\n[SERVER]: Waiting for packet...");
                socket.receive(packet);

                System.out.println("Packet received from " + packet.getAddress() +
                        ":" + packet.getPort() + " of length " + packet.getLength());

                String recvMsg = new String(packet.getData(), 0, packet.getLength());
                System.out.println("[SERVER]: Packet content [" + recvMsg + "]");

                if (recvMsg.equalsIgnoreCase("TIME")) {

                    Calendar calendar = GregorianCalendar.getInstance();
                    String timeMsg = calendar.get(GregorianCalendar.HOUR_OF_DAY) +
                                    ":" + calendar.get(GregorianCalendar.MINUTE) +
                                    ":" + calendar.get(GregorianCalendar.SECOND);

                    packet.setData(timeMsg.getBytes());
                    packet.setLength(timeMsg.length());

                    socket.send(packet);
                    System.out.println("[SERVER]: Packet sent!");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}
