package uff.ic.lleme.tcc00328.s20202.exemplo.thread.threadSimples;

public class ThreadCalculaMedia extends Thread {

    private final Tarefa tarefa;

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
