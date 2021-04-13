package uff.ic.lleme.tcc00328.s20202.exemplo.thread.temporizador.view;

public class ObserverImpl implements Observer {

    public void update() {
    }

    public Object getState() {
        return state;
    }

    public void setState(Object state) {
        this.state = state;
    }
    private Object state;
}
