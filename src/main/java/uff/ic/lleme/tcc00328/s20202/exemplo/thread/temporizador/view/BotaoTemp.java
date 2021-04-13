package uff.ic.lleme.tcc00328.s20202.exemplo.thread.temporizador.view;

import uff.ic.lleme.tcc00328.s20202.exemplo.thread.temporizador.model.Temporizador;

public abstract class BotaoTemp extends Botao implements Element {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private final Temporizador mySubjectTemporizador;

    public BotaoTemp(String nome, Temporizador temporizador) {
        super(nome);
        this.mySubjectTemporizador = temporizador;
    }

    public Temporizador getMySubjectTemporizador() {
        return mySubjectTemporizador;
    }

}
