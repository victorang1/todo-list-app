package state;

import java.awt.Color;

public class LightState implements ThemeState {
    
    @Override
    public ThemeState switchTheme() {
        return new DarkState();
    }

    @Override
    public Color getBackgroundColor() {
        return Color.WHITE;
    }

    @Override
    public Color getTextColor() {
        return Color.BLACK;
    }
}
