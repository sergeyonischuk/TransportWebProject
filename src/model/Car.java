package model;

import java.util.Comparator;

import enums.Comfortableness;

public abstract class Car {
	protected Comfortableness comfortableness;
	protected int maxWeightKG;

	public Car(Comfortableness comfortableness, int maxWeightKG) {
		this.comfortableness = comfortableness;
		this.maxWeightKG = maxWeightKG;
	}

	public Comfortableness getComfortableness() {
		return comfortableness;
	}

	public void setComfortableness(Comfortableness comfortableness) {
		this.comfortableness = comfortableness;
	}

	public int getMaxWeightKG() {
		return maxWeightKG;
	}

	public void setMaxWeightKG(int maxWeightKG) {
		this.maxWeightKG = maxWeightKG;
	}

	/**
	 * Sorting cars by comfortableness (ordinal).
	 *
	 */
	public static class SortByComfortableness implements Comparator<Car> {
		public int compare(Car o1, Car o2) {
			return o1.getComfortableness().compareTo(o2.getComfortableness());
		}
	}
}
