package state;

public class Disabled extends ButtonState {

    @Override
    public Boolean isEnabled() {
        return false;
    }
}
