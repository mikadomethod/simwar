package com.agical.simwar.gui;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import org.junit.Test;

import com.agical.simwar.combatant.Combatant;
import com.agical.simwar.combatant.WizardCombatant;
import com.agical.simwar.game.Army;
import com.agical.simwar.player.Player;
import com.agical.simwar.player.Stats;

public class TestPlayerController {

	@Test
	public void fetchesPlayerDataFromAddedForms() {
		PlayerController playerController = new PlayerController("P1");

		playerController.setPlayerTypeField(new JComboBox(new Combatant[] { new WizardCombatant() }));
		playerController.setSoldiersField(new JTextField("1"));
		playerController.setKnightsField(new JTextField("2"));
		playerController.setPikemenField(new JTextField("3"));
		playerController.setElitesField(new JTextField("4"));

		playerController.setAttackRatingField(new JTextField("2"));
		playerController.setDefenseRatingField(new JTextField("2"));
		playerController.setTrainingGroundsField(new JTextField("2"));
		playerController.setFortsField(new JTextField("2"));

		Player player = playerController.getPlayer();

		Player expectedPlayer = new Player("P1", new Army(1, 2, 3, 4), new Stats(2, 2, 2, 2), new WizardCombatant());

		assertEquals(expectedPlayer, player);
		assertTrue("Should be a wizard", (player instanceof Player));
	}

}
