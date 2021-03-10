package uff.ic.lleme.tcc00328.s20202.exercicios.exercicio19.FernandoFilho;

public class JogoDados {
    public static void main(String[] args) {
        int ponto, soma = 0;
        Dados dados = new Dados();
        dados.JogarDados();
        System.out.println("Face do dado 1 : " + dados.getFace1() + "\nFace do dado 2 : " + dados.getFace2()
                + "\nSoma dos dados : " + (dados.getFace1() + dados.getFace2()));
        if (dados.getFace1() + dados.getFace2() == 7 || dados.getFace1() + dados.getFace2() == 11) {
            System.out.println(
                    "Você venceu o jogo , tirou " + (dados.getFace1() + dados.getFace2()) + " na primeira jogada.");
            System.exit(0);
        }
        if (dados.getFace1() + dados.getFace2() == 2 || dados.getFace1() + dados.getFace2() == 3
                || dados.getFace1() + dados.getFace2() == 12) {
            System.out.println("Você perdeu o jogo , tirou " + (dados.getFace1() + dados.getFace2()) + " nos dados.");
            System.exit(0);
        }
        ponto = dados.getFace1() + dados.getFace2();
        System.out.println("\nSeu ponto é " + ponto);
        while (ponto != soma && soma != 7) {
            dados.JogarDados();
            soma = dados.getFace1() + dados.getFace2();
            System.out.println("\nPonto : " + ponto + "\nFace do dado 1 : " + dados.getFace1() + "\nFace do dado 2 : "
                    + dados.getFace2() + "\nSoma dos dados : " + soma);
            if (ponto == soma) {
                System.out.println("Você venceu o jogo , tirou o seu ponto.");
            }
            if (7 == soma) {
                System.out.println("Você perdeu o jogo , tirou o 7.");
            }
        }

    }

}
