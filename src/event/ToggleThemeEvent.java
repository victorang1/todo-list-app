package event;

import state.ThemeState;
import java.awt.Color;

public class ToggleThemeEvent extends Event {
    
    private ThemeState currentState;

    public ToggleThemeEvent(ThemeState currentState) {
        this.currentState = currentState;
    }

    public Color getBackgroundColor() {
        return currentState.getBackgroundColor();
    }

    public Color getTextColor() {
        return currentState.getTextColor();
    }
}
