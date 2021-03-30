package uff.ic.lleme.tcc00328.s20202.exercicios.exercicio21.FernandoFilho;

public class Matricula {

    private Disciplina[] disciplinasPreferenciais = new Disciplina[4];
    private String[] turmasPreferencias = new String[4];

    private Disciplina[] disciplinasAlternativas = new Disciplina[2];
    private String[] turmasAlternativas = new String[2];

    private Estudante estudante;
    private long id;

    public Matricula(Estudante estudante) {
        this.estudante = estudante;
        this.id = estudante.getNome().hashCode() + estudante.getCPF();
    }

    public void removePreferencial(int id) {
        disciplinasPreferenciais[id] = null;
        turmasPreferencias[id] = null;
    }

    public void removeAlternativa(int id) {
        disciplinasAlternativas[id] = null;
        turmasAlternativas[id] = null;
    }

    public void setDisciplinasPreferenciais(Disciplina disciplina) {
        for (int i = 0; i < 4; i++) {
            if (disciplinasPreferenciais[i] == null) {
                disciplinasPreferenciais[i] = disciplina;
                break;
            }
        }
    }

    public void setTurmasPreferencias(String string) {
        for (int i = 0; i < 4; i++) {
            if (turmasPreferencias[i] == null) {
                turmasPreferencias[i] = string;
                break;
            }
        }
    }

    public Disciplina getDisciplinaPreferencial(int id) {
        return disciplinasPreferenciais[id];
    }

    public String getTurmaPreferencial(int id) {
        return turmasPreferencias[id];
    }

    public void setDisciplinasAlternativas(Disciplina disciplina) {
        for (int i = 0; i < 2; i++) {
            if (disciplinasAlternativas[i] == null) {
                disciplinasAlternativas[i] = disciplina;
                break;
            }
        }
    }

    public void setTurmasAlternativas(String string) {
        for (int i = 0; i < 2; i++) {
            if (turmasAlternativas[i] == null) {
                turmasAlternativas[i] = string;
                break;
            }
        }
    }

    public Disciplina getDisciplinasAlternativas(int id) {
        return disciplinasAlternativas[id];
    }

    public String getTurmaAlternativa(int id) {
        return turmasAlternativas[id];
    }

    public Estudante getEstudante() {
        return estudante;
    }

    public long getId() {
        return id;
    }

}
