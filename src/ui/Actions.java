package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import components.CustomButton;
import event.CheckedEvent;
import event.DoneClickedEvent;
import event.RemoveEvent;

public class Actions extends JPanel implements ActionListener {
	private Mediator mediator;
	private CustomButton done;
	private CustomButton remove;

	public Actions(Mediator mediator) {
		this.mediator = mediator;

		done = new CustomButton("Done");
		remove = new CustomButton("Remove");

		mediator.attach(done);
		mediator.attach(remove);

		this.add(done);
		this.add(remove);

		done.addActionListener(this);
		remove.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(done)) {
			mediator.broadcast(new DoneClickedEvent());
			mediator.broadcast(new CheckedEvent());
		}

		if (e.getSource().equals(remove)) {
			mediator.broadcast(new RemoveEvent());
			mediator.broadcast(new CheckedEvent());
		}
	}
}