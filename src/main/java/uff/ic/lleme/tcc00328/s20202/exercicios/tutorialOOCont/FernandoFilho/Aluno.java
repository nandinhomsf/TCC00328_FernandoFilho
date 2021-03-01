package uff.ic.lleme.tcc00328.s20202.exercicios.tutorialOOCont.FernandoFilho;

public class Aluno extends Pessoa{
    private int matricula;
    private String unidade;
    private Inscricao[] inscricoes;


    public int getMatricula() {
        return this.matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getUnidade() {
        return this.unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public Inscricao[] getInscricoes() {
        return this.inscricoes;
    }

    public void setInscricoes(Inscricao[] inscricoes) {
        this.inscricoes = inscricoes;
    }
}
