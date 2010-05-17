package com.agical.simwar.game;

import com.agical.simwar.player.Player;

public class Army {

	public static final Army EMPTY_ARMY = new Army(0, 0, 0, 0);

	private final int numberOfSoldiers;

	private final int numberOfElites;

	private final int numberOfPikemen;

	private final int numberOfKnights;

	public Army(int numberOfSoldiers, int numberOfKnights, int numberOfPikemen, int numberOfElites) {
		this.numberOfSoldiers = numberOfSoldiers;
		this.numberOfKnights = numberOfKnights;
		this.numberOfPikemen = numberOfPikemen;
		this.numberOfElites = numberOfElites;
	}

	public int getBaseAttackRatingFor(Player player) {
		return baseAttackRating() + numberOfElites * player.getEliteAttackRating();
	}

	public int getBaseDefenseRatingFor(Player player) {
		return baseDefenseRating() + numberOfElites * player.getEliteDefenseRating();
	}

	private int baseAttackRating() {
		int attackRating = numberOfSoldiers * Player.SOLDIER_ATTACK;
		attackRating += numberOfKnights * Player.KNIGHT_ATTACK;
		attackRating += numberOfPikemen * Player.PIKEMEN_ATTACK;
		return attackRating;
	}

	private int baseDefenseRating() {
		int defenseRating = numberOfSoldiers * Player.SOLDIER_DEFENSE;
		defenseRating += numberOfKnights * Player.KNIGHT_DEFENSE;
		defenseRating += numberOfPikemen * Player.PIKEMEN_DEFENSE;
		return defenseRating;
	}

	public boolean equals(Object obj) {
		Army army = (Army) obj;
		return numberOfElites == army.numberOfElites &&
		numberOfSoldiers == army.numberOfSoldiers &&
		numberOfKnights == army.numberOfKnights &&
		numberOfPikemen == army.numberOfPikemen;
	}

	public int hashCode() {
		return baseDefenseRating() + numberOfElites;
	}
}
