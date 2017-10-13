package com.company.Ficha1;

import com.company.Ficha2.Ficha2;

public class Ex5 {
    private int[][] makeMatriz(int n) {
        int [][]matriz = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = j+i;
            }
        }
        return matriz;
    }
    private void printMatriz(int [][]m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] < 10) System.out.print(" |  " + m[i][j]);
                else              System.out.print(" | " + m[i][j]);
            }
            System.out.print((" |\n"));
        }
    }
    public void alineaA(int n, int valor) {
        int[][] matriz = makeMatriz(n);
        Ficha2 f2 = new Ficha2();
        boolean found = false;

        printMatriz(matriz);

        for (int i = 0; i < matriz.length; i++) {
            found = f2.binSearchIter(matriz[i], valor);
        }

        System.out.println("Valor: " + valor + "\tEncontrado: " + found);
    }
}
