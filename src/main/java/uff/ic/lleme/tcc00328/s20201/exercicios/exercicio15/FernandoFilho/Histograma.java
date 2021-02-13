package uff.ic.lleme.tcc00328.s20201.exercicios.exercicio15.FernandoFilho;

import java.util.Scanner;

public class Histograma {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        try{
        System.out.println("Quantas categorias possuem?");
        int i,a;
        i=in.nextInt();
        float A[],B[],D[];
        A=new float[i];
        D=new float[i];
        for(a=0;a<i;a++){
            System.out.println("Digite a "+1+"ª categoria :");
            A[a]=in.nextFloat();
        }
        System.out.println("Quantos números possuem?");
        i=in.nextInt();
        B=new float[i];
        
        for(a=0;a<i;a++){
            System.out.println("Digite o "+a+"º número :");
            B[a]=in.nextFloat();
        }
        in.close();
        D=histograma(B, A);
        for(a=0;a<D.length;a++)
        System.out.println("Categoria "+(a-1)+" possui o percentual de "+D[a]/i+"%");
    }finally{in.close();}
    }

    public static float[] histograma(float[] numeros, float[] categorias){
        float R[],resp[];
        int a=-1;
        R=new float[numeros.length];
        resp=new float[categorias.length];
        for(int j=0;j<numeros.length;j++){
            R[j]=categoria(numeros[j],categorias);
            }
        for(int j=0;j<categorias.length;j++){
            resp[j]=0;
            for(int i=0;i<numeros.length;i++){
                if(R[i]==a){
                    resp[j]=resp[j]+1;
                }  
            }
            a=a+1;
            if(a==0)
                a=a+1;
        }
       return resp;
    }

    
    public static int categoria(float numero, float[] categs){
        
        for(int i=1;i<categs.length;i++){
            if(numero>=categs[i-1]&&numero<categs[i]){
                return i;
            }
        }
        return -1;
    }
}
