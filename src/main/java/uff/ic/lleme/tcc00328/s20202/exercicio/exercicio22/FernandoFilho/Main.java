package uff.ic.lleme.tcc00328.s20202.exercicio.exercicio22.FernandoFilho;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static final int qtescolas=3;
    public static final int numquesitos=5;
    public static final ArrayList<Jurado> jurados = new ArrayList<>();
    public static EscolaDeSamba[] escolas;
    public static Carnaval carnaval;
    public static void main(String[] args) {
        resgistrarNovoCarnaval();
        registrarNovoJurado();
        registrarNovaEscola(qtescolas);
        registrarNota();
        computarResultado();
    }

    public static void resgistrarNovoCarnaval() {
        carnaval = new Carnaval(3, "2021");
    }

    public static void registrarNovoJurado() {
        Jurado jurado1= new Jurado("Juan");
        Jurado jurado2 = new Jurado ("Maria");
        jurados.add(jurado1);
        jurados.add(jurado2);
    }

    public static void registrarNovaEscola(int qtescolas) {
        escolas = new EscolaDeSamba[qtescolas];
        EscolaDeSamba escola0= new EscolaDeSamba("Samba do bom");
        EscolaDeSamba escola1= new EscolaDeSamba("Exalta samba");
        EscolaDeSamba escola2= new EscolaDeSamba("Beija-flor");
        escolas[0]=escola0;
        escolas[1]=escola1;
        escolas[2]=escola2;
    }

    public static void registrarNota() {
        Scanner in = new Scanner(System.in);
        float[][] notas= new float[numquesitos][qtescolas];
        for (Jurado jurado : jurados) {
            for (int i = 0; i < numquesitos; i++) {
                for (int j = 0; j < qtescolas; j++) {
                    System.out.println(jurado.getNome() + ", digite a nota do quesito " + i + " para a escola " + escolas[j].getNome() + ":");
                    notas[i][j] = in.nextFloat();
                }
            }
            jurado.setNotas(notas);
            jurado.printMatriz(notas);
        }
       in.close();
    }

    public static void computarResultado() {
        float[][][] notas = new float[jurados.size()][numquesitos][qtescolas];
        float[] nota=new float[numquesitos];
        float[] vencedor = new float[qtescolas];
        float[] vencedoraux = new float[qtescolas];
        for(int o=0;o<jurados.size();o++){
            notas[o]=jurados.get(o).getNotas();
        }
        for(int o=0;o<jurados.size();o++){
            for(int i=0;i<numquesitos;i++){
                for(int j=0;j<qtescolas;j++){
                    nota[i]=nota[i]+notas[o][i][j];
                }
            }
        }
        for(int i=0 ; i<numquesitos; i++ ){
            nota[i]=nota[i]/qtescolas;
            nota[i]=-nota[i];
        }
        Arrays.sort(nota);
        for(int i=0;i<numquesitos;i++) {
            nota[i]=-nota[i]; 
        }

        for(int o=0;o<jurados.size();o++){
            for(int i=0;i<4;i++){
                for(int j=0;j<qtescolas;j++){
                    vencedor[j]=vencedor[j]+notas[o][i][j];
                    vencedoraux[j]=vencedoraux[j]+notas[o][i][j];
                }
            }
        }
        for(int i=0;i<qtescolas-1;i++){
            for (int j=i+1;j<qtescolas;j++){
            if(vencedor[i]==vencedoraux[j]){
                int rand = new Random().nextInt(5);
                for(int o=0;o<jurados.size();o++){
                    for(int k=rand;k<=rand;k++){
                        for(int m=0;m<qtescolas;m++){
                            vencedor[j]=vencedor[j]+notas[o][k][m];
                        }
                    }
                }

            }
        }
    }
    for(int i=0;i<qtescolas;i++){
        System.out.println("Nota da escola "+escolas[i]+":"+vencedor[i]);
    }
    }

}
