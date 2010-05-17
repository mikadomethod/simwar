package com.agical.simwar.gui;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StatsPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JPanel inputFieldsPanel = new JPanel();

	public StatsPanel(String playerName, PlayerController playerController) {
		setBorder(BorderFactory.createTitledBorder("Stats"));
		setName("StatsPanel" + playerName);

		inputFieldsPanel.setLayout(new BoxLayout(inputFieldsPanel, BoxLayout.Y_AXIS));
		add(inputFieldsPanel);

		PanelHelper helper = new PanelHelper(inputFieldsPanel);
		JTextField attackRatingField = helper.getTextField();
		JTextField defenseRatingField = helper.getTextField();
		JTextField trainingGroundsField = helper.getTextField();
		JTextField fortsField = helper.getTextField();

		playerController.setAttackRatingField(attackRatingField);
		playerController.setDefenseRatingField(defenseRatingField);
		playerController.setTrainingGroundsField(trainingGroundsField);
		playerController.setFortsField(fortsField);

		helper.addRow("Attackrating", attackRatingField, "Defenserating", defenseRatingField);
		helper.addRow("Training Grounds", trainingGroundsField, "Forts", fortsField);
	}
}
