package uff.ic.lleme.tcc00328.s20202.exemplo.thread.temporizador.view;

import java.io.Serial;

public class FuncaoRelogio extends Funcao {

    @Serial
    private static final long serialVersionUID = 1L;

    public FuncaoRelogio() {
        super("Relogio");
        setMostrador(new MostradorRelogio(200));
        initComponents();
    }

    private void initComponents() {
        add(getMostrador());

    }
}
