package com.company.Ficha1;

public class Ex2 {
    long n = 127343734L;

    public Ex2() { }

    public void alineaA() {
        System.out.println("A)");
        long soma = 0;
        n = 90999L;
        long startTime = System.nanoTime();

        for (long i = 0; i < n; i++)
            for (long j = 0; j < n; j++)
                soma++;

        long endTime = System.nanoTime();

        System.out.println("Demorou: " + ((endTime-startTime)/1000000000.0) + "s");
    }

    public void alineaB() {
        System.out.print("B) ");
        long soma = 0;
        long startTime = System.nanoTime();

        for (long i = 0; i < n; i++)
            soma++;

        long endTime = System.nanoTime();

        System.out.println("Demorou: " + ((endTime-startTime)/1000000000.0) + "s");
    }

    public void alineaC() {
        System.out.print("C) ");
        long soma = 0;
        long startTime = System.nanoTime();

        for (long i = 0; i < n; i += 2)
            soma++;

        long endTime = System.nanoTime();

        System.out.println("Demorou: " + ((endTime-startTime)/1000000000.0) + "s");
    }

    public void alineaD() {
        System.out.print("D) ");
        long soma = 0;
        long startTime = System.nanoTime();

        for (long i = 0; i < 1000; i++)
            for (long j = 0; j < n; j++)
                soma++;

        long endTime = System.nanoTime();

        System.out.println("Demorou: " + ((endTime-startTime)/1000000000.0) + "s");
    }

    public void alineaE() {
        System.out.print("E) ");
        long soma = 0;
        long startTime = System.nanoTime();

        for (long i = 0; i < n; i++)
            soma++;

        for (long j = 0; j < n; j++)
            soma++;

        long endTime = System.nanoTime();

        System.out.println("Demorou: " + ((endTime-startTime)/1000000000.0) + "s");
    }

    public void alineaF() {
        System.out.print("F) ");
        long soma = 0;
        long startTime = System.nanoTime();

        if (n>20000) n = 20000;
        for (long i = 0; i < n; i++)
            for (long j = 0; j < n; j++)
                soma++;

        long endTime = System.nanoTime();

        System.out.println("Demorou: " + ((endTime-startTime)/1000000000.0) + "s");
    }

    public void alineaG() {
        System.out.print("G) ");
        long soma = 0;
        n = 90999L;
        long startTime = System.nanoTime();

        for (long i = 0; i < n; i++)
            for (long j = 0; j < n*n; j++)
                soma++;

        long endTime = System.nanoTime();

        System.out.println("Demorou: " + ((endTime-startTime)/1000000000.0) + "s");
    }

    public void alineaH() {
        System.out.print("H) ");
        long soma = 0;
        n = 90999L;
        long startTime = System.nanoTime();

        for (long i = 0; i < n; i++)
            for (long j = 0; j < i; j++)
                soma++;

        long endTime = System.nanoTime();

        System.out.println("Demorou: " + ((endTime-startTime)/1000000000.0) + "s");
    }

    public void alineaI() {
        System.out.print("I) ");
        long soma = 0;
        n = 90999L;
        long startTime = System.nanoTime();

        for (long i = 0; i < n; i++)
            for (long j = 0; j < n*n; j++)
                for (long k = 0; k < j; k++)
                    soma++;

        long endTime = System.nanoTime();

        System.out.println("Demorou: " + ((endTime-startTime)/1000000000.0) + "s");
    }

    public void alineaJ() {
        System.out.print("J) ");
        long soma = 0;
        n = 90999L;
        long startTime = System.nanoTime();

        for (long i = 0; i < n; i *= 2)
            soma++;

        long endTime = System.nanoTime();

        System.out.println("Demorou: " + ((endTime-startTime)/1000000000.0) + "s");
    }

    public void todasAlineas() {
        alineaA();
        alineaB();
        alineaC();
        alineaD();
        alineaE();
        alineaF();
        alineaG();
        alineaH();
        alineaI();
        alineaJ();
    }
}
