package state;

import java.awt.Color;

public interface ThemeState {
    
    public abstract ThemeState switchTheme();
    public abstract Color getBackgroundColor();
    public abstract Color getTextColor();
}
