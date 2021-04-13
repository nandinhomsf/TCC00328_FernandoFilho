package uff.ic.lleme.tcc00328.s20202.exercicio.exercicio12.FernandoFilho;

import java.util.Scanner;

public class Divisores {

    public static void main(String[] args) {
        Scanner xis = new Scanner(System.in);
        int n, i;
        System.out.println("Digite um número inteiro maior que 0 : ");
        n = xis.nextInt();
        xis.close();
        for (i = 1; i < n; i++)
            if (n % i == 0)
                System.out.println(i + " é um divisor de " + n);
    }
}
