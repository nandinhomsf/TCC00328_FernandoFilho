package uff.ic.lleme.tcc00328.s20202.prova.p2.FernandoFilho;

public class Main {
    public static final Dicionario aurelio =new Dicionario();
    public static void main(String[] args){
        Palavra livro = new Palavra("livro","lí-vrô");
        Palavra obra = new Palavra("obra","ó-bra");

        aurelio.addPalavra(livro, new String[]{"coleção de folhas de papel, impressas ou não, reunidas em cadernos cujos dorsos são unidos por " +
                "meio de cola, costura etc., formando um volume que se recobre com capa resistente.", "obra de cunho literário, artístico, científico etc. que constitui um volume [Para fins de " +
                "documentação, é uma publicação não periódica com mais de 48 páginas, além da capa.]."});
        aurelio.addPalavra(obra,new String[]{"aquilo que resulta de um trabalho, de uma ação.","obra de cunho literário, artístico, científico etc. que constitui um volume [Para fins de " +
                "documentação, é uma publicação não periódica com mais de 48 páginas, além da capa.]."});

        System.out.println("\n Significados do livro : \n");
        aurelio.significados(livro);
        System.out.println("\n");
        aurelio.sinonimos(livro);
        System.out.println("\nSignificados da obra\n");
        aurelio.significados(obra);
    }
}