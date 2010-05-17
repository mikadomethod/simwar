package com.agical.simwar.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.agical.simwar.TestingPlayer;
import com.agical.simwar.player.Player;
import com.agical.simwar.player.Stats;
import com.agical.simwar.player.TestingPlayerCombatant;

public class TestArmy {

	private Army army;
	private final int soldiers = 100;
	private final int knights = 60;
	private final int pikemen = 40;
	private final int elites = 50;

	@Before
	public void setUp() {
		army = new Army(soldiers, knights, pikemen, elites);
	}

	@Test
	public void armiesWithSameAmoutOfTroopsAreEqual() {
		assertEquals(Army.EMPTY_ARMY, new Army(0, 0, 0, 0));
		assertEquals(new Army(1, 0, 0, 0), new Army(1, 0, 0, 0));
		assertFalse("Should not be equal", new Army(1, 4, 1, 2).equals(new Army(1, 4, 3, 2)));
	}

	@Test
	public void armiesCanBeUsedIsSets() {
		Set<Army> armies = new HashSet<Army>();
		armies.add(Army.EMPTY_ARMY);
		armies.add(new Army(0, 0, 0, 0));
		assertEquals(1, armies.size());
	}

	@Test
	public void canReportAttackPowerForPlayer() {
		Player player = new TestingPlayer("TP", army, new Stats(1, 0, 1, 1), new TestingPlayerCombatant());

		assertEquals(420, army.getBaseAttackRatingFor(player));
	}
}
