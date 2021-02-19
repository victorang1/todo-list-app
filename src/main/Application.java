package main;

import ui.Actions;
import ui.AppMediator;
import ui.Mediator;
import ui.TodoFrame;
import ui.TodoInput;
import ui.Todos;
import worker.AppWorker;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class Application {
    
    private Mediator mediator;
    private TodoInput todoInput;
	private Todos todos;
	private Actions actions;
    private TodoFrame frame;

    public Application() {
        init();
        attachAll();
        onCreate();
		new AppWorker(mediator);
    }

    private void init() {
        mediator = new AppMediator();
		actions = new Actions(mediator);
		todos = new Todos(mediator);
		todoInput = new TodoInput(mediator);
        frame = new TodoFrame(mediator);
    }

    private void attachAll() {
        mediator.attach(actions);
        mediator.attach(todos);
        mediator.attach(todoInput);
		mediator.attach(frame);
    }

    private void onCreate() {
        frame.add(todoInput, BorderLayout.NORTH);
		frame.add(todos, BorderLayout.CENTER);
		frame.add(actions, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
        frame.setFocusable(true);
		frame.pack();
    }
}
