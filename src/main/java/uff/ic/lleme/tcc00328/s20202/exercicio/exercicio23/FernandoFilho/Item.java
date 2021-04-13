package uff.ic.lleme.tcc00328.s20202.exercicio.exercicio23.FernandoFilho;

public class Item {
    private int quantidade;
    private Produto produto;
    
    public Item(){
        
    }
    public Produto getProduto(){
        return this.produto;
    }

    public void setProduto(Produto produto){
        this.produto = produto;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
