package event;

public class DoneEvent extends Event {
    
    private Integer totalChecked;

    public DoneEvent(Integer totalChecked) {
        this.totalChecked = totalChecked;
    }

    public Integer getTotalChecked() {
        return totalChecked;
    }
}
