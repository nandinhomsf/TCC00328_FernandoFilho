package uff.ic.lleme.tcc00328.s20201.exercicios.exercicio7.FernandoFilho;

import java.util.Scanner;

public class MDCfor {
    public static void main (String [] args){
        int x,y,r=1;
        Scanner in1= new Scanner(System.in);
        System.out.println("Digite o maior número para o MDC:");
        x = in1.nextInt();
        Scanner in= new Scanner(System.in);
        System.out.println("Digite o menor número para o MDC:");
        y = in.nextInt();
        System.out.println("O MDC de Euclides entre "+x+" e "+y+" é :");
        in1.close();
        in.close();
        while(r!=0){
            r=x%y;
            x=y;
            y=r;
        }
        System.out.println(x);
    }   
 }
