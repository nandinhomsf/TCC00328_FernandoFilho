package uff.ic.lleme.tcc00328.s20202.exercicio.exercicio21.FernandoFilho;
public abstract class Usuario {

    private final String nome;
    private final long CPF;

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
