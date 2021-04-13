package uff.ic.lleme.tcc00328.s20202.exercicio.exercicio14.FernandoFilho;

import java.util.Scanner;

public class Determinante {

    public static void main(String[] args) {
        int n, i, j;
        float[][] M;
        float resp;
        Scanner in = new Scanner(System.in);
        System.out.println("Digite o número para a matriz quadrada :");
        n = in.nextInt();
        M = new float[n][n];
        for (i = 0; i < n; i++)
            for (j = 0; j < n; j++) {
                System.out.println("Digite o número para a posição[" + (i + 1) + "][" + (j + 1) + "]");
                M[i][j] = in.nextFloat();
            }
        resp = determinante(M);
        System.out.println("O determinante é :" + resp);
    }

    public static float determinante(float[][] A) {
        float a = 0;
        int j = A[0].length;
        if (j == 1)
            return A[0][0];
        if (j == 2)
            return A[0][0] * A[1][1] - A[1][0] * A[0][1];
        for (int i = 0; i < j; i++)
            if (A[0][i] != 0)
                a += Math.pow(-1, i) * A[0][i] * determinante(submatriz(A, i, j));
        return a;
    }

    public static float[][] submatriz(float[][] A, int i, int j) {
        int a, y, z;
        float[][] B;
        B = new float[j - 1][j - 1];
        for (y = 1; y < j; y++) {
            a = 0;
            for (z = 0; z < j; z++)
                if (i != z)
                    B[y - 1][a + 1] = A[y][z];
        }
        return B;
    }
}
