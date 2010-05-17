package com.agical.simwar.combatant;

import com.agical.simwar.game.Army;
import com.agical.simwar.player.Player;
import com.agical.simwar.player.Stats;

public class AutomatorCombatant extends AbstractCombatant {

	public AutomatorCombatant() {
		super("Automator");
	}

	public Player create(String playerName, Army army, Stats stats) {
		return new Player(playerName, army, stats, this);
	}

	public int getEliteAttackRating() {
		return 5;
	}

	public int getEliteDefenseRating() {
		return 5;
	}

}
