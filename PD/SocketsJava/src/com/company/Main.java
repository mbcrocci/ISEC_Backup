package com.company;

public class Main {

    public static void main(String[] args) {
        //com.company.UDPClient client = new UDPClient();
        //client.run("10.65.132.252", 6001);

        UDPServer server = new UDPServer(2000);
        server.run();
    }
}
