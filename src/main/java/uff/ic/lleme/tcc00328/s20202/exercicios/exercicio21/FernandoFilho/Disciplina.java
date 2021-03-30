package uff.ic.lleme.tcc00328.s20202.exercicios.exercicio21.FernandoFilho;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {

    public enum Prioridade { PREFERENCIAL, ALTERNATIVA }

    private Prioridade prioridade;
    private String codigo;
    private String nome;

    private List<Estudante> listaDeEstudantes = new ArrayList<>();
    private List<Turma> listaDeTurmas = new ArrayList<>();

    public Disciplina(boolean prioridade,String codigo,String nome) {
        this.prioridade = prioridade ? Prioridade.PREFERENCIAL : Prioridade.ALTERNATIVA;
        this.codigo = codigo;
        this.nome = nome;
    }

    public List<Estudante> getAlunos() {
        return listaDeEstudantes;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public Turma getTurma(String codigo) {
        for (Turma entry : listaDeTurmas) {
            if (!entry.estaCompleta() && entry.getCodigo().equals(codigo)) {
                return entry;
            }
        }
        return null;
    }

    public void adicionarAluno(Estudante aluno) {
        this.listaDeEstudantes.add(aluno);
    }

    public void removerAluno(Estudante aluno) {
        this.listaDeEstudantes.remove(aluno);
    }

    public void adicionarTurma(Turma turma) {
        this.listaDeTurmas.add(turma);
    }

    public List<Turma> getListaDeTurmas() {
        return listaDeTurmas;
    }
}
