package texts;

import java.util.Locale;
import java.util.ResourceBundle;

public class Messages {

	private static Locale locale_ru = new Locale("ru_RU");
	private static Locale locale_en = new Locale("en_US");

	private static ResourceBundle bundle = ResourceBundle.getBundle("texts", locale_ru);

	public static final String CAR_TYPE_ERROR = bundle.getString("carTypeError");
	public static final String SEARCH_ARGUMENTS_ERROR = bundle.getString("searchArgumentError");
	public static final String BUFFET_CAR_COMFORT_ERROR = bundle.getString("buffetCarComfortError");
	public static final String TRAIN_INFO = bundle.getString("trainInfo");
	public static final String CARS_QUANTITY = bundle.getString("carsQuantity");
	public static final String LOCOMOTIVE_INFO = bundle.getString("lovomotiveInfo");
	public static final String INPUT_NUMBER_REQUEST = bundle.getString("inputNumberReq");
	public static final String INVALID_SEARCH_TRAIN = bundle.getString("invalidSearchTrain");
	public static final String INVALID_PARAM_TYPE = bundle.getString("invalidParamType");
	public static final String MAX_LESS_THAN_MIN = bundle.getString("maxLessThanMin");
	public static final String SUCCES_SORTED = bundle.getString("succesSorted");
	public static final String LOCALE = bundle.getString("locale");

	public static final String GO_BACK = bundle.getString("goBack");
	public static final String GO_BACK_SEARCH = bundle.getString("goBackSearch");

	public static final String TRAIN_NUMBER = bundle.getString("trainNumber");
	public static final String SEATS_MIN = bundle.getString("seatsMin");
	public static final String SEATS_MAX = bundle.getString("seatsMax");
	public static final String MAIN_TITTLE = bundle.getString("goBackSearch");
	public static final String SEATS_TITTLE = bundle.getString("goBackSearch");
	public static final String SORT_TITTLE = bundle.getString("goBackSearch");

	public static void printMessage(String text) {
		System.out.println(text);
	}
}