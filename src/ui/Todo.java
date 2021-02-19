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
import mediator.Mediator;

public class Todo extends JPanel implements Colleague, ActionListener {

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
		this.add(checkbox, BorderLayout.WEST);

		label = new JLabel(text);
		label.setOpaque(true);
		this.add(label, BorderLayout.CENTER);

		this.mediator = mediator;
		checkbox.addActionListener(this);
		setOpaque(false);
	}

	public boolean isChecked() {
		return checkbox.isSelected();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(checkbox)) {
			mediator.broadcast(new CheckedEvent());
		}
	}

	public void setColor(Color textColor, Color backgroundColor) {
		this.label.setForeground(textColor);
		this.label.setBackground(backgroundColor);
		border = BorderFactory.createLineBorder(textColor, 1);
		this.setBorder(border);
		this.checkbox.setBackground(backgroundColor);
		this.setBackground(backgroundColor);
	}

	@Override
	public void update(Event event) {
	}
}
