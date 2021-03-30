package uff.ic.lleme.tcc00328.s20202.exercicios.exercicio21.FernandoFilho;

public class Professor extends Usuario {

    private String titulacao;

    public Professor(String nome,long CPF) {
        super(nome, CPF);
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

}
