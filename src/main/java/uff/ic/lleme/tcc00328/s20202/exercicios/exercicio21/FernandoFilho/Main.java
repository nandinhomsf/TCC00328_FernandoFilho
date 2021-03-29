package uff.ic.lleme.tcc00328.s20202.exercicios.exercicio21.FernandoFilho;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
    public static String arquivo = "src/main/java/uff/ic/lleme/tcc00328/s20202/exercicios/exercicio21/FernandoFilho/";
    public static void main(String[] args) throws IOException {
        login();
    }

    private static void login() throws IOException {
        System.out.println("Escolha o modo de entrada : \n1-Professor\n2-Aluno");
        int num;
        Scanner in = new Scanner(System.in);
        num=in.nextInt();
        switch (num) {
        case 1:{
            System.out.println("Digite seu nome professor :(nomes no arquivo Professores.txt)");
            String nome=in.next();
            in.close();
            checaProf(nome);
            System.exit(0);
        }
        case 2:{
            System.out.println("Digite seu nome aluno :(nomes no arquivo Alunos.txt)");
            String nome=in.next();
            in.close();
            checaAluno(nome);
            System.exit(0);
        }
        default:
            System.out.println("Você digitou errado.");}
        
    }

    private static void checaAluno(String nome) throws IOException {
        InputStream input = new FileInputStream(arquivo+"Alunos.txt");
        Scanner in = new Scanner (System.in);
        in.close();
        in = new Scanner (input);
        String nome1;
        while(in.hasNext()){
            nome1=in.next();
            if (nome.equals(nome1)){
                System.out.println("Olá "+nome+", bem vindo ao seu portal de matrícula, siga uma das opções:");
                System.out.println("1-Se matricular nas matérias\n2-Alterar a matrícula");
            }
        }
        in.close();
        int a=in.nextInt();
        System.out.println(a);
        if(a==1){
            in.close();
            registromatricula(nome);
        }
        if(a==2){
            in.close();
            alteramatricula(nome);
        }
        
    }

    private static void alteramatricula(String nome) throws IOException {
        InputStream input = new FileInputStream(arquivo+"SRA.txt");
        OutputStream output = new FileOutputStream(arquivo+"SRA.txt");
        OutputStreamWriter writer = new OutputStreamWriter(output);
        BufferedWriter bw = new BufferedWriter(writer);
        Scanner in = new Scanner(input);
        Scanner on = new Scanner (System.in);
        System.out.println("Digite qual matéria gostaria de excluir :(SRA.txt)");
        String mat = on.next();
        while(in.hasNext()){
            if(in.nextLine().equals("Aluno(a) "+nome+" matriculado(a) na Disciplina "+mat)){
                bw.write("");
            } 
        }
        bw.close();
        in.close();
        on.close();
    }

    private static void registromatricula(String nome) throws IOException {
        int i=1,j=0;
        String vetor[] = new String[6];
        InputStream input = new FileInputStream(arquivo+"Disciplinas.txt");
        Scanner in = new Scanner(input);
        OutputStream output = new FileOutputStream(arquivo+"SRA.txt");
        OutputStreamWriter writer = new OutputStreamWriter(output);
        System.out.println("Disciplinas disponíveis :");
        while(in.hasNext()){
            System.out.println("Curso de "+in.nextLine());
            while(!in.nextLine().equals("\n")){
                vetor[i-1]=in.nextLine();
                System.out.println(i+"-"+vetor[i]);
                i++;
            } 
        }
        in.close();
        BufferedWriter bw = new BufferedWriter(writer);
        Scanner on= new Scanner(System.in);
        try{for(i=0;i<6;i++){
            System.out.println("Escoha aqui sua "+i+1+"ª disciplina(coloque o número)");
                j=on.nextInt();
                bw.write("Aluno(a) "+nome+" matriculado(a) na Disciplina "+vetor[j-1]);
        }}
        finally{bw.close();
        on.close();}
    }

    private static void checaProf(String nome) throws FileNotFoundException {
        String nome1;
        String turma;
        int f=0;
        InputStream input = new FileInputStream(arquivo+"Professores.txt");
        Scanner in = new Scanner (input);
        while(in.hasNext()||f!=0){
            nome1=in.next();
            if (nome.equals(nome1)){
                turma=in.next();
                System.out.println("Ola professor(a) "+nome+" vamos checar seus alunos.");
                in.close();
                f=1;
                checamatricula(nome,turma);
                System.exit(0);      
            }}
            System.out.println("Você não está registrado como um Professor.");
        in.close();
            
    }

    private static void checamatricula(String nome,String turma) throws FileNotFoundException {
        InputStream input = new FileInputStream(arquivo+"SRA.txt");
        Scanner in = new Scanner(input);
        while(in.hasNext()){
            if(nome+" "+turma==in.nextLine()){
                while(!in.nextLine().equals("\n")){
                    System.out.println(in.nextLine());
                }
                in.close();
            }
        }
    }

}