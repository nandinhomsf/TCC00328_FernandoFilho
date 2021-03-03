package uff.ic.lleme.tcc00328.s20202.provas.p1.FernandoFilho;

public class Pedido {
    private Item[] pedidos= new Item[3];

    public Item[] getPedidos() {
        return this.pedidos;
    }
    public void setPedidos(Item[] oi){
        pedidos= oi;    
    }
}
