package ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import event.DoneEvent;
import event.Event;
import event.RefreshEvent;
import obs.Colleague;

public class TodoFrame extends JFrame implements Colleague {
	private TodoInput todoInput;
	private Todos todos;
	private Actions actions;
	private Mediator mediator;
	private Integer totalDone = 0;

	public TodoFrame() {
		this.setTitle("Done: " + totalDone);

		mediator = new Form();
		mediator.attach(this);

		todoInput = new TodoInput(mediator);
		this.add(todoInput, BorderLayout.NORTH);

		todos = new Todos(mediator);
		this.add(todos, BorderLayout.CENTER);

		actions = new Actions(mediator);
		this.add(actions, BorderLayout.SOUTH);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.pack();
	}

	@Override
	public void update(Event event) {
		if (event instanceof DoneEvent) {
			DoneEvent doneEvent = (DoneEvent) event;
			totalDone += doneEvent.getTotalChecked();
			this.setTitle("Done: " + totalDone);
		}
		else if (event instanceof RefreshEvent) {
			this.pack();
		}
	}
}
