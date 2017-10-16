package com.company.Ficha2;

public class Ficha2Ex {
    public static void ex7() {
        int []array = {3, 7, 12, 15};
        System.out.println("Valor=" + 15 + "\tResultado=" + Ficha2.menores(array, 15));
        System.out.println("Valor=" + 14 + "\tResultado=" + Ficha2.menores(array, 14));
        System.out.println("Valor=" + 3 + "\tResultado=" + Ficha2.menores(array, 3));
        System.out.println("Valor=" + 1 + "\tResultado=" + Ficha2.menores(array, 1));
        System.out.println("Valor=" + 100 + "\tResultado=" + Ficha2.menores(array, 100));
    }

    public  static void ex8() {
        int []array = {3, 7 ,12 ,15};
        System.out.println("Valor=(0,15)" + "\tResultado=" + Ficha2.dentroIntervalo(array, 0, 15));
        System.out.println("Valor=(3, 7)" + "\tResultado=" + Ficha2.dentroIntervalo(array, 3, 7));
        System.out.println("Valor=(4,14)" + "\tResultado=" + Ficha2.dentroIntervalo(array, 4, 14));
        System.out.println("Valor=(4, 5)" + "\tResultado=" + Ficha2.dentroIntervalo(array, 4, 5));
        System.out.println("Valor=(1,100)" + "\tResultado=" + Ficha2.dentroIntervalo(array, 1, 100));
    }

    public static void ex11() {
        /*
        11 – Considere um método que recebe um array de inteiros no qual os números
             estão dispostos da seguinte forma:
             todos os números negativos se encontram em posições maiores do que os números positivos,
             e todos os número positivos e negativos se encontram ordenados entre si.
             Exemplo:  {3,6,8, -10,-3,-2,-1}
             Construa um método que procura um número no array.
         */


        int []array = {3, 6, 8, -3, -2, -1};
    }

    public static void ex12() {
        /*
        12 – Construa um método que recebe um array ordenado de inteiros, não repetidos,
         e que devolve o indice da primeira posição na qual o valor guardado é superior ao índice
          (ou -1 se esta posição não existir).
          Exemplos:
          Array: {3,7,12,15}  Resultado=0
          Array: {-3,1,7,12,15}  Resultado=2
          Array: {-15,-14,1,2,3,4}  Resultado= -1
         */

        int []array1 = {3, 7, 12, 15};
        int []array2 = {-3, 1, 7, 12, 15};
        int []array3 = {-15, -14, 1, 2, 3, 4};

        System.out.println("Array1= " + Ficha2.binSearchNumBiggerPos(array1));
        System.out.println("Array2= " + Ficha2.binSearchNumBiggerPos(array2));
        System.out.println("Array3= " + Ficha2.binSearchNumBiggerPos(array3));
    }
}
