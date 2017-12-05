package com.company;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteTimeInterface extends Remote {
    Hora getHora() throws RemoteException;
}
