package uff.ic.lleme.tcc00328.s20202.exemplo.thread.threadComExecutor;

import java.util.concurrent.Callable;

public class CallableCalculaMedia implements Callable<Resultado> {

    private final Tarefa tarefa;

    public CallableCalculaMedia(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    public Resultado call() {
        double resultado = 0.0;
        for (Double numero : tarefa.notas)
            resultado += numero;
        resultado /= tarefa.notas.length;
        return new Resultado(tarefa.id, resultado);
    }

}
