package com.company;

public class Main {

    public static void main(String[] args) {
        UDPClient client = new UDPClient();
        client.run("10.65.132.252", 6001);
    }
}