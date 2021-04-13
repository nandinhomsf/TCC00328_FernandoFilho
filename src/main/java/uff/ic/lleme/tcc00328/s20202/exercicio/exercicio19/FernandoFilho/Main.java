package uff.ic.lleme.tcc00328.s20202.exercicio.exercicio19.FernandoFilho;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static final Mesa mesa = new Mesa();
    public static final Jogador jogador = new Jogador();
    public static final String save = "src/main/java/uff/ic/lleme/tcc00328/s20202/exercicios/exercicio19/FernandoFilho";

    public static void main(String[] args) throws IOException {
        int ponto, soma = 0, count = 1;
        Dados dados = new Dados();
        Partida partida = new Partida();
        System.out.println("\nEscolha uma mesa [0-3]");
        Scanner in = new Scanner(System.in);
        mesa.setMesa(in.nextInt());
        dados.JogarDados();
        partida.setJogadas(count++);
        System.out.println("\nJogada : " + partida.getJogadas());
        System.out.println("Face do dado 1 : " + dados.getFace1() + "\nFace do dado 2 : " + dados.getFace2()
                + "\nSoma dos dados : " + (dados.getFace1() + dados.getFace2()));
        if (dados.getFace1() + dados.getFace2() == 7 || dados.getFace1() + dados.getFace2() == 11) {
            System.out.println(
                    "Você venceu o jogo , tirou " + (dados.getFace1() + dados.getFace2()) + " na primeira jogada.");
            jogador.setResultado(Resultado.GANHOU);
            System.out.println("\nDigite seu nome : ");
            jogador.setNome(in.next());
            jogador.setJogadas(partida.getJogadas());
            in.close();
            salvadados(save);
            System.exit(0);
        }
        if (dados.getFace1() + dados.getFace2() == 2 || dados.getFace1() + dados.getFace2() == 3
                || dados.getFace1() + dados.getFace2() == 12) {
            System.out.println("Você perdeu o jogo , tirou " + (dados.getFace1() + dados.getFace2()) + " nos dados.");
            jogador.setResultado(Resultado.PERDEU);
            System.out.println("\nDigite seu nome : ");
            jogador.setNome(in.next());
            jogador.setJogadas(partida.getJogadas());
            in.close();
            salvadados(save);
            System.exit(0);
        }
        ponto = dados.getFace1() + dados.getFace2();
        System.out.println("\nSeu ponto é " + ponto);
        while (ponto != soma && soma != 7) {
            partida.setJogadas(count++);
            System.out.println("\nJogada : " + partida.getJogadas());
            dados.JogarDados();
            soma = dados.getFace1() + dados.getFace2();
            System.out.println("\nPonto : " + ponto + "\nFace do dado 1 : " + dados.getFace1() + "\nFace do dado 2 : "
                    + dados.getFace2() + "\nSoma dos dados : " + soma);
            if (ponto == soma) {
                System.out.println("Você venceu o jogo , tirou o seu ponto.");
                jogador.setResultado(Resultado.GANHOU);
                System.out.println("\nDigite seu nome : ");
                jogador.setNome(in.next());
                jogador.setJogadas(partida.getJogadas());
                in.close();
                salvadados(save);
            }
            if (7 == soma) {
                System.out.println("Você perdeu o jogo , tirou o 7.");
                jogador.setResultado(Resultado.PERDEU);
                System.out.println("\nDigite seu nome : ");
                jogador.setNome(in.next());
                jogador.setJogadas(partida.getJogadas());
                in.close();
                salvadados(save);
            }
        }

    }

    public static void salvadados(String arquivo) throws IOException {
        FileReader oxi = new FileReader(arquivo + "/save.txt");
        BufferedReader lerArq = new BufferedReader(oxi);
        String linha = lerArq.readLine();
        FileWriter arq = new FileWriter(arquivo + "/save.txt");
        PrintWriter gravarArq = new PrintWriter(arq);
        while (linha != null) {
            gravarArq.println(linha);
            linha = lerArq.readLine();
        }
        lerArq.close();
        gravarArq.println("Mesa : " + mesa.getMesa());
        gravarArq.println("Nome do jogador : " + jogador.getNome());
        gravarArq.println("Jogadas do jogador : " + jogador.getJogadas());
        gravarArq.println("Resultado do jogador : " + jogador.getResultado());
        gravarArq.printf("\n");
        arq.close();
    }

}