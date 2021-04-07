package uff.ic.lleme.tcc00328.s20202.exercicios.exercicio23.FernandoFilho;

public class Produto {
    private String codigo;
    private String nome;
    private float preco;

    Produto(){
        
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return this.preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
}
