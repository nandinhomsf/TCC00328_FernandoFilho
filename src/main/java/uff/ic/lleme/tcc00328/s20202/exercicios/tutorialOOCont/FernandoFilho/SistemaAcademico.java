package uff.ic.lleme.tcc00328.s20202.exercicios.tutorialOOCont.FernandoFilho;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

class SistemaAcademico {

    public static Aluno[] aluno = new Aluno[5];
    public static Disciplina[] disciplina = new Disciplina[5];
    public static Turma[] turma = new Turma[5];
    public static Inscricao[] inscricoes = new Inscricao[5];

    private SistemaAcademico() {
    }

    public static void main(String[] args) throws IOException {
        carregarAlunos("src/main/java/uff/ic/lleme/tcc00328/s20202/exercicios/tutorialOOCont/FernandoFilho/Aluno.txt");
        carregarDisciplinas(
                "src/main/java/uff/ic/lleme/tcc00328/s20202/exercicios/tutorialOOCont/FernandoFilho/Disciplina.txt");
        carregarTurmas(
                "src/main/java/uff/ic/lleme/tcc00328/s20202/exercicios/tutorialOOCont/FernandoFilho/Inscricao.txt");
        carregarInscricoes(
                "src/main/java/uff/ic/lleme/tcc00328/s20202/exercicios/tutorialOOCont/FernandoFilho/Inscricao.txt");
        informarNotasDeAlunos();
        calcularMedias();
    }

    public static void carregarAlunos(String nomeArquivo) throws IOException {

        InputStream input = new FileInputStream(nomeArquivo);
        Scanner in = new Scanner(input);
        int i = 0;
        while (in.hasNext()) {
            aluno[i] = new Aluno();
            aluno[i].setCpf(in.nextLong());
            aluno[i].setMatricula(in.nextInt());
            aluno[i].setUnidade(in.next());
            aluno[i].setNome(in.nextLine());
            i++;
        }
        input.close();
        in.close();

    }

    public static void carregarDisciplinas(String nomeArquivo) throws IOException {

        InputStream input = new FileInputStream(nomeArquivo);
        Scanner in = new Scanner(input);
        int i = 0;
        while (in.hasNext()) {
            disciplina[i] = new Disciplina();
            disciplina[i].setCodigo(in.next());
            disciplina[i].setSigla(in.next());
            disciplina[i].setNome(in.nextLine());
            i++;
        }
        input.close();
        in.close();
    }

    private static void carregarTurmas(String nomeArquivo) throws IOException {
        InputStream input = new FileInputStream(nomeArquivo);
        Scanner in = new Scanner(input);
        int i = 0;
        while (in.hasNext()) {
            turma[i] = new Turma();
            turma[i].setCodigo(in.next());
            turma[i].setDisciplina(disciplina[i]);
            in.next();
            turma[i].setSemestre(in.nextInt());
            turma[i].setHorario(in.next());
            in.next();
            in.next();
            i++;
        }
        input.close();
        in.close();

    }

    public static void carregarInscricoes(String nomeArquivo) throws IOException {

        InputStream input = new FileInputStream(nomeArquivo);
        Scanner in = new Scanner(input);
        int i = 0;
        while (in.hasNext()) {
            inscricoes[i] = new Inscricao();
            inscricoes[i].setTurma(turma[i]);
            in.next();
            in.next();
            inscricoes[i].setAluno(aluno[i]);
            inscricoes[i].setData_matricula(in.next());
            inscricoes[i].setData_cancelamento(in.next());
            i++;
        }
        input.close();
        in.close();
    }

    private static void informarNotasDeAlunos() {
        Scanner in = new Scanner(System.in);

        int[] conjmat = new int[5];
        String[] conjcod = new String[5];

        for (int i = 0; i < 5; i++) {
            conjmat[i] = inscricoes[i].getAluno().getMatricula();
            conjcod[i] = inscricoes[i].getTurma().getDisciplina().getCodigo();
        }

        for (int i = 0; i < 5; i++) {
            System.out.println("Digite a nota 1 do aluno de matrícula " + aluno[i].getMatricula()
                    + " da turma de código : " + disciplina[i].getCodigo());
            inscricoes[i].getNotas()[0] = in.nextFloat();
            System.out.println("Digite a nota 2 :");
            inscricoes[i].getNotas()[1] = in.nextFloat();
        }
        in.close();
    }

    private static void calcularMedias() {
        for (int i = 0; i < 5; i++) {
            System.out.println("A media da matricula " + aluno[i].getMatricula() + " na disciplina de codigo "
                    + disciplina[i].getCodigo());
            System.out.println((inscricoes[i].getNotas()[0] + inscricoes[i].getNotas()[1]) / 2);
        }
    }

}
