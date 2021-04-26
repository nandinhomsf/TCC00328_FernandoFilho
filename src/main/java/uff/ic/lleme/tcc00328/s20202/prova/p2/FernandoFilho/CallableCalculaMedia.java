package uff.ic.lleme.tcc00328.s20202.prova.p2.FernandoFilho;

import java.util.List;
import java.util.concurrent.Callable;

public class CallableCalculaMedia implements Callable<Double> {
    private final List<Double> lista;
    public CallableCalculaMedia(List<Double> lista) {
        this.lista = lista;
    }

    public Double call() {
        double resultado = 0.0;
        for (Double numero : lista)
            resultado += numero;
        resultado /= lista.size();
        return resultado;
    }

}
