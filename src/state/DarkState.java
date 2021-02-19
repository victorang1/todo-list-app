package state;

import java.awt.Color;

public class DarkState implements ThemeState {
    
    @Override
    public ThemeState switchTheme() {
        return new LightState();
    }

    @Override
    public Color getBackgroundColor() {
        return Color.BLACK;
    }

    @Override
    public Color getTextColor() {
        return Color.WHITE;
    }
}
