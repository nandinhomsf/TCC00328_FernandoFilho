package uff.ic.lleme.tcc00328.s20201.exercicios.exercicio16.FernandoFilho;

import java.util.Scanner;

public class Campeonato {

    public static void main(String[] args) {
        int M[][], n, resp;
        System.out.println("Quantos times possuem?");
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        M = new int[n][5];
        for (int i = 0; i < n; i++) {
            System.out.println("Quantos pontos ganhos possue o time " + i + " ?");
            M[i][0] = in.nextInt();
            System.out.println("Quantos jogos possue o time " + i + " ?");
            M[i][1] = in.nextInt();
            System.out.println("Quantas vitórias possue o time " + i + " ?");
            M[i][2] = in.nextInt();
            System.out.println("Qual o saldo de gol do time " + i + " ?");
            M[i][3] = in.nextInt();
            System.out.println("Quantos gols próprios possue o time " + i + " ?");
            M[i][4] = in.nextInt();
        }
        in.close();
        resp = lider(n, M);
        System.out.println("O time líder é o time " + resp);
    }

    public static int lider(int times, int[][] tabela) {
        int sp = 0, vi = 0, sg = 0, gp = 0, i, j, k, l, salvo = 0;
        for (i = 0; i < times; i++) {
            if (tabela[i][0] > sp) {
                sp = tabela[i][0];
                salvo = i;
            }
            if (tabela[i][0] == sp) {
                for (j = 0; j < times; j++) {
                    if (tabela[j][2] > vi) {
                        vi = tabela[j][2];
                        salvo = j;
                    }
                    if (tabela[j][2] == vi) {
                        for (k = 0; k < times; k++) {
                            if (tabela[k][3] > sg) {
                                sg = tabela[k][3];
                                salvo = k;
                            }
                            if (tabela[k][3] == sg) {
                                for (l = 0; l < times; l++)
                                    if (tabela[l][4] > gp) {
                                        gp = tabela[l][4];
                                        salvo = l;
                                    }
                                return salvo;
                            }
                        }
                        return salvo;
                    }
                }
                return salvo;
            }
        }
        return salvo;
    }
}
