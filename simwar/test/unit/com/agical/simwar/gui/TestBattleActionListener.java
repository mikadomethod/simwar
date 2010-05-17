package com.agical.simwar.gui;

import static org.junit.Assert.assertEquals;

import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import org.junit.Test;

import com.agical.simwar.combatant.AutomatorCombatant;
import com.agical.simwar.combatant.Combatant;
import com.agical.simwar.combatant.WizardCombatant;
import com.agical.simwar.game.Game;
import com.agical.simwar.game.ScoreBoard;

public class TestBattleActionListener {

	@Test
	public void battlesArePerformedWhenListenerIsInvoked() {
		PlayerController controller = new PlayerController("P1");
		controller.setSoldiersField(getInitiatedTextField());
		controller.setKnightsField(getInitiatedTextField());
		controller.setPikemenField(getInitiatedTextField());
		controller.setElitesField(getInitiatedTextField());
		controller.setPlayerTypeField(getPlayerTypes());

		ScoreBoard scoreBoard = new ScoreBoard();
		Game battle = new Game(scoreBoard);

		ActionListener listener = new BattleActionListener(battle, controller, controller);
		listener.actionPerformed(null);

		assertEquals(scoreBoard.getResult(), "Simulation winner is P1");
	}

	private JComboBox getPlayerTypes() {
		JComboBox playerTypes = new JComboBox(new Combatant[] { new WizardCombatant(), new AutomatorCombatant() });

		return playerTypes;
	}

	private JTextField getInitiatedTextField() {
		JTextField textField = new JTextField();
		textField.setText("3");
		return textField;
	}

}
