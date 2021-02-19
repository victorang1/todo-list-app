package worker;

import state.LightState;
import state.ThemeState;
import ui.Mediator;

public class LightType extends BroadcastType {
    
    public LightType(Mediator mediator) {
		super(mediator);
	}

    @Override
    public ThemeState getThemeState() {
        return new LightState();
    }
}
