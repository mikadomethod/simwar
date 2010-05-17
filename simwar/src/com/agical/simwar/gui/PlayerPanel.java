package com.agical.simwar.gui;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.agical.simwar.combatant.Combatant;
import com.agical.simwar.combatant.WizardCombatant;
import com.agical.simwar.game.Game;

public class PlayerPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public PlayerPanel(String playerName, PlayerController playerController, Game game) {
		setName("PlayerPanel" + playerName);
		setBorder(BorderFactory.createTitledBorder("Player: " + playerName));

		Combatant[] combatants = game.availableCombatants();

		JComboBox playerSelector = new JComboBox(combatants);
		playerSelector.setSelectedItem(new WizardCombatant());
		playerSelector.setName("PlayerType");

		JPanel infoPanel = new JPanel();
		infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
		infoPanel.setBorder(BorderFactory.createTitledBorder("Info"));
		StrengthPanel strengthPanel = new StrengthPanel(playerController);
		infoPanel.add(playerSelector);
		infoPanel.add(strengthPanel);

		JPanel inputFieldsPanel = new JPanel();
		inputFieldsPanel.setBorder(BorderFactory.createTitledBorder("Army"));

		PanelHelper helper = new PanelHelper(inputFieldsPanel);

		JTextField soldiersField = helper.getTextField();
		JTextField knightsField = helper.getTextField();
		JTextField pikemenField = helper.getTextField();
		JTextField elitesField = helper.getTextField();

		playerController.setPlayerTypeField(playerSelector);
		playerController.setSoldiersField(soldiersField);
		playerController.setKnightsField(knightsField);
		playerController.setPikemenField(pikemenField);
		playerController.setElitesField(elitesField);

		inputFieldsPanel.setLayout(new BoxLayout(inputFieldsPanel, BoxLayout.Y_AXIS));
		helper.addRow("Soldiers", soldiersField);
		helper.addRow("Knights", knightsField);
		helper.addRow("Pikemen", pikemenField);
		helper.addRow("Elites", elitesField);

		add(infoPanel);
		add(inputFieldsPanel);
		add(new StatsPanel(playerName, playerController));
	}
}
