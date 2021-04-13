package uff.ic.lleme.tcc00328.s20202.exemplo.thread.temporizador.view;

import javax.swing.JFrame;
import java.io.Serial;

public class TelaPrincipal extends Tela {

    @Serial
    private static final long serialVersionUID = 8094890868473495605L;
    private static TelaPrincipal instancia = null;
    private final FuncaoRelogio funcaoRelogio;
    private final FuncaoCronometro funcaoCronometro;
    private final FuncaoRegressivo funcaoRegressivo;

    private TelaPrincipal() {
        super("Temporizador");
        funcaoRelogio = new FuncaoRelogio();
        funcaoCronometro = new FuncaoCronometro();
        funcaoRegressivo = new FuncaoRegressivo();
        initComponents();
    }

    public static void getInstance() {
        if (TelaPrincipal.instancia == null)
            TelaPrincipal.instancia = new TelaPrincipal();
    }

    public void initComponents() {
        super.initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(funcaoRelogio);
        getContentPane().add(funcaoCronometro);
        getContentPane().add(funcaoRegressivo);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));
        pack();
    }
}
