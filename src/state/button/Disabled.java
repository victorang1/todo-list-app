package state.button;

public class Disabled extends ButtonState {

    @Override
    public Boolean isEnabled() {
        return false;
    }
}
