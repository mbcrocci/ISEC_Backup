package com.company.Ficha1;

public class Ex3 {
    public int maxSeqContv1(int []m) {
        int maxSoma = 0;
        int n = m.length;

        for (int i = 0; i<n ; i++) {
            for (int j = i; j < n; j++) {
                int estaSoma = 0;

                for (int k = i; k < j; k++)
                    estaSoma += m[k];

                if (estaSoma > maxSoma) maxSoma = estaSoma;
            }
        }
        return maxSoma;
    }

    public int maxSeqContv2(int []m) {
        int maxSoma = 0;
        int n = m.length;

        for (int i = 0; i<n ; i++) {
            int estaSoma = 0;
            for (int j = i; j < n; j++) {
                estaSoma += m[j];
                if (estaSoma > maxSoma) maxSoma = estaSoma;
            }
        }
        return maxSoma;
    }

    public int maxSeqContv3a(int []m) {
        int maxSoma = 0;
        int n = m.length;

        for (int i = 0; i<n ; i++) {
            int estaSoma = 0;
            for (int j = i; j < n; j++) {
                estaSoma += m[j];
                if (estaSoma < 0) break;

                if (estaSoma > maxSoma) maxSoma = estaSoma;
            }
        }
        return maxSoma;
    }

    public int maxSeqContv3b(int []m) {
        int maxSoma = 0;
        int n = m.length;

        for (int i = 0; i<n ; i++) {
            int estaSoma = 0;
            for (int j = i; j < n; j++) {
                estaSoma += m[j];
                if (estaSoma < 0) {
                    i = j; break;
                }

                if (estaSoma > maxSoma) maxSoma = estaSoma;
            }
        }
        return maxSoma;
    }

    public int maxSeqcontv3c(int []m) {
        int maxSoma = 0;
        int n = m.length;

        for (int i = 0; i<n ; i++) {
            int estaSoma = 0;
            for (int j = i; j < n; j++) {
                estaSoma += m[j];
                if (estaSoma > maxSoma) maxSoma = estaSoma;

                if (estaSoma < 0) estaSoma = 0;

            }
        }
        return maxSoma;
    }
}
