package uff.ic.lleme.tcc00328.s20202.exercicios.exercicio22.FernandoFilho;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static int qtescolas=3;
    public static int numquesitos=5;
    public static ArrayList<Jurado> jurados;
    public static EscolaDeSamba[] escolas;
    public static Carnaval carnaval;
    public static void main(String[] args) {
        resgistrarNovoCarnaval();
        registrarNovoJurado(qtescolas);
        registrarNovaEscola(qtescolas);
        registrarNota();
        computarResultado();
    }

    public static void resgistrarNovoCarnaval() {
        carnaval = new Carnaval(3, "2021");
    }

    public static ArrayList<Jurado> registrarNovoJurado(int qtescolas) {
        ArrayList<Jurado> jurados = new ArrayList<Jurado>();
        Jurado jurado1= new Jurado("Juan");
        Jurado jurado2 = new Jurado ("Maria");
        jurados.add(0,jurado1);
        jurados.add(1,jurado2);
        return jurados;
    }

    public static void registrarNovaEscola(int qtescolas) {
        escolas = new EscolaDeSamba[qtescolas];
        EscolaDeSamba escola0= new EscolaDeSamba(0, "Samba do bom");
        EscolaDeSamba escola1= new EscolaDeSamba(1, "Exalta samba");
        EscolaDeSamba escola2= new EscolaDeSamba(2, "Beija-flor");
        escolas[0]=escola0;
        escolas[1]=escola1;
        escolas[2]=escola2;
    }

    public static void registrarNota() {
        Scanner in = new Scanner(System.in);
        float[][] notas= new float[numquesitos][qtescolas];
        for(int o=0;o<jurados.size();o++){
            for(int i=0;i<numquesitos;i++){
                for(int j=0;j<qtescolas;i++){
                    System.out.println(jurados.get(o).getNome()+", digite a nota do quesito "+i+" para a escola "+escolas[j].getNome()+":");
                    notas[i][j]=in.nextFloat();
                }
            }
            jurados.get(o).setNotas(notas);
            jurados.get(o).printMatriz(notas);
        }
       in.close();
    }

    public static void computarResultado() {
        float[][][] notas = new float[jurados.size()][numquesitos][qtescolas];
        float[] nota=new float[numquesitos];
        float[] mediafinal= new float[4];
        float[] vencedor = new float[qtescolas];
        float[] vencedoraux = new float[qtescolas];
        for(int o=0;o<jurados.size();o++){
            notas[o]=jurados.get(o).getNotas();
        }
        for(int o=0;o<jurados.size();o++){
            for(int i=0;i<numquesitos;i++){
                for(int j=0;j<qtescolas;i++){
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
        mediafinal[0]=nota[0];
        mediafinal[1]=nota[1];
        mediafinal[2]=nota[2];
        mediafinal[3]=nota[3];
        for(int o=0;o<jurados.size();o++){
            for(int i=0;i<4;i++){
                for(int j=0;j<qtescolas;i++){
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
                        for(int m=0;j<qtescolas;i++){
                            vencedor[j]=vencedor[j]+notas[o][k][m];
                        }
                    }
                }

            }
        }
    }
    for(int i=0;i<qtescolas-1;i++){
        System.out.println("Nota da escola "+escolas[i]+":"+vencedor[i]);
    }
    }

}
