package trainTest;

import java.util.ArrayList;
import java.util.List;

import enums.Comfortableness;
import enums.Fuel;
import model.*;

public class FakeTrainCreator {

	public PassengerTrain createPassengerTrain(int firstOrSecondVariant) {
		if (firstOrSecondVariant == 1) {
			Locomotive locomotive = new Locomotive(Fuel.DIESEL);

			List<Car> list = new ArrayList<Car>();
			list.add(new PassengerCoach(Comfortableness.FIRST_CLASS));
			list.add(new PassengerCoach(Comfortableness.FIRST_CLASS));
			list.add(new FreightCar(5000));
			list.add(new PassengerCoach(Comfortableness.SECOND_CLASS));
			list.add(new PassengerCoach(Comfortableness.FIRST_CLASS));
			list.add(new PassengerCoach(Comfortableness.SECOND_CLASS));
			list.add(new PassengerCoach(Comfortableness.FIRST_CLASS));
			list.add(new BuffetCar(30, Comfortableness.FIRST_CLASS, 3000));
			list.add(new PassengerCoach(Comfortableness.PREMIUM));
			list.add(new PassengerCoach(Comfortableness.PREMIUM));
			list.add(new PassengerCoach(Comfortableness.FIRST_CLASS));
			list.add(new PassengerCoach(Comfortableness.SECOND_CLASS));
			list.add(new BuffetCar(30, Comfortableness.SECOND_CLASS, 3000));
			list.add(new PassengerCoach(Comfortableness.SECOND_CLASS));
			list.add(new PassengerCoach(Comfortableness.SECOND_CLASS));
			list.add(new PassengerCoach(Comfortableness.COUPE));
			list.add(new PassengerCoach(Comfortableness.COUPE));
			list.add(new PassengerCoach(Comfortableness.COUPE));

			return new PassengerTrain(locomotive, list, 137);

		} else if (firstOrSecondVariant == 2) {
			List<Car> list2 = new ArrayList<Car>();
			Locomotive locomotive2 = new Locomotive(Fuel.COAL);
			list2.add(new PassengerCoach(Comfortableness.FIRST_CLASS));
			list2.add(new PassengerCoach(Comfortableness.SECOND_CLASS));
			list2.add(new BuffetCar(20, Comfortableness.SECOND_CLASS, 2500));
			list2.add(new PassengerCoach(Comfortableness.SECOND_CLASS));
			list2.add(new PassengerCoach(Comfortableness.SECOND_CLASS));

			return new PassengerTrain(locomotive2, list2, 114);

		} else {
			return null;
		}
	}

}
