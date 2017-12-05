package com.company;

import java.rmi.Naming;
import java.rmi.Remote;

public class Client implements Runnable {
    @Override
    public void run() {
        try {
            String objectURL = "rmi://127.0.0.1/RemoteTime";

            RemoteTimeInterface timeService = (RemoteTimeInterface) Naming.lookup(objectURL);

            System.out.println("Hora remota: " + timeService.getHora());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
