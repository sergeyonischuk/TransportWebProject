package database;

import java.sql.SQLException;

import model.PassengerTrain;

public class DataBaseEngine {
	
	public static void addToDataBase(PassengerTrain train) throws ClassNotFoundException, SQLException {
		Connector.statmt.execute("INSERT INTO 'passengerTrains' ('number', 'cars') VALUES ( '" + train.getTrainNumber() + "', '" + train.getList().size() + "'); ");
	}


}
