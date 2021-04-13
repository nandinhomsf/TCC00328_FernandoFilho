package uff.ic.lleme.tcc00328.s20202.exemplo.thread.temporizador.view;

import java.awt.event.ActionEvent;
import java.io.Serial;

import uff.ic.lleme.tcc00328.s20202.exemplo.thread.temporizador.model.Temporizador;
import uff.ic.lleme.tcc00328.s20202.exemplo.thread.temporizador.controller.Command;
import uff.ic.lleme.tcc00328.s20202.exemplo.thread.temporizador.controller.ResetCommand;

public class BotaoReset extends BotaoTemp {

    @Serial
    private static final long serialVersionUID = -1842445485507380512L;
    private final Command tempCommand;

    public BotaoReset(Temporizador temporizador) {
        super("Reset", temporizador);
        tempCommand = new ResetCommand(temporizador);
    }

    public void actionPerformed(ActionEvent e) {
        e.getActionCommand();
        tempCommand.execute();
    }

    public void accept(Visitor visitor) {
        visitor.VisitBotaoReset(this);
    }
}
