package com.company;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Hora extends UnicastRemoteObject implements RemoteTimeInterface {
    static final long serialVersionUID= 1L;
    protected int horas;
    protected int minutos;
    protected int segundos;

    public Hora(int  hora,  int minuto,  int  segundos) throws RemoteException{
        this.horas = hora;
        this.minutos = minuto;
        this.segundos = segundos;
    }

    public Hora getHora() {
        return this;
    }

    public int getHoras() {
        return horas;
    }

    public int getMinutos() {
        return minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    @Override
    public String toString() {
        return horas + ":" + minutos + ":" + segundos;
    }
}
