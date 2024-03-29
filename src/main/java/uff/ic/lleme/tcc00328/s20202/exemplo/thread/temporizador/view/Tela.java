package uff.ic.lleme.tcc00328.s20202.exemplo.thread.temporizador.view;

import javax.swing.JFrame;

public abstract class Tela extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public Tela(String nome) {
        super(nome);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                evt.getNewState();
                exitForm();
            }

            public void windowClosed(java.awt.event.WindowEvent evt) {
                evt.getNewState();
                System.gc();
            }
        });
    }

    public void initComponents() {
        setVisible(true);
    }

    public void exitForm() {
        System.gc();
    }
}
