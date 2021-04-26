package uff.ic.lleme.tcc00328.s20202.prova.p2.FernandoFilho;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class Main2 {
    public static void main(String[] args) throws InterruptedException {

        List<Double> notas1 = geraVetorAleatorio();
        List<Double> notas2 = geraVetorAleatorio();
        List<Double> notas3 = geraVetorAleatorio();
        List<Double> notas4 = geraVetorAleatorio();
        List<Double> notas5 = geraVetorAleatorio();
        List<Double> notas6 = geraVetorAleatorio();

        Collection<List<Double>> notas = new ArrayList<>();

        notas.add(notas1);
        notas.add(notas2);
        notas.add(notas3);
        notas.add(notas4);
        notas.add(notas5);
        notas.add(notas6);

        Executor executor = Executors.newFixedThreadPool(6);
        CompletionService<Double> completionService = new ExecutorCompletionService<>(executor);

        for(List<Double> nota : notas){
            Callable<Double> callable = new CallableCalculaMedia(nota);
            completionService.submit(callable);
        }

        int received = 0;
        boolean errors = false;

        double media=0.0D;
        while (received < 6 && !errors) {
            Future<Double> resultFuture = completionService.take();
            try {
                media+=resultFuture.get();
                received++;
            } catch (Exception e) {
                errors = true;
            }
        }
        System.out.println("Media final :"+media/6);

    }
    public static List<Double> geraVetorAleatorio() {
        int limMax = 100;
        int limMin = 10;
        int tamanho = (int) (((limMax + 1) - limMin) * Math.random() + limMin);
        List<Double> numeros = new ArrayList<>();
        limMax = 10;
        limMin = 0;
        for (int i = 0; i < tamanho; i++)
            numeros.add ((((limMax + 1) - limMin) * Math.random() + limMin));
        return numeros;
    }
}
