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

            Registry r = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            RemoteTimeService timeService = new RemoteTimeService();
            r.bind("RemoteTime", timeService);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
