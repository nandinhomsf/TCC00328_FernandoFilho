package uff.ic.lleme.tcc00328.exemplo.thread.temporizador.controller;

import uff.ic.lleme.tcc00328.exemplo.thread.temporizador.model.Temporizador;

public class ResetCommand extends CommandImpl {

    public void execute() {
        getReceiver().serviceReset();
    }

    public ResetCommand(Temporizador t) {
        super(t);
    }
}
