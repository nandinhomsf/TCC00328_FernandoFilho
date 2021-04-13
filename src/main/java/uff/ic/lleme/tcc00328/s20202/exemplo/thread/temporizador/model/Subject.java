package uff.ic.lleme.tcc00328.s20202.exemplo.thread.temporizador.model;

import uff.ic.lleme.tcc00328.s20202.exemplo.thread.temporizador.view.Observer;

public interface Subject {

    void attach(Observer o);

    void deattach(Observer o);

    void notifyObservers();

}
