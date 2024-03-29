package mediator;

import event.AppThemeChanged;
import state.DarkState;
import state.LightState;
import state.ThemeState;
import theme.DarkTheme;
import theme.LightTheme;
import theme.Theme;

public class AppMediator extends Mediator {

    private enum ThemeOptions {
        LightState, DarkState
    }

	public void handleChangeTheme(Theme currentAppTheme) {
        ThemeState currentState = currentAppTheme.getCurrentState();
        ThemeOptions themeOptions = ThemeOptions.valueOf(currentState.getClass().getSimpleName());
        switch (themeOptions) {
            case LightState:
                currentAppTheme = new LightTheme(currentAppTheme);
                break;
            case DarkState:
                currentAppTheme = new DarkTheme(currentAppTheme);
                break;
        }
        currentAppTheme.changeTheme();
        broadcast(new AppThemeChanged(currentAppTheme));
    }

    public void handleChangeTheme(Theme currentAppTheme, ThemeState currentState) {
        ThemeOptions themeOptions = ThemeOptions.valueOf(currentState.getClass().getSimpleName());
        switch (themeOptions) {
            case LightState:
                currentAppTheme = new LightTheme(currentAppTheme);
                currentAppTheme.setNewState(new DarkState());
                break;
            case DarkState:
                currentAppTheme = new DarkTheme(currentAppTheme);
                currentAppTheme.setNewState(new LightState());
                break;
        }
        currentAppTheme.changeTheme();
        broadcast(new AppThemeChanged(currentAppTheme));
    }
}
