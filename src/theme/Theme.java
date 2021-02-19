package theme;

import state.ThemeState;
import mediator.Mediator;

public abstract class Theme {

    protected ThemeState currentState;
    protected Mediator mediator;

    public Theme(Mediator mediator, ThemeState currentState) {
        this.mediator = mediator;
        this.currentState = currentState;
    }
    
    public abstract void changeTheme();

    public ThemeState getCurrentState() {
        return currentState;
    }
}
