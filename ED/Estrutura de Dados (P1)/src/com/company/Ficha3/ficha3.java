package com.company.Ficha3;

public class ficha3 {
    public static <T extends Comparable<? super T>> boolean procuraGenerica(T []a, T s) {
        int cnt = 0;
        for (T x: a)
            if (true) {
                cnt++;
                if (cnt >= 2) return true;
            }
        return false;
    }

    public class Figura implements Comparable<Figura>  {
        @Override
        public int compareTo(Figura o) {
            return 0;
        }
    }

    public class Rectangulo extends Figura {

    }
}
