package components;

import java.util.HashMap;

import event.Event;
import obs.Colleague;
import ui.Mediator;

public class TodoComponent implements Colleague {
    
    private Mediator mediator;
    private HashMap<Integer, Boolean> inputs;
    
    public TodoComponent(Mediator mediator) {
        this.mediator = mediator;
        this.inputs = new HashMap<Integer, Boolean>();
    }

    @Override
    public void update(Event event) {
        // TODO Auto-generated method stub
        
    }

}
