package uff.ic.lleme.tcc00328.s20202.exercicios.exercicio19.FernandoFilho;

import java.util.Random;

public class Dados {
    private int face1, face2;

    public int getFace1() {
        return this.face1;
    }

    public int getFace2() {
        return this.face2;
    }

    public void setFace2(int face2) {
        this.face2 = face2;
    }

    public void setFace1(int face1) {
        this.face1 = face1;
    }

    public void JogarDados() {
        Random gerador = new Random();
        this.setFace1(gerador.nextInt(6) + 1);
        this.setFace2(gerador.nextInt(6) + 1);
    }
}
