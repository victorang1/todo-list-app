package event;

import state.ThemeState;
import java.awt.Color;

public class TodoAddedColorEvent extends Event {

    private ThemeState currentState;

    public TodoAddedColorEvent(ThemeState currentState) {
        this.currentState = currentState;
    }

    public Color getBackgroundColor() {
        return currentState.getBackgroundColor();
    }

    public Color getTextColor() {
        return currentState.getTextColor();
    }
}