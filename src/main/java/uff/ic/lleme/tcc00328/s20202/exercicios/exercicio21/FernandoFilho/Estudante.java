package uff.ic.lleme.tcc00328.s20202.exercicios.exercicio21.FernandoFilho;

public class Estudante extends Usuario {

    private Matricula matricula;

    public Estudante(String nome,long CPF) {
        super(nome, CPF);
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

}
