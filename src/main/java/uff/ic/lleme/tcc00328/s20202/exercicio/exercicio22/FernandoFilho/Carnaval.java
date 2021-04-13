package uff.ic.lleme.tcc00328.s20202.exercicio.exercicio22.FernandoFilho;

import java.util.ArrayList;

public class Carnaval {

    private ArrayList<Jurado> jurados;
    private EscolaDeSamba[] escolas;
    private int quantidadeDeEscolas;
    private String ano;

    public Carnaval(int quantidadeDeEscolas, String ano) {
        setAno(ano);
        setQuantidadeDeEscolas(quantidadeDeEscolas);
    }

    public EscolaDeSamba[] getEscolas() {
        return this.escolas;
    }

    public void setEscolas(EscolaDeSamba[] escolas) {
        this.escolas = escolas;
    }

    public int getQuantidadeDeEscolas() {
        return this.quantidadeDeEscolas;
    }

    public void setQuantidadeDeEscolas(int quantidadeDeEscolas) {
        this.quantidadeDeEscolas = quantidadeDeEscolas;
    }

    public String getAno() {
        return this.ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public ArrayList<Jurado> getJurados() {
        return this.jurados;
    }

    public void setJurados(ArrayList<Jurado> jurados) {
        this.jurados = jurados;
    }

}
