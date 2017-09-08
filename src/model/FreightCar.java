package model;

import enums.Comfortableness;

public class FreightCar extends Car {

	private int maxWeight;

	private FreightCar(Comfortableness comfortableness, int maxWeight) {
		super(comfortableness, maxWeight);
	}

	public FreightCar(int maxWeight) {
		this(Comfortableness.FREIGHT, maxWeight);
	}

	public int getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(int maxWeight) {
		this.maxWeight = maxWeight;
	}

	@Override
	public String toString() {
		return "<br>FreightCar [comfortableness=" + comfortableness + ", getComfortableness()=" + getComfortableness()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]<br>";
	}
}