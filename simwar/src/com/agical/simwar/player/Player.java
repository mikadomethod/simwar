package com.agical.simwar.player;

import java.util.Comparator;
import java.util.TreeSet;

import javax.swing.JLabel;

import com.agical.simwar.combatant.Combatant;
import com.agical.simwar.game.Army;

public class Player {
	public static final int SOLDIER_ATTACK = 1;
	public static final int PIKEMEN_ATTACK = 1;
	public static final int KNIGHT_ATTACK = 3;
	public static final int SOLDIER_DEFENSE = 1;
	public static final int KNIGHT_DEFENSE = 1;
	public static final int PIKEMEN_DEFENSE = 3;
	private final String playerName;
	private final Army army;
	private final Stats stats;
	private final Combatant combatant;

	public Player(String playerName, Army army, Stats statistics, Combatant combatant) {
		this.playerName = playerName;
		this.army = army;
		this.stats = statistics;
		this.combatant = combatant;
	}

	public Player attacks(Player attackedPlayer) {
		TreeSet<Player> strongest = new TreeSet<Player>(new StrengthComparator());
		strongest.add(this);
		strongest.add(attackedPlayer);

		return strongest.first();
	}

	private class StrengthComparator implements Comparator<Player> {
		public int compare(Player defendingPlayer, Player attackingPlayer) {
			return attackingPlayer.getOffense() - defendingPlayer.getDefense();
		}
	}

	public int getDefense() {
		return (int) Math.round(army.getBaseDefenseRatingFor(this) * stats.getDefenseRating());
	}

	private int getOffense() {
		return (int) Math.round(army.getBaseAttackRatingFor(this) * stats.getAttackRating());
	}

	public String toString() {
		return playerName;
	}

	public boolean equals(Object obj) {
		Player player = (Player) obj;
		return playerName.equals(player.playerName) && player.army.equals(army) && player.stats.equals(stats);
	}

	public int hashCode() {
		return playerName.hashCode() * stats.hashCode() * army.hashCode();
	}

	public int getEliteAttackRating() {
		return combatant.getEliteAttackRating();
	}

	public int getEliteDefenseRating() {
		return combatant.getEliteDefenseRating();
	}

	public void reportAttackRatingTo(JLabel calculatedAttackRating) {
		calculatedAttackRating.setText("" + getOffense());
	}

	public void reportDefenseRatingTo(JLabel calculatedDefenseRating) {
		calculatedDefenseRating.setText("" + getDefense());
	}

	public Combatant getCombatant() {
		return combatant;
	}
}
