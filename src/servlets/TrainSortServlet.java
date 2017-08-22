package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Car;
import model.PassengerTrain;
import services.TrainService;
import trainTest.FakeTrainCreator;

/**
 * Servlet implementation class TrainSortServlet
 */
@WebServlet("/TrainSortServlet")
public class TrainSortServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ConcurrentHashMap<String, PassengerTrain> trains = new ConcurrentHashMap<>();
	private FakeTrainCreator fakeTrainC = new FakeTrainCreator();
	TrainService ts = new TrainService();
	
	
	@Override
	public void init() throws ServletException {
		PassengerTrain train1 = fakeTrainC.createPassengerTrain(1);
		PassengerTrain train2 = fakeTrainC.createPassengerTrain(2);
		trains.put(String.valueOf(train1.getTrainNumber()), train1);
		trains.put(String.valueOf(train2.getTrainNumber()), train2);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		

		String trainNumber = request.getParameter("trainNumber");
		
		if (trainNumber.equals("")) {
			out.println("Please, enter train's number");
		} else if (!trains.containsKey(trainNumber)) {
			out.print("<h3>We have no train in base with number " + trainNumber + " </h3>");
		} else if (trains.containsKey(trainNumber)) {
			PassengerTrain train = trains.get(trainNumber);
			Collections.sort(train.getList(), new Car.SortByComfortableness());
			out.println("<h3>Train cars was sorted</h3>");
			out.println(train.getList());
		}
		
		out.println("<a href='http://localhost:8080/TransportWebProject/StartPage.html'>Back on main page</a>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}