package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import model.PassengerCoach;
import model.PassengerTrain;
import texts.View;

public class TrainService {
	
	/**
	 * Without buffetCar places.
	 * @param train
	 * @return total train seats.
	 */
	public int getTotalTrainSeats(PassengerTrain train) {
		Objects.requireNonNull(train);
		
		int result = 0;
		int carsInTrain = train.getList().size();
		for (int i = 0; i < carsInTrain; i++) {
			if (train.getList().get(i) instanceof PassengerCoach) {
				PassengerCoach p = (PassengerCoach) train.getList().get(i);
				result += p.getPassengerSeats();
			}
		}
		return result;
	}
	
	public int getTotalMaxWeight(PassengerTrain train) {
		Objects.requireNonNull(train);
		
		int result = 0;
		int carsInTrain = train.getList().size();
		for (int i = 0; i < carsInTrain; i++) {
			result += train.getList().get(i).getMaxWeightKG();
		}
		return result;
	}
	
	public List<PassengerCoach> findCoachByNumberOfSeats(PassengerTrain train, int min, int max) {
		Objects.requireNonNull(train);
		
		if (min > max) {
			View.printMessage(View.SEARCH_ARGUMENTS_ERROR);
		}
		List<PassengerCoach> list = new ArrayList<PassengerCoach>();
		
		for (int i = 0; i < train.getList().size(); i++) {
			if (train.getList().get(i) instanceof PassengerCoach) {
				PassengerCoach p = (PassengerCoach) train.getList().get(i);
				if (p.getPassengerSeats() >= min && p.getPassengerSeats() <= max) {
					list.add(p);
				}
			}
		}
		return list;
	}
}