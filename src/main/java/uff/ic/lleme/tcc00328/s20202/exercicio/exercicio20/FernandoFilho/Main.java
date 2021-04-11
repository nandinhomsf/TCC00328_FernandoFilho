package uff.ic.lleme.tcc00328.s20202.exercicio.exercicio20.FernandoFilho;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static String arquivo = "src/main/java/uff/ic/lleme/tcc00328/s20202/exercicios/exercicio20/FernandoFilho";
    public static Cliente cliente = new Cliente();
    public static int num;

    public static void main(String[] args) throws IOException {
        reserva();
        hospedagem();
        registraQuarto();

    }

    private static void reserva() throws IOException {
        int numReservas = 1;
        String a;
        FileReader ler = new FileReader(arquivo + "/Reservas.txt");
        BufferedReader lerArq = new BufferedReader(ler);
        String linha = lerArq.readLine();
        FileWriter gravar = new FileWriter(arquivo + "/Reservas.txt");
        PrintWriter gravarArq = new PrintWriter(gravar);
        while (linha != null) {
            numReservas++;
            gravarArq.println(linha);
            linha = lerArq.readLine();
        }
        lerArq.close();
        Scanner in = new Scanner(System.in);
        System.out.println("Deseja fazer uma reserva? (S/N)");
        a = in.next();
        if (a.equals("S")) {
            gravarArq.println();
            gravarArq.println(numReservas / 9);
            System.out.println("Quantos dias você quer reservar?");
            gravarArq.println(in.nextInt());
            System.out.println("Quantos quartos simples?");
            gravarArq.println(in.nextInt());
            System.out.println("Quantos quartos duplos?");
            gravarArq.println(in.nextInt());
            System.out.println("Quantos suítes?");
            gravarArq.println(in.nextInt());
            System.out.println("Digite seu nome :");
            gravarArq.println(in.next());
            System.out.println("Digite sua identidade :");
            gravarArq.println(in.nextLong());
            System.out.println("Digite seu telefone :");
            gravarArq.println(in.nextLong());
            gravarArq.close();
            in.close();
            System.out.println("Reserva confirmada ! \nSua reserva é a de código " + numReservas / 9);
        } else {
            gravarArq.close();
            System.out.println("Reserva não cridada !");
        }
    }

    private static void hospedagem() throws IOException {
        int buscareserva;
        String a;

        FileReader ler = new FileReader(arquivo + "/Reservas.txt");
        BufferedReader lerArq = new BufferedReader(ler);
        Scanner in = new Scanner(System.in);
        String linha = lerArq.readLine();
        System.out.println("Deseja fazer uma hospedagem? (S/N)");
        a = in.next();
        if (a.equals("S")) {
            System.out.println("Possui reserva? (S/N)");
            a = in.next();
            if (a.equals("S")) {
                System.out.println("Digite a sua reserva : ");
                buscareserva = in.nextInt();
                while (Integer.parseInt(linha) != buscareserva) {
                    for (int i = 0; i < 8; i++)
                        lerArq.readLine();
                    linha = lerArq.readLine();
                }
                cliente.setReserva(buscareserva);
                num = buscareserva;
                cliente.setPeriodo(Integer.parseInt(lerArq.readLine()));
                cliente.setQuarto1(Integer.parseInt(lerArq.readLine()));
                cliente.setQuarto2(Integer.parseInt(lerArq.readLine()));
                cliente.setQuarto3(Integer.parseInt(lerArq.readLine()));
                cliente.setNome(lerArq.readLine());
                cliente.setIdentidade(Long.parseLong(lerArq.readLine()));
                cliente.setTelefone(Long.parseLong(lerArq.readLine()));
                lerArq.close();
                System.out.println("Digite sua nacionalidade :");
                cliente.setNacionalidade(in.next());
                System.out.println("Digite sua origem :");
                cliente.setOrigem(in.next());
                System.out.println("Digite seu destino :");
                cliente.setDestino(in.next());
                System.out.println("Digite seu endereço :");
                cliente.setEndereco(in.next());
            } else {
                System.out.println("Crie sua reserva agora !");
                in.close();
                reserva();
                hospedagem();
            }
            System.out.println("Deseja encerrar a estadia? (S/N)");
            a = in.next();
            if (a.equals("S")) {
                registraQuarto();
                encerramento();
                in.close();
                System.out.println("Tenha um bom dia.");
                System.exit(0);
            }
            if (a.equals("N")) {
                registraQuarto();
                System.out.println("Tenha um bom dia.");
                System.exit(0);
            }

        }
        System.out.println("Deseja encerrar a estadia? (S/N)");
        a = in.next();
        in.close();
        if (a.equals("S")) {
            registraQuarto();
            encerramento();
        }

    }

    private static void registraQuarto() throws IOException {
        Hotel trivago = new Hotel();
        int comando = 0, j = 1, count = 0, q1 = cliente.getQuarto1(), q2 = cliente.getQuarto2(),
                q3 = cliente.getQuarto3();
        FileReader ler = new FileReader(arquivo + "/Reservas.txt");
        BufferedReader lerArq = new BufferedReader(ler);
        String linha = "oi";
        FileWriter gravar = new FileWriter(arquivo + "/Quartos.txt");
        PrintWriter gravarArq = new PrintWriter(gravar);
        while (linha != null) {
            for (int i = 0; i < 9; i++) {
                linha = lerArq.readLine();
                if (i == 2) {
                    gravarArq.println("Reserva " + j + " possui " + linha + " quartos comuns");
                } else if (i == 3) {
                    gravarArq.println("Reserva " + j + " possui " + linha + " suites");
                } else if (i == 4) {
                    gravarArq.println("Reserva " + j + " possui " + linha + " quartos duplos");
                }

            }
            j++;
        }
        lerArq.close();
        gravarArq.close();
        FileReader ler1 = new FileReader(arquivo + "/Quartos.txt");
        Scanner in = new Scanner(ler1);
        while(in.hasNext()){
        try {
        int nume = in.nextInt();
        if (nume == num) {
            comando = 1;
        }
        int a = in.nextInt();
        for (; a > 0; a--) {
            while (count != 20) {
                if (trivago.simples[count] == 0 && q1 != 0) {
                    trivago.simples[count] = 1;
                    q1--;
                    if (comando == 1) {
                        System.out.println(count + " numero do quarto simples");
                    }
                    continue;
                }
                if (trivago.simples[20] == 1) {
                    System.out.println("Todos os quartos simples lotados");
                    break;
                }
                count++;
            }
        }
        count = 0;
        in.nextInt();
        int b = in.nextInt();
        for (; b > 0; b--) {
            while (count != 5) {
                if (trivago.suites[count] == 0 && q2 != 0) {
                    trivago.suites[count] = 1;
                    q2--;
                    if (comando == 1) {
                        System.out.println(count + "é o numero da suite");
                    }
                    continue;
                }
                if (trivago.suites[5] == 1) {
                    System.out.println("Todos as suites estão lotadas");
                    break;
                }
                count++;
            }
        }
        count = 0;
        in.nextInt();
        int c = in.nextInt();
        for (; c > 0; c--) {
            while (count != 10) {
                if (trivago.duplo[count] == 0 && q3 != 0) {
                    trivago.duplo[count] = 1;
                    q3--;
                    if (comando == 1) {
                        System.out.println(count + " é o numero do quarto duplo");
                    }
                    continue;
                }
                if (trivago.duplo[10] == 1) {
                    System.out.println("Todos os quartos duplos estão lotados.");
                    break;
                }
                count++;
            }
        }
        comando = 0;
    }finally{in.close();}
    }}

    private static void encerramento() throws IOException {
        FileReader ler = new FileReader(arquivo + "/Reservas.txt");
        BufferedReader lerArq = new BufferedReader(ler);
        String linha = "oi";
        FileWriter gravar = new FileWriter(arquivo + "/Reservas.txt");
        PrintWriter gravarArq = new PrintWriter(gravar);
        while (linha != null) {
            for (int i = 0; i < 9; i++) {
                linha = lerArq.readLine();
                if(Integer.parseInt(linha) == num){
                    for (int j=0;j<8;j++){
                        linha= lerArq.readLine();
                    }
                }
            gravarArq.println(linha);
            
        }
    }
    lerArq.close();
    gravarArq.close();
        FileReader ler1 = new FileReader(arquivo + "/Quartos.txt");
        Scanner in = new Scanner(ler1);
        int linha1 = 0;
        FileWriter gravar1 = new FileWriter(arquivo + "/Quartos.txt");
        PrintWriter gravarArq1 = new PrintWriter(gravar1);
        while (in.hasNext()) {
            if(in.nextInt()==num)
            for (int i = 0; i < 3; i++) {
                gravarArq1.println();
                }
            gravarArq1.println(linha1);
            
        }
        in.close();
        gravarArq1.close();
    }
 }

