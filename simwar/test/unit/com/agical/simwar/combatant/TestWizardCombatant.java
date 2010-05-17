package com.agical.simwar.combatant;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.agical.simwar.game.Army;
import com.agical.simwar.player.Player;
import com.agical.simwar.player.Stats;

public class TestWizardCombatant {

	private Combatant wizard;

	@Before
	public void setUp() {
		wizard = new WizardCombatant();
	}

	@Test
	public void canCreatePlayingInstancesOfItself() {
		Player player = wizard.create("P", Army.EMPTY_ARMY, Stats.NO_STATS);
		assertEquals(wizard, player.getCombatant());
	}

	@Test
	public void presentsItselfProperly() {
		assertEquals("Wizard", wizard.toString());
	}

	@Test
	public void eliteAttackRatingCanBeRetrieved() {
		assertEquals(wizard.getEliteAttackRating(), 5);
	}

	@Test
	public void eliteDefenseRatingCanBeRetrieved() {
		assertEquals(wizard.getEliteDefenseRating(), 3);
	}
}
