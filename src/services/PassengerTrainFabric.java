package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import enums.Comfortableness;
import enums.Fuel;
import model.*;
import view.View;

public class PassengerTrainFabric {
	
	private List<Car> cars = new ArrayList<>();
	private HashMap<Number, PassengerTrain> passengerTrains = new HashMap<Number, PassengerTrain>();
	
	public List<Car> getCars() {
		return cars;
	}

	public HashMap<Number, PassengerTrain> getPassengerTrains() {
		return passengerTrains;
	}

	public PassengerTrain createPassengerTrain(List<Car> list, Fuel fuel, int number) {
		PassengerTrain result = new PassengerTrain(addLocomotive(fuel), list, number);
		passengerTrains.put(121, result);
		return new PassengerTrain(addLocomotive(fuel), list, number);
	}
	
	public Locomotive addLocomotive(Fuel fuel) {
		return new Locomotive(fuel);
	}
	
	public void addPaseengerCocachToList (Comfortableness comfortableness) {
		cars.add(new PassengerCoach(comfortableness));
	}
	public void addFreightCarToList (int cargoCapacityWeight) {
		cars.add(new FreightCar(cargoCapacityWeight));
	}
	public void addBuffetCarToList (int capacity, Comfortableness comfortableness, int maxWeight) {
		Objects.requireNonNull(comfortableness);
		
		if (comfortableness == Comfortableness.FIRST_CLASS || comfortableness == Comfortableness.SECOND_CLASS) {
			cars.add(new BuffetCar(30, comfortableness, maxWeight));
		} else {
			View.printMessage(View.BUFFET_CAR_COMFORT_ERROR);
		}
	}
}