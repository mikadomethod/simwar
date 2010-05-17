package com.agical.simwar.gui;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ResultPanel extends JPanel implements ScoreBoardListener {

	private static final long serialVersionUID = 1L;

	private final JLabel resultLabel;

	public ResultPanel(JLabel resultLabel, JButton button) {
		this.resultLabel = resultLabel;
		resultLabel.setBorder(BorderFactory.createTitledBorder("Results"));
		resultLabel.setName("Results");
		add(resultLabel);
		add(button);
	}

	public void reportScore(String result) {
		resultLabel.setText(result);
	}

}
