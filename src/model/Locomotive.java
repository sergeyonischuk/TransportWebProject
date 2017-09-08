package model;

import enums.Fuel;

public class Locomotive {
	private Fuel fuel;

	public Locomotive(Fuel fuel) {
		this.fuel = fuel;
	}

	public Fuel getFuel() {
		return fuel;
	}

	public void setFuel(Fuel fuel) {
		this.fuel = fuel;
	}

	@Override
	public String toString() {
		return "Locomotive [fuel=" + fuel + "]";
	}

}