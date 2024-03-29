package uff.ic.lleme.tcc00328.s20202.exemplo.thread.temporizador.controller;

import uff.ic.lleme.tcc00328.s20202.exemplo.thread.temporizador.model.Temporizador;

public class StopCommand extends CommandImpl {

    public StopCommand(Temporizador t) {
        super(t);
    }

    public void execute() {
        getReceiver().serviceStop();
    }
}
