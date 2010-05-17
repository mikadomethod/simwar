package com.agical.simwar.game;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.agical.simwar.TestingPlayer;
import com.agical.simwar.combatant.AutomatorCombatant;
import com.agical.simwar.combatant.Combatant;
import com.agical.simwar.combatant.WizardCombatant;
import com.agical.simwar.player.Player;
import com.agical.simwar.player.Stats;
import com.agical.simwar.player.TestingPlayerCombatant;

public class TestGame {

	private ScoreBoard scoreBoard;
	private Game game;
	private Army tinyArmy;
	private Army smallArmy;

	@Before
	public void setUp() {
		scoreBoard = new ScoreBoard();
		tinyArmy = new Army(1, 1, 1, 1);
		smallArmy = new Army(10, 1, 1, 1);
		game = new Game(scoreBoard);
	}

	@Test
	public void shouldHaveAWinner() {
		Player player1 = new Player("P1", smallArmy, Stats.NO_STATS, new WizardCombatant());
		Player player2 = new Player("P2", tinyArmy, Stats.NO_STATS, new AutomatorCombatant());
		game.simulate(player1, player2);

		assertEquals(scoreBoard.getResult(), "Simulation winner is P1");
	}

	@Test
	public void shouldReportResultToAScoreBoard() {
		Player p1 = new TestingPlayer("P1", Army.EMPTY_ARMY, Stats.NO_STATS, new TestingPlayerCombatant());
		game.simulate(p1, p1);
		assertEquals("Simulation winner is P1", scoreBoard.getResult());
	}

	@Test
	public void shouldContainAllCombatants() throws Exception {
		Combatant[] expectedCombatants = new Combatant[] { new WizardCombatant(), new AutomatorCombatant() };
		assertArrayEquals(expectedCombatants, game.availableCombatants());
	}

}
