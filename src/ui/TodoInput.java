package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import event.AddEvent;

public class TodoInput extends JPanel implements ActionListener {
	private JTextField text;
	private JButton add;
	private Mediator mediator;

	public TodoInput(Mediator mediator) {
		this.mediator = mediator;

		text = new JTextField(20);
		add = new JButton("Add");

		this.add(text);
		this.add(add);

		add.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (!e.getSource().equals(add)) {
			return;
		}

		String todoText = this.text.getText();
		mediator.broadcast(new AddEvent(todoText));

		this.text.setText("");
	}
}
