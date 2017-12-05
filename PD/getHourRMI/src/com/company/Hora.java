package com.company;


public class Hora {
    static final long serialVersionUID= 1L;
    protected int horas;
    protected int minutos;
    protected int segundos;

    public Hora(int  hora,  int minuto,  int  segundos) {
        this.horas = hora;
        this.minutos = minuto;
        this.segundos = segundos;
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
