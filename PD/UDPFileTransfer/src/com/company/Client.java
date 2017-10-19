package com.company;

import javax.xml.crypto.Data;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Client implements Runnable {

    private FileOutputStream imgOut;
    private String filename;
    private String hostname;
    private int port;
    private static final int BUFSIZE = 4000;
    private String name;

    public Client (String name, String filename, String hostname, int port) {
        this.name = name;
        this.filename = filename;
        this.imgOut = null;
        this.hostname = hostname;
        this.port = port;
    }

    public void run (){

        InetAddress addr = null;
        try {
            addr = InetAddress.getByName(hostname);
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return;
        }

        try {
            DatagramSocket socket = new DatagramSocket();
            DatagramPacket sendPacket = new DatagramPacket(filename.getBytes(), filename.length(), addr, port);
            DatagramPacket recPacket = new DatagramPacket(new byte[BUFSIZE], BUFSIZE);

            // Abrir ficheiro para escrita
            imgOut = new FileOutputStream(filename);

            System.out.println(name + ": Sending foto request...");
            socket.send(sendPacket);

            System.out.println(name + ": Preparing to receive...");

            while (recPacket.getLength() > 0) {
                socket.receive(recPacket);
                // Escreve imagem
                imgOut.write(recPacket.getData(), 0, recPacket.getLength());
                //System.out.println("Just wrote: " + recPacket.getLength() + " bytes");
            }
            System.out.println(name + ": Received everything.");

        } catch (Exception e) {
            System.out.println("Got an Exception");
        }
        finally {
            try {
                imgOut.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
