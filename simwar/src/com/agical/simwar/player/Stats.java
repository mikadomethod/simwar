package com.agical.simwar.player;

public class Stats {

	public static final Stats NO_STATS = new Stats(0, 0, 0, 0);

	private final int defenseRating;

	private final int attackRating;

	private final Double trainingGroundsPercentage;

	private final Double fortsPercentage;

	public Stats(int attackRating, double trainingGroundsPercentage, int defenseRating, double fortsPercentage) {
		this.attackRating = attackRating;
		this.defenseRating = defenseRating;
		this.trainingGroundsPercentage = trainingGroundsPercentage;
		this.fortsPercentage = fortsPercentage;
	}

	public Double getDefenseRating() {
		return (100 + defenseRating + fortsPercentage) / 100;
	}

	public Double getAttackRating() {
		return (100 + attackRating + trainingGroundsPercentage) / 100;
	}

	public double getTrainingGrounds() {
		return trainingGroundsPercentage;
	}

	public boolean equals(Object obj) {
		Stats stats = (Stats) obj;
		return stats.attackRating == attackRating && stats.defenseRating == defenseRating && stats.fortsPercentage.doubleValue() == fortsPercentage.doubleValue()
				&& stats.trainingGroundsPercentage.doubleValue() == trainingGroundsPercentage.doubleValue();
	}

	public int hashCode() {
		return attackRating * defenseRating * trainingGroundsPercentage.intValue();
	}

//	public String toString() {
//		return "a:" + attackRating + " d:" + defenseRating + " tr:" + trainingGroundsPercentage + " f:" + fortsPercentage;
//	}
}
