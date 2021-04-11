package uff.ic.lleme.tcc00328.s20202.exercicio.tutorialOO.FernandoFilho;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

class SistemaAcademico {

    public static Aluno[] aluno = new Aluno[5];
    public static Disciplina[] disciplina = new Disciplina[5];
    public static Inscricao[] inscricoes = new Inscricao[5];

    private SistemaAcademico() {
    }

    public static void main(String[] args) throws IOException {
        carregarAlunos("src/main/java/uff/ic/lleme/tcc00328/s20202/exercicios/tutorialOO/FernandoFilho/Aluno.txt");
        carregarDisciplinas("src/main/java/uff/ic/lleme/tcc00328/s20202/exercicios/tutorialOO/FernandoFilho/Disciplina.txt");
        carregarInscricoes("src/main/java/uff/ic/lleme/tcc00328/s20202/exercicios/tutorialOO/FernandoFilho/Inscricao.txt");
        informarNotasDeAlunos();
        calcularMedias();
    }

    public static void carregarAlunos(String nomeArquivo) throws IOException {
        
        InputStream input = new FileInputStream(nomeArquivo);
        Scanner in = new Scanner(input);

        for (int i=0;i<5;i++){
            aluno[i] = new Aluno();
            aluno[i].cpf = in.nextLong();
            aluno[i].matricula = in.nextInt();
            aluno[i].unidade = in.next();
            aluno[i].nome = in.nextLine();
        } 
        input.close();
        in.close();
        
    }
    public static void carregarDisciplinas(String nomeArquivo) throws IOException {

        InputStream input = new FileInputStream(nomeArquivo);
        Scanner in = new Scanner(input);

        for(int i=0;i<5;i++){
            disciplina[i]= new Disciplina();
            disciplina[i].codigo=in.next();
            disciplina[i].sigla= in.next();
            disciplina[i].nome=in.nextLine();
        }
        input.close();
        in.close();
    }
    public static void carregarInscricoes(String nomeArquivo) throws IOException {

        InputStream input = new FileInputStream(nomeArquivo);
        Scanner in = new Scanner(input);

        for(int i=0;i<5;i++){
            inscricoes[i]= new Inscricao();
            inscricoes[i].disciplina=disciplina[i];
            in.next();
            inscricoes[i].aluno=aluno[i];
            in.next();
            inscricoes[i].data_matricula=in.next();
            inscricoes[i].data_cancelamento=in.next();
        }
        input.close();
        in.close();
    }
        private static void informarNotasDeAlunos() {
            Scanner in = new Scanner(System.in);

            int[] conjmat = new int[5];
            String[] conjcod = new String[5];

            for(int i=0;i<5;i++){
                conjmat[i]=inscricoes[i].aluno.matricula;
                conjcod[i]=inscricoes[i].disciplina.codigo;
            }

            for(int i=0;i<5;i++){
                System.out.println("Digite a nota 1 do aluno de matrícula : "+aluno[i].matricula+" da turma de código : "+disciplina[i].codigo);
                inscricoes[i].notas[0]=in.nextFloat();
                System.out.println("Digite a nota 2 :");
                inscricoes[i].notas[1]=in.nextFloat();
            }
            in.close();    
        }   
        private static void calcularMedias(){
            for(int i=0;i<5;i++){
            System.out.println("A media da matricula "+aluno[i].matricula+" na disciplina de codigo "+disciplina[i].codigo);
            System.out.println((inscricoes[i].notas[0]+inscricoes[i].notas[1])/2);
        }
    }
    
}


