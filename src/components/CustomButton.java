package components;

import javax.swing.JButton;

import event.ButtonEvent;
import event.Event;
import obs.Colleague;
import state.ButtonState;
import state.Disabled;

public class CustomButton extends JButton implements Colleague {

    private ButtonState state;
    
    public CustomButton(String title) {
        super(title);
        state = new Disabled();
        this.setEnabled(state.isEnabled());
    }

    @Override
    public void update(Event event) {
        if (event instanceof ButtonEvent) {
            ButtonEvent buttonEvent = (ButtonEvent) event;
            state.changeState(buttonEvent.getNewState());
            this.setEnabled(state.currentState.isEnabled());
        }
    }
}
