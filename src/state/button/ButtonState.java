package state.button;

public abstract class ButtonState {
    
    public ButtonState changeState(ButtonState newState) {
        return newState;
    }
    
    public abstract Boolean isEnabled();
}
