package model;

import java.util.List;

public class PassengerTrain {

	private Locomotive locomotive;
	private List<Car> list;
	private int trainNumber;

	public PassengerTrain(Locomotive locomotive, List<Car> list, int trainNumber) {
		this.locomotive = locomotive;
		this.list = list;
		this.trainNumber = trainNumber;
	}

	public Locomotive getLocomotive() {
		return locomotive;
	}

	public void setLocomotive(Locomotive locomotive) {
		this.locomotive = locomotive;
	}

	public List<Car> getList() {
		return list;
	}

	public void setList(List<Car> list) {
		this.list = list;
	}

	public int getTrainNumber() {
		return trainNumber;
	}

	public void setTrainNumber(int trainNumber) {
		this.trainNumber = trainNumber;
	}

	@Override
	public String toString() {
		return "PassengerTrain [locomotive=" + locomotive + ", list=" + list + ", trainNumber=" + trainNumber + "]";
	}

}