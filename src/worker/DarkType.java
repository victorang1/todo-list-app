package worker;

import state.DarkState;
import state.ThemeState;
import ui.Mediator;

public class DarkType extends BroadcastType {
    
    public DarkType(Mediator mediator) {
		super(mediator);
	}

    @Override
    public ThemeState getThemeState() {
        return new DarkState();
    }
}
