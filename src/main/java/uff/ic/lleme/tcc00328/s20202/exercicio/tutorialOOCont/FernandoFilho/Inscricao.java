package uff.ic.lleme.tcc00328.s20202.exercicio.tutorialOOCont.FernandoFilho;

public class Inscricao {
    private Aluno aluno;
    private Turma turma;
    private String data_matricula, data_cancelamento;  
    private float[] notas = new float[2];

    public Aluno getAluno() {
        return this.aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Turma getTurma() {
        return this.turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public String getData_matricula() {
        return this.data_matricula;
    }

    public void setData_matricula(String data_matricula) {
        this.data_matricula = data_matricula;
    }

    public String getData_cancelamento() {
        return this.data_cancelamento;
    }

    public void setData_cancelamento(String data_cancelamento) {
        this.data_cancelamento = data_cancelamento;
    }

    public float[] getNotas() {
        return this.notas;
    }

    public void setNotas(float[] notas) {
        this.notas = notas;
    }
}
