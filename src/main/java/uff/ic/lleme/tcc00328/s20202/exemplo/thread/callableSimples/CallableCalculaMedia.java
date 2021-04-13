package uff.ic.lleme.tcc00328.s20202.exemplo.thread.callableSimples;

import java.util.concurrent.Callable;

public class CallableCalculaMedia implements Callable<Double> {

    private final double[] numeros;

    public CallableCalculaMedia(double[] numeros) {
        this.numeros = numeros;
    }

    public Double call() {
        double resultado= 0.0;
        for (Double numero : numeros)
            resultado += numero;
        return resultado /= numeros.length;
    }

}