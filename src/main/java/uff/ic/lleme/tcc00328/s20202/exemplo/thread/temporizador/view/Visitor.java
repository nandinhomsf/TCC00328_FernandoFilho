package uff.ic.lleme.tcc00328.s20202.exemplo.thread.temporizador.view;

public interface Visitor {

    void VisitBotaoStartStop(BotaoStartStop botao);

    void VisitBotaoReset(BotaoReset botao);
}
