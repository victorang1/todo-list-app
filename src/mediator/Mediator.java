package mediator;

import java.util.ArrayList;

import event.Event;
import obs.Colleague;

public abstract class Mediator {

    protected ArrayList<Colleague> cols;

	public Mediator() {
		cols = new ArrayList<>();
	}

	public void attach(Colleague c) {
		cols.add(c);
	}

	public void broadcast(Event ev) {
		for (Colleague col : cols) {
			col.update(ev);
		}
	}
}
