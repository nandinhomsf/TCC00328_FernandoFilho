package uff.ic.lleme.tcc00328.s20202.exercicio.exercicio23.FernandoFilho;

import java.util.List;

public class Carrinho {
    private List<Item> itens;
    public Carrinho(){
        
    }
    public List<Item> getItens(){
        return itens;
    }
    public void setItens(List<Item> itens){
        this.itens=itens;
    }
}
