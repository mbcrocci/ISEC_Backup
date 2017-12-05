package com.company;

import java.rmi.Naming;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.RemoteRef;
import java.rmi.server.UnicastRemoteObject;

public class Server implements Runnable{
    public Server() { }

    @Override
    public void run() {
        try {
            Hora hora = new Hora(12, 32, 12);
            RemoteRef location = hora.getRef();

            String registry = "localhost";
            // Verificar args caso necessario
            String registration = "rmi://"+registry+"/Hora";

            System.out.println("SERVER: AINDA NAO REGISTEI");
            Naming.rebind(registration, hora);
            System.out.println(("SERVER: JA REGISTEI"));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
