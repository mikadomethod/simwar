package com.agical.simwar.gui;

import static org.junit.Assert.assertEquals;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import org.junit.Before;
import org.junit.Test;
import org.uispec4j.Panel;

import com.agical.simwar.combatant.Combatant;
import com.agical.simwar.combatant.WizardCombatant;

public class TestStrengthPanel {

	private Panel panel;
	private StrengthPanel strengthPanel;

	@Before
	public void setUp() {
		PlayerController controller = new PlayerController("P");
		controller.setPlayerTypeField(new JComboBox(new Combatant[] { new WizardCombatant() }));
		JTextField attackRating = new JTextField();
		attackRating.setText("1");
		controller.setAttackRatingField(attackRating);
		strengthPanel = new StrengthPanel(controller);
		panel = new Panel(strengthPanel);
	}

	@Test
	public void totalAttackRatingIsUpdateWhenUserStatsAreApplied() {
		panel.getButton("Update").click();

		assertEquals("10", panel.getTextBox("AttackRating").getText());
	}

	@Test
	public void totalDefenseRatingIsUpdateWhenUserStatsAreApplied() {
		panel.getButton("Update").click();

		assertEquals("8", panel.getTextBox("DefenseRating").getText());
	}

}
