package state.button;

public abstract class ButtonState {

    public ButtonState currentState;
    
    public void changeState(ButtonState newState) {
        this.currentState = newState;
    }
    
    public abstract Boolean isEnabled();
}
