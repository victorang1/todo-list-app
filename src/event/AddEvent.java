package event;

public class AddEvent extends Event {
    
    private String text;

    public AddEvent(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
