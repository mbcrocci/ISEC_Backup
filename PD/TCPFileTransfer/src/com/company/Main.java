package com.company;

public class Main {

    public static void main(String[] args) {
        TCPClient []clients = {
                /*new TCPClient("PROFWIREL", "10.65.132.252", 6001, "foto1.jpg"),
                new TCPClient("PROFWIRED", "10.204.128.70", 6001, "foto1.jpg"),
                new TCPClient("PROFWIREL", "10.65.132.252", 6001, "foto2.jpg"),
                new TCPClient("PROFWIRED", "10.204.128.70", 6001, "foto2.jpg"),
                new TCPClient("PROFWIREL", "10.65.132.252", 6001, "foto3.jpg"),
                new TCPClient("PROFWIRED", "10.204.128.70", 6001, "foto3.jpg"),
                new TCPClient("PROFWIREL", "10.65.132.252", 6001, "foto4.jpg"),
                new TCPClient("PROFWIRED", "10.204.128.70", 6001, "foto4.jpg"),*/
                new TCPClient("TEST", "10.204.128.70", 6001, "\\x90")
        };

        for (TCPClient client : clients)
            new Thread(client).start();
    }
}
