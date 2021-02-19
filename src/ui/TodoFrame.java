package ui;

import javax.swing.JFrame;

import event.AddEvent;
import event.AppThemeChanged;
import event.DoneEvent;
import event.Event;
import event.RefreshEvent;
import event.TodoAddedColorEvent;
import event.WorkerEvent;
import obs.Colleague;
import state.LightState;
import theme.AppTheme;
import theme.Theme;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import mediator.Mediator;
import mediator.AppMediator;

public class TodoFrame extends JFrame implements Colleague, KeyListener, MouseListener {

	private Mediator mediator;
	private Integer totalDone = 0;
	private Theme appTheme;

	public TodoFrame(Mediator mediator) {
		this.mediator = mediator;

		appTheme = new AppTheme(mediator, new LightState());

		resetTitle();

		this.setFocusable(true);
		this.addKeyListener(this);
		this.addMouseListener(this);
	}

	private void resetTitle() {
		this.setTitle(String.format("Done: %s", totalDone));
	}

	@Override
	public void update(Event event) {
		if (event instanceof DoneEvent) {
			DoneEvent doneEvent = (DoneEvent) event;
			totalDone += doneEvent.getTotalChecked();
			resetTitle();
		}
		else if (event instanceof RefreshEvent) {
			this.pack();
			this.setFocusable(true);
			this.requestFocusInWindow();
		}
		else if (event instanceof AppThemeChanged) {
			AppThemeChanged appThemeChanged = (AppThemeChanged) event;
			appTheme = appThemeChanged.getNewTheme();
		}
		else if (event instanceof WorkerEvent) {
			WorkerEvent workerEvent = (WorkerEvent) event;
			System.out.println(workerEvent.getCurrentState());
			((AppMediator) mediator).handleChangeTheme(appTheme, workerEvent.getCurrentState());
 		}
		 else if (event instanceof AddEvent) {
			 mediator.broadcast(new TodoAddedColorEvent(appTheme.getCurrentState()));
		 }
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_N) {
			((AppMediator) mediator).handleChangeTheme(appTheme);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
    public void mouseClicked(MouseEvent e) {
    }

	@Override
	public void mousePressed(MouseEvent e) {
        this.setFocusable(true);
		this.requestFocusInWindow();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
}
