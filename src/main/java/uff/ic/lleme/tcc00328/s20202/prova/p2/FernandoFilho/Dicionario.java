package uff.ic.lleme.tcc00328.s20202.prova.p2.FernandoFilho;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Dicionario {
    Map<Palavra, Collection<Sinonimos>> dicionario_de_palavras = new HashMap<>();
    Map<String,Collection<Palavra>> dicionario_de_string = new HashMap<>();
    public void addPalavra(Palavra palavra, String[] significados){
        boolean verbo=palavra.grafia.endsWith("r");
        Collection<Sinonimos> sinonimos= new ArrayList<>() ;
        for(String significado: significados){
            if(verbo) {
                sinonimos.add(new Verbo(significado));
            }else{
                sinonimos.add(new Substantivo(significado));
            }
        }
        for(Sinonimos sinonimo : sinonimos){
            if(dicionario_de_string.containsKey(sinonimo.significado)){
                dicionario_de_string.get(sinonimo.significado).add(palavra);
            }else{
                Collection<Palavra> temp = new ArrayList<>();
                temp.add(palavra);
                dicionario_de_string.put(sinonimo.significado,temp);
            }
        }
        dicionario_de_palavras.put(palavra,sinonimos);
    }
    public void significados(Palavra palavra){
        int i=0;
        for(Sinonimos sinonimo:dicionario_de_palavras.get(palavra)){
            i++;
            System.out.println("Significado "+i+" : "+sinonimo.significado);
            if(sinonimo instanceof Verbo){
                System.out.println(" Verbo ");
            }
            else{
                System.out.println(" Substantivo ");
            }
        }
    }
    public void sinonimos(Palavra palavra){
        int i=0;
        for(Sinonimos sinonimo:dicionario_de_palavras.get(palavra)){
            for(Palavra palavra1:dicionario_de_string.get(sinonimo.significado)){
                if(!palavra.equals(palavra1)){
                    System.out.println("Sinonimo : "+palavra1.grafia);
                    System.out.println("Se fala : "+palavra1.fonetica);
                }
            }
        }
    }

}
