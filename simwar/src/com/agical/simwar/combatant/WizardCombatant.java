package com.agical.simwar.combatant;

import com.agical.simwar.game.Army;
import com.agical.simwar.player.Player;
import com.agical.simwar.player.Stats;

public class WizardCombatant extends AbstractCombatant {

	public WizardCombatant() {
		super("Wizard");
	}

	public int getEliteAttackRating() {
		return 5;
	}

	public int getEliteDefenseRating() {
		return 3;
	}

	public Player create(String playerName, Army army, Stats stats) {
		return new Player(playerName, army, stats, this);
	}

}
