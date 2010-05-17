package com.agical.simwar.combatant;

import com.agical.simwar.game.Army;
import com.agical.simwar.player.Player;
import com.agical.simwar.player.Stats;

public abstract class AbstractCombatant implements Combatant {

	protected final String name;

	public AbstractCombatant(String name) {
		this.name = name;
	}

	abstract public Player create(String playerName, Army army, Stats stats);

	public String toString() {
		return name;
	}

	public abstract int getEliteAttackRating();

	public abstract int getEliteDefenseRating();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractCombatant other = (AbstractCombatant) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
