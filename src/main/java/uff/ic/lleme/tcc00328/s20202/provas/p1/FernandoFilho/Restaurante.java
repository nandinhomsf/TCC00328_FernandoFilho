package uff.ic.lleme.tcc00328.s20202.provas.p1.FernandoFilho;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Restaurante {

    public static String Cordenada = "src/main/java/uff/ic/lleme/tcc00328/s20202/provas/p1/FernandoFilho/";

    public static Prato[] pratos = new Prato[8];
    public static Pedido[] pedidos = new Pedido[5];

    public static void main(String[] args) throws IOException {
        lerPratos();
        lerPedidos();
        calcularPreco();
        calcularPercentualDePedidos();
    }

    private static void calcularPercentualDePedidos() {
        int totalPedidos = 0;
        int[] pratosQuantia = new int[pratos.length];

        for (Pedido pedido : pedidos) {
            if (pedido == null)
                break;

            for (Item item : pedido.getPedidos()) {
                if (item.getPratopedido() == null)
                    continue;
                pratosQuantia[pegarIndiceDoPrato(item.getPratopedido())] += item.getQuantidade();
                totalPedidos += item.getQuantidade();
            }
        }

        final Float[] percentual = new Float[pratos.length];
        for (int i = 0; i < pratos.length; i++) {
            if (pratos[i] == null)
                break;
            percentual[i] = (100.0f * pratosQuantia[i]) / totalPedidos;
        }

        System.out.print("Percentuais\n");
        for (int i = 0; i < pratos.length; i++) {
            if (pratos[i] == null)
                break;

            System.out.printf("O prato: " + pratos[i].getNome() + ", tem o percentual de %.2f\n", percentual[i]);
        }
    }

    private static void calcularPreco() {
        Scanner scanner = new Scanner(System.in);
        int comida;
        double valorDaConta = 0.0;
        System.out.print("Digite o pedido : ");
        comida = scanner.nextInt();
        comida--;
        Pedido pedido = pedidos[comida];
        for (Item item : pedido.getPedidos()) {
            if (item.getPratopedido() == null)
                continue;
            double precoDoItem = item.getQuantidade() * item.getPratopedido().getPreco();
            valorDaConta += precoDoItem;
        }
        System.out.printf("Total : R$ %.2f\n", valorDaConta);
        scanner.close();
    }

    private static void lerPratos() throws IOException {
        InputStream input = new FileInputStream(Cordenada + "Pratos.txt");
        Scanner in = new Scanner(input);
        int i = 0;
        while (in.hasNext()) {
            final String[] linha = in.nextLine().split("%");
            pratos[i] = new Prato();
            pratos[i].setNome(linha[1]);
            pratos[i].setPreco(Float.parseFloat(linha[0]));
            i++;
        }

        input.close();
        in.close();
    }

    private static void lerPedidos() throws IOException {
        InputStream input = new FileInputStream(Cordenada + "Pedidos.txt");
        Scanner in = new Scanner(input);

        int i = 0;
        while (in.hasNext()) {
            String[] itemsString = in.nextLine().split("%");
            Item[] items = new Item[itemsString.length];

            for (int j = 0; j < itemsString.length; j++) {
                String[] pratoString = itemsString[j].split("!");
                items[j] = new Item();
                items[j].setPratopedido(getPrato(pratoString[1]));
                items[j].setQuantidade(Integer.parseInt(pratoString[0]));
            }

            pedidos[i] = new Pedido();
            pedidos[i].setPedidos(items);
            i++;
        }

        input.close();
        in.close();
    }

    private static Prato getPrato(String nomeDoPrato) {
        for (Prato prato : pratos)
            if (prato == null)
                continue;
            else if (prato.getNome().equals(nomeDoPrato))
                return prato;
        return null;
    }

    private static int pegarIndiceDoPrato(Prato prato) {
        for (int i = 0; i < pratos.length; i++)
            if (pratos[i] == null)
                return 1;

            else if (pratos[i].getNome().equals(prato.getNome()))
                return i;

        return 1;
    }

}
