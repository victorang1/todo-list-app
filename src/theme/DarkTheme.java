package theme;

import event.ToggleThemeEvent;

public class DarkTheme extends ThemeDecorator {

    public DarkTheme(Theme previousTheme) {
        super(previousTheme);
    }

    @Override
    public void changeTheme() {
        currentState = currentState.switchTheme();
        mediator.broadcast(new ToggleThemeEvent(currentState));
    }
}
