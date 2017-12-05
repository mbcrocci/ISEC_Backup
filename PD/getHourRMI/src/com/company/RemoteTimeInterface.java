package com.company;


public interface RemoteTimeInterface extends java.rmi.Remote {
    Hora getHora() throws java.rmi.RemoteException;
}
