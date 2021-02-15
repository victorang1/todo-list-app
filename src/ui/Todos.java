package ui;

import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import event.AddEvent;
import event.ButtonEvent;
import event.CheckedEvent;
import event.DoneClickedEvent;
import event.DoneEvent;
import event.Event;
import event.RefreshEvent;
import event.RemoveEvent;
import obs.Colleague;
import state.Disabled;
import state.Enabled;

public class Todos extends JPanel implements Colleague {
	private Mediator mediator;

	private Vector<Todo> todos;

	public Todos(Mediator mediator) {
		this.todos = new Vector<>();
		this.mediator = mediator;
		mediator.attach(this);

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		displayTodos();
	}

	public void addTodo(String text) {
		todos.add(new Todo(text, mediator));
		displayTodos();
	}

	public Integer done() {
		Integer checked = 0;
		Vector<Todo> newTodos = new Vector<>();
		for (Todo todo : todos) {
			if (todo.isChecked()) {
				checked++;
				continue;
			}
			newTodos.add(todo);
		}
		this.todos = newTodos;
		displayTodos();
		return checked;
	}

	public void remove() {
		Vector<Todo> newTodos = new Vector<>();
		for (Todo todo : todos) {
			if (todo.isChecked()) {
				continue;
			}
			newTodos.add(todo);
		}
		this.todos = newTodos;
		displayTodos();
	}

	private void displayTodos() {
		removeAll();
		for (Todo todo : todos) {
			this.add(todo);
		}
	}

	@Override
	public void update(Event event) {
		if (event instanceof CheckedEvent) {
			Boolean isCheckedFound = false;
			for (Todo todo : todos) {
				if (todo.isChecked()) {
					isCheckedFound = true;
					break;
				}
			}
			if (isCheckedFound) {
				mediator.broadcast(new ButtonEvent(new Enabled()));
			}
			else {
				mediator.broadcast(new ButtonEvent(new Disabled()));
			}
		}
		else if (event instanceof DoneClickedEvent) {
			Integer checked = done();
			mediator.broadcast(new DoneEvent(checked));
			mediator.broadcast(new RefreshEvent());
		}
		else if (event instanceof AddEvent) {
			AddEvent addEvent = (AddEvent) event;
			addTodo(addEvent.getText());
			mediator.broadcast(new RefreshEvent());
		}
		else if (event instanceof RemoveEvent) {
			remove();
			mediator.broadcast(new RefreshEvent());
		}
	}
}
