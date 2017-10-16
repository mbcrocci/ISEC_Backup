package com.company.Ficha2;

import java.util.Arrays;
import java.util.Random;

public class Ficha2 {
    private static boolean numExists(int[] a, int n) {
        for (int i : a)
            if ( i == n ) return true;

        return false;
    }

    private static int generateRandomInt(Random rand) {
        return rand.nextInt(1001);
    }

    private static int[] randomArray(int dim, boolean diferentes) {
        int []array = new int[dim];
        Random rand = new Random();

        for (int i = 0; i < dim; i++) {
            if (diferentes) {
                int n = generateRandomInt(rand);
                while (numExists(array, n))
                    n = generateRandomInt(rand);

                array[i] = generateRandomInt(rand);

            } else {
                array[i] = generateRandomInt(rand);
            }
        }
        return array;
    }

    public static int[] criaArraycom(int valor, int dim, boolean diferentes) {
        int[] array = randomArray(dim, diferentes);
        Random rand = new Random();
        int p = rand.nextInt(dim);
        if ( p > 0 )
            array[p] = valor;

        Arrays.sort(array);
        return array;
    }

    public static int[] criaArraysem(int valor, int dim, boolean diferentes) {
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

    public static int binSearchPosition(int []a, int valor) {
        int l = 0, h = a.length-1;
        int m;

        while ( l <= h ) {
            m = (l + h) / 2;
            if (valor > a[m])
                l = m+1;

            else if (valor < a[m])
                h = m-1;

            else return m;
        }
        return -l-1;
    }

    public static double percentagemMenor(int []a, int valor) {
        int nMenores = 0;

        for (int val : a)
            if ( val < valor )
                nMenores++;

        return (nMenores * 100) / a.length;
    }

    // Versao do prof
    public static double menores(int []a, int valor) {
        double quantos = a.length;
        int pos = binSearchPosition(a, valor);
        if (pos < 0)
            pos = -(pos + 1);

        return pos/quantos;
    }

    // does not work
    public  static int dentroIntervalo(int []a, int min, int max) {
        int posMin = binSearchPosition(a, min);
        int posMax = binSearchPosition(a, max);

        if (posMin >= 0 && posMax >= 0)
            return posMax-posMin;

        else if (posMin >= 0 && posMax < 0)
            return a.length-posMin;

        else if ( posMin < 0 && posMax >= 0)
            return a.length-posMax;

        else return 0;
    }

    public  static boolean binSearchPosNegAfterPos(int []a, int valor) {
        int l = 0,  h = a.length-1;
        int m;

        while ( l <= h ) {
            m = (l + h) / 2;
            boolean ino = (valor * a[m]) > 0;
            if ( valor < a[m] ) {
                if (ino) h = m - 1;
                else l = m + 1;

            } else if ( valor > a[m] ) {
                if ( ino ) l = m + 1;
                else h = m - 1;

            } else {
                return true;
            }
        }
        return false;
    }

    public  static int binSearchNumBiggerPos(int []a) {
        int l = 0, h = a.length-1, melhor = -1;
        int m;

        while (l <= h) {
            m = (l + h) / 2;

            if (a[m] <= m) {
                l = m + 1;

            } else if (m < a[m]) {
                melhor = m;
                h = m - 1;

            }
        }
        return melhor;
    }

    public static int binSearchNumBiggerPosN(int []a) {
        for (int i = 0; i < a.length; i++)
            if ( a[i] > i ) return i;

        return -1;
    }
}
