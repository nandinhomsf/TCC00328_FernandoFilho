package uff.ic.lleme.tcc00328.s20202.exercicio.exercicio8.FernandoFilho;

import java.util.Scanner;

public class Primofor {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int p, i = 2, resp = 0;
        System.out.println("Digite um natural maior que 1 para saber se é primo :");
        p = in.nextInt();
        in.close();
        while (p > i) {
            if (p % i == 0) {
                resp = 1;
                break;
            }
            i++;
        }
        if (resp == 1 || p == 1)
            System.out.println(p + " não é primo");
        else
            System.out.println(p + " é primo");
    }
}
