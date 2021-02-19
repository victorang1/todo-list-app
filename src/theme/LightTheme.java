package theme;

import event.ToggleThemeEvent;
import state.ThemeState;

public class LightTheme extends ThemeDecorator {

    public LightTheme(Theme previousTheme) {
        super(previousTheme);
    }
    
    @Override
    public void changeTheme() {
        System.out.println("CURRENT STATE CHANGE THEME = " + currentState);
        mediator.broadcast(new ToggleThemeEvent(currentState));
        currentState = currentState.switchTheme();
    }
    
}
