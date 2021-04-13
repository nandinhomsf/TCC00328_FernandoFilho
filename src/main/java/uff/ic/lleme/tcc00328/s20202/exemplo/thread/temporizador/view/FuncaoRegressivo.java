package uff.ic.lleme.tcc00328.s20202.exemplo.thread.temporizador.view;

import java.io.Serial;

public class FuncaoRegressivo extends Funcao {

    @Serial
    private static final long serialVersionUID = 1L;

    public FuncaoRegressivo() {
        super("Temporizador");
        setMostrador(new MostradorRegressivo(200));
        setBotoeira(new Botoeira(getMostrador().getTemporizador()));
        initComponents();
    }

    private void initComponents() {
        add(getMostrador());
        add(getBotoeira());
    }
}
