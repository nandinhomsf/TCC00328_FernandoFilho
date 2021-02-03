package uff.ic.lleme.tcc00328.s20201.exercicios.exercicio2.FernandoFilho;

import java.util.Scanner;

public class Fatorial {

    public static void main (String [] args){
        int i=1,x,a;
        Scanner in= new Scanner(System.in);
        System.out.println("Digite o número que quer saber o fatorial :");
        x = in.nextInt();
        a = x;
        while(x>1){
            a=a*(x-i);
            i--;
        }
        if(x==0){
            a=1;
        }
        System.out.println("O fatorial de "+x+" é :");
        System.out.println(a);
        in.close();
        }
        
    }