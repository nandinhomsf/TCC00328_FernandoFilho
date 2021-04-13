package uff.ic.lleme.tcc00328.s20202.exemplo.thread.temporizador.view;

import java.io.Serial;

public class FuncaoCronometro extends Funcao {

    @Serial
    private static final long serialVersionUID = 1L;

    public FuncaoCronometro() {
        super("Cronometro");
        setMostrador(new MostradorCronometro(200));
        setBotoeira(new Botoeira(getMostrador().getTemporizador()));
        initComponents();
    }

    private void initComponents() {
        add(getMostrador());
        add(getBotoeira());
    }
}
