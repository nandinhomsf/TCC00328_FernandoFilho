package uff.ic.lleme.tcc00328.s20202.exercicio.exercicio22.FernandoFilho;

public class Jurado {
    
    private String nome;
    private float[][] notas;

    Jurado(String nome) {
        setNome(nome);
        print();
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float[][] getNotas() {
        return this.notas;
    }

    public void setNotas(float[][] notas) {
        this.notas = notas;
    }

    public void print() {
        System.out.println("Nome do jurado: "+nome);
    }

    public void printMatriz(float[][] notas2) {
        System.out.println("Notas :"+notas2);
    }

}
