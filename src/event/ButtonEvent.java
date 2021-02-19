package event;

import state.button.ButtonState;

public class ButtonEvent extends Event {
    
    private ButtonState newButtonState;
    
    public ButtonEvent(ButtonState newButtonState) {
        this.newButtonState = newButtonState;
    }

    public ButtonState getNewState() {
        return newButtonState;
    }
}
