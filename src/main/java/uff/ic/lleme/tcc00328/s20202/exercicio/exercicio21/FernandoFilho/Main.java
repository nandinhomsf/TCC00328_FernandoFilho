package uff.ic.lleme.tcc00328.s20202.exercicio.exercicio21.FernandoFilho;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static String cordenada = "src/main/java/uff/ic/lleme/tcc00328/s20202/exercicios/exercicio21/FernandoFilho/";

    public static List<Matricula> listaDeMatriculas = new ArrayList<>();
    public static List<Disciplina> listaDeDisciplinas = new ArrayList<>();

    static {
        int i = 0;
        while (i != -1) {
            try {
                InputStream input = new FileInputStream(cordenada + "Disciplina"+i+".txt");
                Scanner in = new Scanner(input);

                String codigo = in.nextLine();
                String nomeDaDisciplina = in.nextLine();
                int prioridade = in.nextInt();


                listaDeDisciplinas.add(new Disciplina(prioridade == 1, codigo, nomeDaDisciplina));

                while (in.hasNextLine()) {
                    String codigoDaTurma = in.next();
                    String salaDaTurma = in.next();
                    String horarioDaTurma = in.next();
                    long cpfDoProfessor = in.nextLong();
                    String nomeDoProfessor = in.nextLine();

                    Professor professor = new Professor(nomeDoProfessor, cpfDoProfessor);
                    Turma turma = new Turma(professor, codigoDaTurma, salaDaTurma, horarioDaTurma);
                    listaDeDisciplinas.get(i).adicionarTurma(turma);
                }

                input.close();
                in.close();
                ++i;
            } catch (IOException ignored) {
                i = -1;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        AnalisadorMatricula analisadorMatricula = new AnalisadorMatricula();
        Scanner in = new Scanner(System.in);

        int i;
        do {
            System.out.print("Digite um número do menu a baixo :");
            System.out.println("1-Criar matricula");
            System.out.println("2-Alterar matricula");
            System.out.println("3-Consultar alunos matriculados em uma disciplina");
            System.out.println("4-Salvar sistema");
            i = in.nextInt();

            switch (i) {
                case 1 -> criarMatricula(analisadorMatricula, in);
                case 2 -> alterarMatricula(analisadorMatricula, in);
                case 3 -> consultarAlunosMatriculadosNaDisciplina(in);
                case 4 -> salvarSistema();
            }

            System.out.println("0-Encerrar programa");
        } while (i != 0);

        in.close();
    }

    private static void criarMatricula(AnalisadorMatricula analisadorMatricula,Scanner scanner) {
        scanner.nextLine();
        System.out.print("Digite seu nome :");
        String nome = scanner.nextLine();
        System.out.print("Digite seu CPF :");
        long cpf = scanner.nextLong();

        Matricula matricula = analisadorMatricula.criarMatricula(nome, cpf);
        if (matricula == null) {
            System.out.println("Estudante cadastrado com sucesso.");
            return;
        }

        analisadorMatricula.adicionarDisciplinas(matricula, scanner);
        System.out.println();
    }

    private static void alterarMatricula(AnalisadorMatricula analisadorMatricula,Scanner scanner) {
        scanner.nextLine();
        System.out.println("Matriculas cadastradas");
        int i = 0;
        for (Matricula matricula : Main.listaDeMatriculas) {
            System.out.println(i++ + "-Matricula: " + matricula.getId() + " Nome: " + matricula.getEstudante().getNome());
        }

        int id;
        do {
            System.out.print("Insira o número da matricula que deseja alterar, entre 0 e " + (Main.listaDeMatriculas.size() - 1) + ":");
            id = scanner.nextInt();
        } while (id < 0 || id >= Main.listaDeMatriculas.size());

        Matricula matricula = Main.listaDeMatriculas.get(id);

        System.out.print("Insira 0 para adicionar uma disciplina, ou outro número para remover: ");
        int op = scanner.nextInt();

        if (op == 0) {
            analisadorMatricula.adicionarDisciplinas(matricula, scanner);
        } else {
            analisadorMatricula.removerDisciplina(matricula, scanner);
        }
    }

    private static void consultarAlunosMatriculadosNaDisciplina(Scanner scanner) {
        System.out.println();
        for (Disciplina disciplina : listaDeDisciplinas) {
            System.out.println(disciplina.getCodigo() + "-" + disciplina.getNome());
        }
        System.out.print("Insira o código da disciplina: ");

        String codigo = scanner.next();
        for (Disciplina disciplina : listaDeDisciplinas) {
            if (disciplina.getCodigo().equals(codigo)) {
                for (Estudante estudante : disciplina.getAlunos()) {
                    System.out.println("Matricula: " + estudante.getMatricula().getId() + " Nome: " + estudante.getNome());
                }
            }
        }
        System.out.println();
    }

    private static void salvarSistema() {
        int i = 0;
        while (i != -1) {
            try {
                if (i >= listaDeDisciplinas.size()) {
                    break;
                }
                OutputStream output = new FileOutputStream(cordenada + "Disciplina" + i + ".txt");
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(output));
                Disciplina disciplina = listaDeDisciplinas.get(i);

                bw.write(disciplina.getCodigo());
                bw.newLine();
                bw.write(disciplina.getNome());
                bw.newLine();
                if (disciplina.getPrioridade() == Disciplina.Prioridade.PREFERENCIAL) {
                    bw.write("1");
                } else {
                    bw.write("0");
                }

                for (Turma turma : disciplina.getListaDeTurmas()) {
                    bw.newLine();
                    bw.write(turma.getCodigo() + " " + turma.getSala() + " " +
                            turma.getHorario() + " " + turma.getProfessor().getCPF() + " " +
                            turma.getProfessor().getNome());
                }

                bw.close();
                output.close();
                i++;
            }
            catch (IOException ignored) {
                i = -1;
            }
        }

        i = 0;
        while (i != -1) {
            try {
                if (i >= listaDeMatriculas.size()) {
                    break;
                }
                OutputStream output = new FileOutputStream(cordenada + "Matricula" + i + ".txt");
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(output));

                Matricula matricula = listaDeMatriculas.get(i);
                Estudante estudante = matricula.getEstudante();

                bw.write(estudante.getNome());
                bw.newLine();
                bw.write(String.valueOf(estudante.getCPF()));

                for (int j = 0; j < 4; j++) {
                    Disciplina disciplina = matricula.getDisciplinaPreferencial(j);
                    if (disciplina == null) {
                        continue;
                    }
                    bw.newLine();
                    bw.write(disciplina.getCodigo() + " " + matricula.getTurmaPreferencial(j));
                }
                for (int j = 0; j < 2; j++) {
                    Disciplina disciplina = matricula.getDisciplinasAlternativas(j);
                    if (disciplina == null) {
                        continue;
                    }
                    bw.newLine();
                    bw.write(disciplina.getCodigo() + " " + matricula.getTurmaAlternativa(j));
                }

                bw.close();
                output.close();
                ++i;
            } catch (IOException ignored) {
                i = -1;
            }
        }

    }

}
