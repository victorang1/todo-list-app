package theme;

import state.ThemeState;

public abstract class ThemeDecorator extends Theme {

    protected Theme previousTheme;

    public ThemeDecorator(Theme previousTheme) {
        super(previousTheme.mediator, previousTheme.currentState);
    }
}
