package event;

import state.ThemeState;

public class WorkerEvent extends Event {
    
    private ThemeState currentState;

    public WorkerEvent(ThemeState currentState) {
        this.currentState = currentState;
    }

    public ThemeState getCurrentState() {
        return currentState;
    }
}
