package uff.ic.lleme.tcc00328.exemplo.thread.threadSimples;

import uff.ic.lleme.tcc00328.exemplo.thread.threadSimples.Tarefa;

public class ThreadCalculaMedia extends Thread {

    private Tarefa tarefa = null;

    public ThreadCalculaMedia(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    public void run() {
        tarefa.resultado = 0.0;
        for (Double numero : tarefa.numeros)
            tarefa.resultado += numero;
        tarefa.resultado /= tarefa.numeros.length;
    }

}
