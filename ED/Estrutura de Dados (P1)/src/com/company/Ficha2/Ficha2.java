package com.company.Ficha2;

import java.util.Random;

public class Ficha2 {
    private boolean numExists(int[] a, int n) {
        for (int i : a)
            if ( i == n ) return true;

        return false;
    }

    private int[] randomArray(int dim, boolean diferentes) {
        int []array = new int[dim];
        Random rand = new Random();

        for (int i = 0; i < dim; i++) {
            if (diferentes) {
                int n = rand.nextInt();
                while (numExists(array, n))
                    n = rand.nextInt();

                array[i] = rand.nextInt();

            } else {
                array[i] = rand.nextInt();
            }
        }
        return array;
    }

    public int[] criaArraycom(int valor, int dim, boolean diferentes) {
        int[] array = randomArray(dim, diferentes);
        Random rand = new Random();
        int p = rand.nextInt(dim);
        if ( p > 0 )
            array[p] = valor;

        return array;
    }

    public int[] criaArraysem(int valor, int dim, boolean diferentes) {
        int[] array = randomArray(dim, diferentes);
        return array;
    }

    public boolean binSearchIter(int []a, int valor) {
        int l = 0, h = a.length-1;
        int m;

        while ( l <= h ) {
            m = (l + h) / 2;
            if (valor > a[m])
                l = m+1;

            else if (valor < a[m])
                h = m-1;

            else return true;

        }
        return false;
    }

    /*
    Fazer um funcao recursiva
    1 - Identificar condicao de paragem
    2 - Fazer a funcao, utilizando-a como se ja funcionasse

     */
    public  boolean binSearchRec(int []a, int valor) {
        return binSearchRec(a, valor, 0, a.length-1);
    }

    private boolean binSearchRec(int []a, int valor, int l, int h) {
        // condicao de paragem
        if (l > h)
            return false;

        int m = (l+h) / 2;

        // 2 - Criar funcao chamando-se a si propia qd necessario
        if (valor > a[m]) return binSearchRec(a, valor, m+1, h);
        else if (valor < a[m]) return binSearchRec(a, valor, l,m-1);
        else return true;
    }
/*
    public int binSearchPosition(int []a, int valor) {
        int l = 0, h = a.length-1, m;
        while (l < = h) {
            m = (l+h) / 2;
            if (valor > a[m])
                l = m+1;
            else if (valor < a[m])

        }
    }
 */
}
