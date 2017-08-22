package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PassengerCoach;
import model.PassengerTrain;
import services.TrainService;
import trainTest.FakeTrainCreator;

/**
 * Servlet implementation class SearchSeatsServlet
 */
@WebServlet("/SearchSeatsServlet")
public class SearchSeatsServlet extends HttpServlet {
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
			int min = 0;
			int max = 0;
			
			String minimal = request.getParameter("seatsMin");
			String maximal = request.getParameter("seatsMax");
			
			if (request.getParameter("seatsMin").matches("[-+]?\\d+") && request.getParameter("seatsMax").matches("[-+]?\\d+")) {
				min = Integer.parseInt(minimal);
				max = Integer.parseInt(maximal);
				
				List<PassengerCoach> coachList = ts.findCoachByNumberOfSeats(train, min, max);
				
				out.print(coachList);
			} else {
				out.print("<h3>Min and max values must be numbers</h3>");
			}

			
			if(min > max) {
				out.println("min value must be less than max");
			}
			
//			List<PassengerCoach> coachList = ts.findCoachByNumberOfSeats(train, min, max);
//		
//			out.print(coachList);
		}
		out.println("<br><a href='http://localhost:8080/TransportWebProject/SeatsSearch.html'>Back on main search page</a>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
