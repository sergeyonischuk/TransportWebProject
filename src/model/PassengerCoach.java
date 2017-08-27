package model;

import enums.Comfortableness;
import texts.View;

public class PassengerCoach extends Car {
	
	private static final int SEATS_FIRST_CLASS = 45;
	private static final int SEATS_SECOND_CLASS = 60;
	private static final int SEATS_COUPE = 30;
	private static final int SEATS_PREMIUM = 20;

	private int passengerSeats;
	private int cargoCapacityWeight;
	
	public PassengerCoach(Comfortableness comfortableness) {

		super(comfortableness, 6000);

			switch (comfortableness) {
			case FIRST_CLASS:
				this.passengerSeats = SEATS_FIRST_CLASS;
				break;
			case SECOND_CLASS:
				this.passengerSeats = SEATS_SECOND_CLASS;
				break;
			case COUPE:
				this.passengerSeats = SEATS_COUPE;
				break;
			case PREMIUM:
				this.passengerSeats = SEATS_PREMIUM;
				break;
			case FREIGHT:
				throw new IllegalArgumentException(View.CAR_TYPE_ERROR);
			}
	}

	public int getPassengerSeats() {
		return passengerSeats;
	}

	public void setPassengerSeats(int passengerSeats) {
		this.passengerSeats = passengerSeats;
	}

	public int getCargoCapacityWeight() {
		return cargoCapacityWeight;
	}

	public void setCargoCapacityWeight(int cargoCapacityWeight) {
		this.cargoCapacityWeight = cargoCapacityWeight;
	}

	@Override
	public String toString() {
		return "<br>PassengerCoach <br>comfortableness=" + comfortableness 
				+ "<br>" + "passengerSeats=" + passengerSeats
				+ "<br>" + "cargoCapacityWeight=" + cargoCapacityWeight +"<br>";
	}
}