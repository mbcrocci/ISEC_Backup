package com.company;

public class Main {

    public static void main(String[] args) {
        Server server = new Server();
        Client client = new Client();

        new Thread(server).start();

        try {
            Thread.sleep(1000 * 3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(client).start();
    }
}
