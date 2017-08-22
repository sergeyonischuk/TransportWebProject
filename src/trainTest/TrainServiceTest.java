package trainTest;

import org.junit.Assert;
import org.junit.Test;

import model.PassengerTrain;
import services.TrainService;

public class TrainServiceTest {
	
	TrainService trainService = new TrainService();
	FakeTrainCreator fakeTrainCreator = new FakeTrainCreator();
	
	PassengerTrain train = fakeTrainCreator.createPassengerTrain(1);
	
	@Test
	public void testGetTotalTrainSeats() {
		System.out.println(trainService.getTotalTrainSeats(train));
		Assert.assertTrue(trainService.getTotalTrainSeats(train) == 655);
	}
	
	@Test
	public void testFindCoachByNumberOfSeats() {
		Assert.assertTrue(trainService.findCoachByNumberOfSeats(train, 5, 25).size() == 2);
	}
	
	@Test
	public void testFindCoachByNumberOfSeatsErr() {
		Assert.assertFalse(trainService.findCoachByNumberOfSeats(train, 33, 25).size() > 0);
	}
	
	@Test
	public void testTotalMaxWeight() {
		System.out.println(trainService.getTotalMaxWeight(train));
		Assert.assertTrue(trainService.getTotalMaxWeight(train) == 101000);
	}
}