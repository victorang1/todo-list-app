package theme;

import event.ToggleThemeEvent;

public class LightTheme extends ThemeDecorator {

    public LightTheme(Theme previousTheme) {
        super(previousTheme);
    }
    
    @Override
    public void changeTheme() {
        mediator.broadcast(new ToggleThemeEvent(currentState));
        currentState = currentState.switchTheme();
    }
    
}
