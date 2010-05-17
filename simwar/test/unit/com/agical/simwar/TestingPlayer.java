package com.agical.simwar;

import com.agical.simwar.combatant.Combatant;
import com.agical.simwar.game.Army;
import com.agical.simwar.player.Player;
import com.agical.simwar.player.Stats;

public class TestingPlayer extends Player {
	public TestingPlayer(String playerName, Army army, Stats statistics, Combatant combatant) {
		super(playerName, army, statistics, combatant);
	}

	public int getEliteAttackRating() {
		return 2;
	}

	public int getEliteDefenseRating() {
		return 2;
	}

}