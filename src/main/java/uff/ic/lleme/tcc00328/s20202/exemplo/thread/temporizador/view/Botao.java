package uff.ic.lleme.tcc00328.s20202.exemplo.thread.temporizador.view;

import java.awt.Button;
import java.awt.event.ActionListener;

public abstract class Botao extends Button implements ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public Botao(String nome) {
        super(nome);
        addActionListener(this);
    }
}
