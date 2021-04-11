package uff.ic.lleme.tcc00328.s20202.exercicio.exercicio5.FernandoFilho;

import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Digite um n-ésimo termo da sequência de Fibonacci :");
        int n, a = 1, b = 0, count = 0, c = 0;
        n = in.nextInt();
        while (count != n) {
            c = a + b;
            a = b;
            b = c;
            count++;
        }
        in.close();
        System.out.println("O n-ésimo termo é: " + c);
    }
}
