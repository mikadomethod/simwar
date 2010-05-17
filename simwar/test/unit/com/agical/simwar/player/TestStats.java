package com.agical.simwar.player;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class TestStats {

	final private static int defenseRating = 0;

	final private static double trainingGrounds = 0;

	final private static double forts = 0;

	private Stats stats;

	@Before
	public void setUp() {
		stats = new Stats(1, trainingGrounds, defenseRating, forts);
	}

	@Test
	public void defenseRatingIsCalculatedFromDefenseAndForts() {
		Stats stats = new Stats(0, 0, 1, 1);
		assertEquals(1.02, stats.getDefenseRating(), 0.0);
	}

	@Test
	public void attackRatingIsCalculatedFromAttackRatingAndTrainingGrounds() {
		Stats stats = new Stats(1, 16.2, 0, 8.0);
		assertEquals(1.172, stats.getAttackRating(), 0.0);
	}

	@Test
	public void defenseRatingMultiplierIsOneForZeroStats() {
		assertEquals(1.0, stats.getDefenseRating(), 0.0);
	}

	@Test
	public void attackRatingMultiplierIsOneForZeroStats() {
		assertEquals(1.0, Stats.NO_STATS.getAttackRating(), 0.0);
	}

	@Test
	public void hasPercentageTrainingGrounds() {
		assertEquals(trainingGrounds, stats.getTrainingGrounds(), 0.0 );
	}

	@Test
	public void sameStatsAreEqual() {
		assertEquals(Stats.NO_STATS, new Stats(0, 0, 0, 0));
		assertFalse("Should not be equal", Stats.NO_STATS.equals(new Stats(0, 1, 1, 0)));
	}

	@Test
	public void statsCanBeUsedInSets() {
		Set<Stats> set = new HashSet<Stats>();
		set.add(new Stats(1, 1, 3, 2));
		set.add(new Stats(1, 1, 3, 2));

		assertEquals(1, set.size());
	}
}
