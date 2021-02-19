package event;

import theme.Theme;

public class AppThemeChanged extends Event {
    
    private Theme newTheme;

    public AppThemeChanged(Theme newTheme) {
        this.newTheme = newTheme;
    }

    public Theme getNewTheme() {
        return newTheme;
    }
}
