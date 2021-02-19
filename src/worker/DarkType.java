package worker;

import state.DarkState;
import state.ThemeState;
import mediator.Mediator;

public class DarkType extends BroadcastType {
    
    public DarkType(Mediator mediator) {
		super(mediator);
	}

    @Override
    public ThemeState getThemeState() {
        return new DarkState();
    }
}
