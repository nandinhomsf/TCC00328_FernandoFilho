package uff.ic.lleme.tcc00328.s20202.provas.p1.FernandoFilho;

import uff.ic.lleme.tcc00328.s20202.provas.p1.FernandoFilho.Prato;

public class Item {

    private int quantidade;
    private Prato pratopedido;

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Prato getPratopedido() {
        return this.pratopedido;
    }

    public void setPratopedido(Prato pratopedido) {
        this.pratopedido = pratopedido;
    }
}
