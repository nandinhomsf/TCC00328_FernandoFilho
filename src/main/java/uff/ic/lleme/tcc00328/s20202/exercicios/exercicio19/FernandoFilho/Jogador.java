package uff.ic.lleme.tcc00328.s20202.exercicios.exercicio19.FernandoFilho;

import java.io.Serializable;

public class Jogador implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String nome;
    private Resultado resultado;
    private int jogadas;

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Resultado getResultado() {
        return this.resultado;
    }

    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
    }

    public int getJogadas() {
        return this.jogadas;
    }

    public void setJogadas(int i) {
        this.jogadas = i;
    }

}
