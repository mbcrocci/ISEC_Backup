package com.company;

import java.rmi.Naming;
import java.rmi.Remote;

public class Client implements Runnable {
    @Override
    public void run() {
        try {
            String registry = "localhost";
            // Verificar args caso necessario
            String registration = "rmi://"+registry+"/Hora";

            System.out.println("CLIENT: AINDA NAO ME LIGUEI");
            Remote remoteService = Naming.lookup(registration);
            System.out.println("CLIENT: JA ME LIGUEI");

            Hora horaService = (Hora) remoteService;

            System.out.println(horaService.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
