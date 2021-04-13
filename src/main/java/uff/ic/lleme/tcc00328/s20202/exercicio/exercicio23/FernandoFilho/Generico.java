package uff.ic.lleme.tcc00328.s20202.exercicio.exercicio23.FernandoFilho;

public class Generico<T> {

    private Object[] objetos = new Object[10];

    public void inlcuir(T objeto){
        int a=0;
        for (Object o : objetos) {
            if (o != null) {
                a++;
            }
        }
        if(a==objetos.length){
            Object[] novosObjetos = new Object[a+1];
            System.arraycopy(objetos, 0, novosObjetos, 0, a);
            objetos = novosObjetos;
            objetos[a+1]=objeto;
        }
    }

    public void remover(int x){
        int a=0,b=0;
        objetos[x]=null;
        for (Object objeto : objetos) {
            if (objeto != null) {
                a++;
            }
        }
        if(a==objetos.length/2){
            Object[] novosObjetos = new Object[a/2];
            for (Object objeto : objetos) {
                if (objeto != null) {
                    novosObjetos[b] = objeto;
                    b++;
                }
            }
            System.arraycopy(objetos, 0, novosObjetos, 0, a/2);
            objetos = novosObjetos;
        }
    }

    public  Object recuperar(int x){
        return this.objetos[x];
    }
    
}
