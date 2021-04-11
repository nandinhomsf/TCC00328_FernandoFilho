package uff.ic.lleme.tcc00328.s20202.exercicio.exercicio22.FernandoFilho;

public class EscolaDeSamba {

    private String nome;

    EscolaDeSamba(int chave, String nome) {
        setNome(nome);
        print();
    }


    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void print() {
        System.out.println("Nome da escola de samba: "+nome);
    }

}
