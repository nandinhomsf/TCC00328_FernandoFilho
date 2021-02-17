package uff.ic.lleme.tcc00328.s20202.exercicios.exercicio11.FernandoFilho;

public class ProdutoInternoPrimos {

    public static void main(String[] args) {
        int j, count = 1, i;
        long resp = 1;
        while (50 >= count) {
            j = 0;
            for (i = 2; i < count; i++)
                if (count % i == 0)
                    j = 1;
            if (j != 1)
                resp = resp * count;
            count++;
        }
        System.out.println("o produto dos inteiros primos de 1 a 50 é : " + resp);
    }
}
