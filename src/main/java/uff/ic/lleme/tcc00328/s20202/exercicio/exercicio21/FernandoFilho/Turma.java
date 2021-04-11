package uff.ic.lleme.tcc00328.s20202.exercicio.exercicio21.FernandoFilho;

public class Turma {

    private final Professor professor;

    private final String codigo;
    private final String sala;
    private final String horario;

    private int numAlunos = 0;

    public Turma(final Professor professor, final String codigo, final String sala, final String horario) {
        this.professor = professor;
        this.codigo = codigo;
        this.sala = sala;
        this.horario = horario;
    }

    public Professor getProfessor() {
        return professor;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getSala() {
        return sala;
    }

    public String getHorario() {
        return horario;
    }

    public int getNumAlunos() {
        return numAlunos;
    }

    public void adicionarAluno() {
        ++this.numAlunos;
    }

    public void removerAluno() {
        --this.numAlunos;
    }

    public boolean estaCompleta() {
        return getNumAlunos() == 30;
    }

}
