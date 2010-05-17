package com.agical.simwar.combatant;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.agical.simwar.game.Army;
import com.agical.simwar.player.Player;
import com.agical.simwar.player.Stats;

public class TestAutomatorCombatant {
	private Combatant combatant;

	@Before
	public void setUp() {
		combatant = new AutomatorCombatant();
	}

	@Test
	public void presentsItselfProperly() {
		assertEquals(combatant.toString(), "Automator");
	}

	@Test
	public void canCreatePlayingInstancesOfItself() {
		Player player = combatant.create("P", Army.EMPTY_ARMY, Stats.NO_STATS);
		assertEquals(combatant, player.getCombatant());
	}

	@Test
	public void eliteAttackRatingCanBeRetrieved() {
		assertEquals(5, combatant.getEliteAttackRating());
	}

	@Test
	public void eliteDefenseRatingCanBeRetrieved() {
		assertEquals(5, combatant.getEliteDefenseRating());
	}

}
