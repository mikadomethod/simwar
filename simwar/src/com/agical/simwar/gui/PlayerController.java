package com.agical.simwar.gui;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import com.agical.simwar.combatant.Combatant;
import com.agical.simwar.game.Army;
import com.agical.simwar.player.Player;
import com.agical.simwar.player.Stats;

public class PlayerController {

	private JTextField soldiersField;

	private JTextField knightsField;

	private JTextField pikemenField;

	private JTextField elitesTextField;

	private JComboBox playerType;

	private final String playerName;

	private JTextField attackRatingField;

	private JTextField defenseRatingField;

	private JTextField trainingGroundsField;

	private JTextField fortsField;

	public PlayerController(String playerName) {
		this.playerName = playerName;
		soldiersField = getTextField();
		knightsField = getTextField();
		pikemenField = getTextField();
		elitesTextField = getTextField();

		attackRatingField = getTextField();
		defenseRatingField = getTextField();
		trainingGroundsField = getTextField();
		fortsField = getTextField();


		playerType = new JComboBox();
	}

	private JTextField getTextField() {
		JTextField textField = new JTextField();
		textField.setText("1");
		return textField;
	}

	public Player getPlayer() {
		int numberOfSoldiers = Integer.valueOf(soldiersField.getText());
		int numberOfKnights = Integer.valueOf(knightsField.getText());
		int numberOfPikemen = Integer.valueOf(pikemenField.getText());
		int numberOfElites = Integer.valueOf(elitesTextField.getText());

		int attackRating = Integer.valueOf(attackRatingField.getText());
		int defenseRating = Integer.valueOf(defenseRatingField.getText());
		int percentageTrainingGrounds = Integer.valueOf(trainingGroundsField.getText());
		int percentageForts = Integer.valueOf(fortsField.getText());

		Army army = new Army(numberOfSoldiers, numberOfKnights, numberOfPikemen, numberOfElites);
		Stats stats = new Stats(attackRating, percentageTrainingGrounds, defenseRating, percentageForts);

		Combatant selectedItem = (Combatant) playerType.getSelectedItem();
		return selectedItem.create(playerName, army, stats);
	}

	public void setSoldiersField(JTextField soldiersField) {
		this.soldiersField = soldiersField;
	}

	public void setKnightsField(JTextField knightsField) {
		this.knightsField = knightsField;
	}

	public void setPikemenField(JTextField pikemenField) {
		this.pikemenField = pikemenField;
	}

	public void setElitesField(JTextField elitesTextField) {
		this.elitesTextField = elitesTextField;
	}

	public void setPlayerTypeField(JComboBox playerType) {
		this.playerType = playerType;
	}

	public void setAttackRatingField(JTextField attackRatingField) {
		this.attackRatingField = attackRatingField;
	}

	public void setDefenseRatingField(JTextField defenseRatingField) {
		this.defenseRatingField = defenseRatingField;
	}

	public void setTrainingGroundsField(JTextField trainingGroundsField) {
		this.trainingGroundsField = trainingGroundsField;
	}

	public void setFortsField(JTextField fortsField) {
		this.fortsField = fortsField;
	}

}
