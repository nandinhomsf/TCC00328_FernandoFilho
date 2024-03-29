package uff.ic.lleme.tcc00328.s20202.exemplo.thread.threadsDisputandoObjeto;

public class Tarefa {

    public final double[] numeros;
    public Double media = null;
    public Double soma = null;

    public Tarefa(double[] numeros) {
        this.numeros = numeros;
    }

    public synchronized void calculaMedia() {
        media = 0.;
        for (Double numero : numeros)
            media += numero;
        media /= numeros.length;
    }

    public synchronized void calculaSoma() {
        soma = 0.;
        for (Double numero : numeros)
            soma += numero;
    }

}
