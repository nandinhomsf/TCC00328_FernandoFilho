package uff.ic.lleme.tcc00328.s20202.exercicio.exercicio21.FernandoFilho;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class AnalisadorMatricula {

    static {
        int i = 0;
        while (i != -1) {
            try {
                InputStream input = new FileInputStream(Main.cordenada + "Matricula"+i+".txt");
                Scanner in = new Scanner(input);

                String nomeDoAluno = in.nextLine();
                long CPFDoAluno = in.nextLong();
                Estudante estudante = new Estudante(nomeDoAluno, CPFDoAluno);
                Matricula matricula = new Matricula(estudante);

                estudante.setMatricula(matricula);

                while (in.hasNextLine()) {
                    String codigoDaDisciplina = in.next();
                    String turmaCodigo = in.next();

                    Disciplina disciplina = pegarDisciplina(codigoDaDisciplina);
                    assert disciplina != null;
                    Turma turma = disciplina.getTurma(turmaCodigo);
                    if (turma != null) {
                        turma.adicionarAluno();
                        disciplina.adicionarAluno(estudante);
                        if (disciplina.getPrioridade() == Disciplina.Prioridade.PREFERENCIAL) {
                            matricula.setDisciplinasPreferenciais(disciplina);
                            matricula.setTurmasPreferencias(turmaCodigo);
                        } else {
                            matricula.setDisciplinasAlternativas(disciplina);
                            matricula.setTurmasAlternativas(turmaCodigo);
                        }
                    }
                }

                Main.listaDeMatriculas.add(matricula);

                input.close();
                in.close();
                ++i;
            } catch (IOException ignored) {
                i = -1;
            }
        }
    }

    private static Disciplina pegarDisciplina(String codigo) {
        for (Disciplina entry : Main.listaDeDisciplinas) {
            if (entry.getCodigo().equals(codigo)) {
                return entry;
            }
        }
        return null;
    }

    public void adicionarDisciplinas(Matricula matricula,Scanner scanner) {
        System.out.print("Disciplinas disponíveis para matricular:");
        for (int i = 0; i < Main.listaDeDisciplinas.size(); i++) {
            Disciplina disciplina = Main.listaDeDisciplinas.get(i);
            System.out.println(i + " -" + disciplina.getNome() + "\nturmas:");
            for (Turma entry : disciplina.getListaDeTurmas()) {
                System.out.println("  " + entry.getCodigo() + " \nhorário: " + entry.getHorario() + " \nsala: " + entry.getSala() + " \nprofessor:" + entry.getProfessor().getNome());
            }
        }
        System.out.println();
        System.out.print("Insira a disciplina que você deseja inserir o aluno: ");
        Disciplina disciplina = Main.listaDeDisciplinas.get(scanner.nextInt());
        System.out.println("Insira o código da turma que você deseja inserir o aluno: ");
        Turma turma = disciplina.getTurma(scanner.next());
        if (turma.estaCompleta()) {
            System.out.println("Turma cheia.");
            System.out.println("Caso ainda deseja fazer mudanças basta editar a matricula de id: " + matricula.getId());
            return;
        }

        turma.adicionarAluno();
        disciplina.adicionarAluno(matricula.getEstudante());
        if (disciplina.getPrioridade() == Disciplina.Prioridade.PREFERENCIAL) {
            matricula.setDisciplinasPreferenciais(disciplina);
            matricula.setTurmasPreferencias(turma.getCodigo());
        } else {
            matricula.setDisciplinasAlternativas(disciplina);
            matricula.setTurmasAlternativas(turma.getCodigo());
        }
        System.out.println("Aluno inserido com sucesso na disciplina " + disciplina.getPrioridade().name());
        System.out.println("Caso ainda deseja fazer mudanças basta editar a matricula de id: " + matricula.getId());
    }

    public void removerDisciplina(Matricula matricula,Scanner scanner) {
        System.out.println("\nPreferencias:");
        for (int i = 0; i < 4; i++) {
            Disciplina disciplina = matricula.getDisciplinaPreferencial(i);
            if (disciplina == null) {
                continue;
            }
            System.out.println(disciplina.getCodigo() + "-" + disciplina.getNome() + " \nTurma: " + matricula.getTurmaPreferencial(i) + " \nID: " + i);
        }
        System.out.println("\nAlternativas:");
        for (int i = 0; i < 2; i++) {
            Disciplina disciplina = matricula.getDisciplinasAlternativas(i);
            if (disciplina == null) {
                continue;
            }
            System.out.println(disciplina.getCodigo() + "-" + disciplina.getNome() + " \nTurma: " + matricula.getTurmaAlternativa(i) + "\nID: " + i);
        }
        System.out.print("\nInsira 0 para remover o aluno de uma disciplina preferencial, ou outro numero para de uma alternativa:");
        int choice = scanner.nextInt();
        System.out.print("Insira o id da disciplina que deseja remover o aluno: ");
        int disc = scanner.nextInt();
        if (choice == 0) {
            Disciplina disciplina = matricula.getDisciplinaPreferencial(disc);
            Turma turma = disciplina.getTurma(matricula.getTurmaPreferencial(disc));

            disciplina.removerAluno(matricula.getEstudante());
            turma.removerAluno();
            matricula.removePreferencial(disc);
        } else {
            Disciplina disciplina = matricula.getDisciplinasAlternativas(disc);
            Turma turma = disciplina.getTurma(matricula.getTurmaAlternativa(disc));

            disciplina.removerAluno(matricula.getEstudante());
            turma.removerAluno();
            matricula.removeAlternativa(disc);
        }
        System.out.println("Aluno removido da disciplina.");
    }

    public Matricula criarMatricula(String nome,long cpf) {
        for (Matricula entry : Main.listaDeMatriculas) {
            if (entry.getEstudante().getCPF() == cpf) {
                return null;
            }
        }

        Estudante estudante = new Estudante(nome, cpf);
        Matricula matricula = new Matricula(estudante);
        estudante.setMatricula(matricula);
        Main.listaDeMatriculas.add(matricula);
        return matricula;
    }

}
