package uff.ic.lleme.tcc00328.s20202.exemplo.thread.temporizador.model;

import uff.ic.lleme.tcc00328.s20202.exemplo.thread.temporizador.view.Observer;
import java.util.ArrayList;
import java.util.List;

public abstract class SubjectImpl implements Subject {

    private final List<Observer> registry = new ArrayList<>();
    private Object state;

    public void attach(Observer o) {
        registry.add(o);
        // notifyObservers();
    }

    public void deattach(Observer o) {
        registry.remove(o);
        // notifyObservers();
    }

    public void notifyObservers() {
        for (Observer o : registry)
            o.update();
    }

    public Object getState() {
        return state;
    }

    public void setState(Object state) {
        this.state = state;
    }
}
