package uff.ic.lleme.tcc00328.s20202.exercicio.exercicio9.FernandoFilho;

import java.util.Scanner;

public class FibonacciFor {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Digite um n-ésimo termo da sequência de Fibonacci :");
        int n, a = 1, b = 0, count = 0, c = 0;
        n = in.nextInt();
        in.close();
        for (; count != n;) {
            c = a + b;
            a = b;
            b = c;
            count++;
        }
        System.out.println("O n-ésimo termo é: " + c);

    }

}
