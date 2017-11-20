package com.company;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class TCPClient implements Runnable {
    private final int MAX_DATA = 4000;
    private final int PORT;
    private String hostname;
    private String name;
    private String filename;

    public TCPClient(String name, String hostname, int port, String filename) {
        this.name = "[" + name +"] ";
        this.hostname =hostname;
        this.PORT = port;
        this.filename = filename;
    }

    @Override
    public void run() {
        try {
            InetAddress addr = InetAddress.getByName(this.hostname);
            Socket socket = new Socket(addr, PORT);

            System.out.println(this.name + "Connection established");

            InputStream in = socket.getInputStream();
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            out.println(filename);

            FileOutputStream img = new FileOutputStream(name+filename);

            int nbyte;
            byte []buff = new byte[MAX_DATA];
            while ((nbyte = in.read(buff)) > 0) {
                img.write(buff, 0, nbyte);
            }

            System.out.println(this.name + "Image Wrote");

            img.close();
            socket.close();

        } catch (Exception e) {
            System.out.println(this.name + "ERRO!!!!" + e);
        }
    }
}
