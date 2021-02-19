package theme;

public abstract class ThemeDecorator extends Theme {

    protected Theme previousTheme;

    public ThemeDecorator(Theme previousTheme) {
        super(previousTheme.mediator, previousTheme.currentState);
    }
}
