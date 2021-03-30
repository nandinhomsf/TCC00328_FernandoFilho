package uff.ic.lleme.tcc00328.s20202.exercicios.exercicio21.FernandoFilho;
public abstract class Usuario {

    private String nome;
    private long CPF;

    public Usuario(String nome,long CPF) {
        this.nome = nome;
        this.CPF = CPF;
    }

    public String getNome() {
        return nome;
    }

    public long getCPF() {
        return CPF;
    }

}
