package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import event.CheckedEvent;
import event.Event;
import obs.Colleague;

public class Todo extends JPanel implements Colleague {

	private Mediator mediator;
	private Border border;
	private JLabel label;
	private JCheckBox checkbox;

	public Todo(String text, Mediator mediator) {
		this.setPreferredSize(new Dimension(350, 30));

		border = BorderFactory.createLineBorder(Color.BLACK, 1);
		this.setBorder(border);

		this.setLayout(new BorderLayout());

		checkbox = new JCheckBox();
		checkbox.addActionListener(new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {
                mediator.broadcast(new CheckedEvent());
            }
		});
		this.add(checkbox, BorderLayout.WEST);

		label = new JLabel(text);
		this.add(label, BorderLayout.CENTER);

		this.mediator = mediator;
	}

	public boolean isChecked() {
		return checkbox.isSelected();
	}

	@Override
	public void update(Event event) {
		// TODO Auto-generated method stub
		
	}
}
