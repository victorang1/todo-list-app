package theme;

import event.ToggleThemeEvent;

public class LightTheme extends ThemeDecorator {

    public LightTheme(Theme previousTheme) {
        super(previousTheme);
    }
    
    @Override
    public void changeTheme() {
        currentState = currentState.switchTheme();
        mediator.broadcast(new ToggleThemeEvent(currentState));
    }
    
}
