package com.agical.simwar.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelHelper {
	private final JPanel panel;

	public PanelHelper(JPanel panel) {
		this.panel = panel;
	}

	public void addRow(String description, JComponent component) {
		component.setName(description);
		addRow(new JLabel(description), component);
	}

	public void addRow(JComponent leftComponent, JComponent rightComponent) {
		JPanel row = new JPanel();
		row.setLayout(new GridLayout(1, 2));
		row.add(leftComponent);
		row.add(rightComponent);
		panel.add(row);
	}

	public JTextField getTextField() {
		final JTextField textField = new JTextField(8);
		textField.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				textField.setSelectionStart(0);
				textField.setSelectionEnd(textField.getText().length());
			}

			public void focusLost(FocusEvent e) {
			}});
		textField.setText("0");
		return textField;
	}

	private JPanel createColumn(String description, JComponent component) {
		JPanel column = new JPanel();
		column.setLayout(new BorderLayout(15, 10));
		component.setName(description);
		column.add(component, BorderLayout.WEST);
		return column;
	}

	public void addRow(String leftComponentDescription, JComponent leftComponent, String rightComponentDescription, JComponent rightComponent) {
		addRow(createColumn("", new JLabel(leftComponentDescription)), createColumn("", new JLabel(rightComponentDescription)));
		addRow(createColumn(leftComponentDescription, leftComponent), createColumn(rightComponentDescription, rightComponent));
	}
}