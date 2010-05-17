package com.agical.simwar.game;

import com.agical.simwar.combatant.AutomatorCombatant;
import com.agical.simwar.combatant.Combatant;
import com.agical.simwar.combatant.WizardCombatant;
import com.agical.simwar.player.Player;

public class Game {

	private final ScoreBoard scoreBoard;

	public Game(ScoreBoard scoreBoard) {
		this.scoreBoard = scoreBoard;
	}

	public void simulate(Player attackingPlayer, Player defendingPlayer) {
		scoreBoard.write("Simulation winner is " + attackingPlayer.attacks(defendingPlayer));
	}

	public Combatant[] availableCombatants() {
		return new Combatant[] { new WizardCombatant(), new AutomatorCombatant() };
	}
}
