package uff.ic.lleme.tcc00328.s20201.exercicios.exercicio6.FernandoFilho;

import java.util.Scanner;

public class Somatorio {

    public static void main(String[] args) {
        double resp = 0;
        int i = 0, n;
        Scanner in = new Scanner(System.in);
        System.out.println("Digite um número interio positivo para o somatório dos termos :");
        n = in.nextInt();
        while (i != n) {
            resp = resp + Math.pow(-1, i) / ((2 * i) + 1);
            i++;
        }
        resp = resp * 4;
        System.out.println("O somatório dos termos deu " + resp);
        in.close();
    }
}
