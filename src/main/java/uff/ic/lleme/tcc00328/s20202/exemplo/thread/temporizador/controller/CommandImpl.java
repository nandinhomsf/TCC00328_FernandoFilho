package uff.ic.lleme.tcc00328.s20202.exemplo.thread.temporizador.controller;

import uff.ic.lleme.tcc00328.s20202.exemplo.thread.temporizador.model.Temporizador;

public abstract class CommandImpl extends Command {

    public CommandImpl(Temporizador t) {
        super();
        receiver = t;
    }
    private final Temporizador receiver;

    public Temporizador getReceiver() {
        return receiver;
    }
}
