package com.company;

public class Main {
    public static void main (String []args) {
        Client client1 = new Client("[CLIENT 1]","foto1.jpg", "10.65.132.252", 5001);
        Client client2 = new Client("[CLIENT 2]","foto2.jpg", "10.65.132.252", 5001);
        Client client3 = new Client("[CLIENT 3]","foto3.jpg", "10.65.132.252", 5001);

        new Thread(client1).start();
        new Thread(client2).start();
        new Thread(client3).start();
    }
}
