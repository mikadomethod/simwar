package com.agical.simwar.player;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import javax.swing.JLabel;

import org.junit.Before;
import org.junit.Test;

import com.agical.simwar.TestingPlayer;
import com.agical.simwar.game.Army;

public class TestPlayer {

	private Player player1;
	private Player player2;
	private Army oneHundredAndTwentySoldierArmy;
	private Army oneHundredSoldierArmy;

	@Before
	public void setUp() {
		oneHundredAndTwentySoldierArmy = new Army(120, 1, 1, 1);
		oneHundredSoldierArmy = new Army(100, 1, 1, 1);
		player1 = new TestingPlayer("P1", oneHundredSoldierArmy, Stats.NO_STATS, new TestingPlayerCombatant());
		player2 = new TestingPlayer("P2", oneHundredAndTwentySoldierArmy, Stats.NO_STATS, new TestingPlayerCombatant());
	}

	@Test
	public void playersCanBeSuperiorToEachOther() throws Exception {
		assertEquals(player1.attacks(player2), player2);
	}

	@Test
	public void aPlayerCanDescribeItself() {
		assertEquals(player1.toString(), "P1");
	}

	@Test
	public void testPlayersHaveStatistics() {
		new TestingPlayer("P1", Army.EMPTY_ARMY, Stats.NO_STATS, new TestingPlayerCombatant());
	}

	@Test
	public void defeseRatingIsTakenIntoAccountWhenDefending() {
		Player player1 = new TestingPlayer("P1", oneHundredAndTwentySoldierArmy, new Stats(1, 1, 1, 1), new TestingPlayerCombatant());
		Player player2 = new TestingPlayer("P2", oneHundredSoldierArmy, new Stats(1, 1, 100, 1), new TestingPlayerCombatant());

		assertEquals(player2, player1.attacks(player2));
		assertEquals(player1, player2.attacks(player1));
	}

	@Test
	public void playerNameStatsAndArmyDefinesAPlayer() {
		Player player1 = new TestingPlayer("P1", new Army(1, 4, 3, 2), Stats.NO_STATS, new TestingPlayerCombatant());
		Player player2 = new TestingPlayer("P1", new Army(1, 4, 3, 2), Stats.NO_STATS, new TestingPlayerCombatant());
		assertEquals(player1, player2);
	}

	@Test
	public void playersCanBeUsedInSets() {
		Set<Player> set = new HashSet<Player>();
		set.add(new TestingPlayer("P1", new Army(1, 4, 3, 2), Stats.NO_STATS, new TestingPlayerCombatant()));
		set.add(new TestingPlayer("P1", new Army(1, 4, 3, 2), Stats.NO_STATS, new TestingPlayerCombatant()));

		assertEquals(1, set.size());
	}

	@Test
	public void canReportAttackRating() {
		JLabel label = new JLabel();
		player1.reportAttackRatingTo(label);

		assertEquals("106", label.getText());
	}

	@Test
	public void canReportDefenseRating() {
		JLabel label = new JLabel();
		player1.reportDefenseRatingTo(label);

		assertEquals("106", label.getText());
	}

}
