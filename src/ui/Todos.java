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
import event.TodoAddedColorEvent;
import event.ToggleThemeEvent;
import obs.Colleague;
import state.button.Disabled;
import state.button.Enabled;

import mediator.Mediator;

public class Todos extends JPanel implements Colleague {
	private Mediator mediator;

	private Vector<Todo> todos;

	public Todos(Mediator mediator) {
		this.todos = new Vector<>();
		this.mediator = mediator;

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		displayTodos();
	}

	public void addTodo(String text) {
		Todo todo = new Todo(text, mediator);
		todos.add(todo);
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
			for (Todo todo : todos) {
				if (todo.isChecked()) {
					mediator.broadcast(new ButtonEvent(new Enabled()));
					return;
				}
			}
			mediator.broadcast(new ButtonEvent(new Disabled()));
		}
		else if (event instanceof DoneClickedEvent) {
			Integer checked = done();
			mediator.broadcast(new DoneEvent(checked));
			mediator.broadcast(new RefreshEvent());
		}
		else if (event instanceof AddEvent) {
			addTodo(((AddEvent) event).getText());
			mediator.broadcast(new RefreshEvent());
		}
		else if (event instanceof RemoveEvent) {
			remove();
			mediator.broadcast(new RefreshEvent());
		}
		else if (event instanceof ToggleThemeEvent) {
			ToggleThemeEvent ev = (ToggleThemeEvent) event;
			for (Todo todo: todos) {
				todo.setColor(ev.getTextColor(), ev.getBackgroundColor());
			}
		}
		else if (event instanceof TodoAddedColorEvent) {
			TodoAddedColorEvent ev = (TodoAddedColorEvent) event;
			int lastIndex = todos.size() - 1;
			Todo lastAddedTodo = todos.get(lastIndex);
			lastAddedTodo.setColor(ev.getTextColor(), ev.getBackgroundColor());
		}
	}
}
