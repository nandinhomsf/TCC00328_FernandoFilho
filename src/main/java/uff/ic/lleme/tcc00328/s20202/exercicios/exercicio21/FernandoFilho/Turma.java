package uff.ic.lleme.tcc00328.s20202.exercicios.exercicio21.FernandoFilho;

public class Turma {
    private String codigo;
    private String horario;
    private Estudante[] alunos;

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getHorario() {
        return this.horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Estudante[] getAlunos() {
        return this.alunos;
    }

    public void setAlunos(Estudante[] alunos) {
        this.alunos = alunos;
    }

}
