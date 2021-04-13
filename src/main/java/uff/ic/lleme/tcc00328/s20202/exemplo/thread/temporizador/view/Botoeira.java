package uff.ic.lleme.tcc00328.s20202.exemplo.thread.temporizador.view;

import java.awt.GridLayout;

import javax.swing.JPanel;

import uff.ic.lleme.tcc00328.s20202.exemplo.thread.temporizador.model.Temporizador;

public class Botoeira extends JPanel implements Element {

    private static final long serialVersionUID = 1L;
    private BotaoTemp myControlerBotaoReset;
    private BotaoTemp myControlerBotaoStartStop;

    public Botoeira(Temporizador temporizador) {
        setLayout(new GridLayout(1, 0));
        this.myControlerBotaoReset = new BotaoReset(temporizador);
        this.myControlerBotaoStartStop = new BotaoStartStop(temporizador);
        initComponents();
    }

    private void initComponents() {
        add(myControlerBotaoReset);
        add(myControlerBotaoStartStop);
    }

    public void accept(Visitor visitor) {
        myControlerBotaoStartStop.accept(visitor);
        myControlerBotaoReset.accept(visitor);
    }
}
