package view;

public class View {
	public static final String CAR_TYPE_ERROR = "Passenger coach cant be freight";
	public static final String SEARCH_ARGUMENTS_ERROR = "min value must be less than max";
	public static final String BUFFET_CAR_COMFORT_ERROR = "Buffet cars can be first or second class";
	
	public static void printMessage(String text) {
		System.out.println(text);
	}
}