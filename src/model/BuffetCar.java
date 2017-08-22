package model;

import enums.Comfortableness;

public class BuffetCar extends Car {
	int passengerCapacity;

	public BuffetCar(int passengerCapacity, Comfortableness comfortableness, int maxWeight) {
		super(comfortableness, maxWeight);
		this.passengerCapacity = passengerCapacity;
	}

	public int getPassengerCapacity() {
		return passengerCapacity;
	}

	public void setPassengerCapacity(int passengerCapacity) {
		this.passengerCapacity = passengerCapacity;
	}

	public Comfortableness getComfortableness() {
		return comfortableness;
	}

	@Override
	public String toString() {
		return "<br>BuffetCar [passengerCapacity=" + passengerCapacity + ", comfortableness="
				+ comfortableness + "]<br>";
	}
}