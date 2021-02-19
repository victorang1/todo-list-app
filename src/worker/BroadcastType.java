package worker;

import event.WorkerEvent;
import state.ThemeState;
import mediator.Mediator;

public abstract class BroadcastType {

    protected Mediator mediator;

    public BroadcastType(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract ThemeState getThemeState();
    
    public void customBroadcast() {
        mediator.broadcast(new WorkerEvent(getThemeState()));
    }
}
