package components;

import javax.swing.JButton;

import event.ButtonEvent;
import event.Event;
import obs.Colleague;
import state.button.ButtonState;
import state.button.Disabled;

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
            state = state.changeState(buttonEvent.getNewState());
            this.setEnabled(state.isEnabled());
        }
    }
}
