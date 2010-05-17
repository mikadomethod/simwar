package com.agical.simwar.player;

import com.agical.simwar.TestingPlayer;
import com.agical.simwar.combatant.Combatant;
import com.agical.simwar.game.Army;

public class TestingPlayerCombatant implements Combatant {

	public Player create(String playerName, Army army, Stats stats) {
		return new TestingPlayer(playerName, army, stats, this);
	}

	public int getEliteAttackRating() {
		return 1;
	}

	public int getEliteDefenseRating() {
		return 1;
	}

}
