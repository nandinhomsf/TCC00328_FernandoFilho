package uff.ic.lleme.tcc00328.s20202.exemplo.thread.forkJoin;

import java.util.List;
import java.util.concurrent.RecursiveAction;

public class ForkMean extends RecursiveAction {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private int inicio;
    private int fim;
    private List<Aluno> alunos;
    protected static final int tamanhoJob = 100000;

    public ForkMean(List<Aluno> alunos) {
        this.alunos = alunos;
        this.inicio = 0;
        this.fim = alunos.size();
    }

    private ForkMean(List<Aluno> alunos, int inicio, int fim) {
        this.alunos = alunos;
        this.inicio = inicio;
        this.fim = fim;
    }

    protected void computeDirectly() {
        for (int i = inicio; i < fim; i++) {
            Aluno aluno = alunos.get(i);
            aluno.situacao = (aluno.n1 + aluno.n2) / 2 >= 6 ? "aprovado" : "reprovado";
        }
    }

    @Override
    protected void compute() {
        if (fim - inicio < tamanhoJob)
            computeDirectly();
        else {
            int meio = (inicio + fim) / 2;
            invokeAll(new ForkMean(alunos, inicio, meio),
                    new ForkMean(alunos, meio, fim));
        }
    }
}
