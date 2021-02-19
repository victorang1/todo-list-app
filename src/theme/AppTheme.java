package theme;

import state.ThemeState;
import mediator.Mediator;

public class AppTheme extends Theme {

    public AppTheme(Mediator mediator, ThemeState currentState) {
        super(mediator, currentState);
    }
    
    @Override
	public void changeTheme() {
		this.currentState = currentState.switchTheme();
    }
}
