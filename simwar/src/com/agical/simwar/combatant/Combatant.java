package com.agical.simwar.combatant;

import com.agical.simwar.game.Army;
import com.agical.simwar.player.Player;
import com.agical.simwar.player.Stats;

public interface Combatant {

	public Player create(String playerName, Army army, Stats stats);

	public abstract int getEliteAttackRating();

	public abstract int getEliteDefenseRating();

}
