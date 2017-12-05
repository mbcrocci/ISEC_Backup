package com.company;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Calendar;

public class RemoteTimeService extends UnicastRemoteObject implements RemoteTimeInterface {

    public RemoteTimeService() throws RemoteException {}

    @Override
    public Hora getHora() throws RemoteException {
        Calendar c = Calendar.getInstance();

        int horas = c.get(Calendar.HOUR_OF_DAY);
        int minutos = c.get(Calendar.MINUTE);
        int segundos = c.get(Calendar.SECOND);

        return new Hora(horas, minutos, segundos);
    }
}
