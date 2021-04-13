package uff.ic.lleme.tcc00328.s20202.exemplo.thread.threadsDisputandoObjeto;

public class ThreadCalculaMedia extends Thread {

    private final Tarefa tarefa;

    public ThreadCalculaMedia(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    public void run() {
        tarefa.calculaMedia();
    }

}
