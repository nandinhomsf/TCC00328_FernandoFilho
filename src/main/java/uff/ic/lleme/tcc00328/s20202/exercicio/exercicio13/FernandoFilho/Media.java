package uff.ic.lleme.tcc00328.s20202.exercicio.exercicio13.FernandoFilho;

import java.util.Scanner;

public class Media {

    public static void main(String[] args) {
        double resp = 0.00, media;
        int n, i;
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Quantos números possuem :");
            n = in.nextInt();
            for (i = 0; i < n; i++) {
                media = in.nextDouble();
                resp = resp + media;
            }
            resp = resp / n;
        }
        System.out.println("A média é : " + resp);
    }

}
