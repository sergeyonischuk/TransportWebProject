package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PassengerTrain;
import trainTest.FakeTrainCreator;

@WebServlet("/TransportServlet")
public class TransportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ConcurrentHashMap<String, PassengerTrain> trains = new ConcurrentHashMap<>();
	private FakeTrainCreator fakeTrainC = new FakeTrainCreator();
	
	@Override
	public void init() throws ServletException {


		PassengerTrain train1 = fakeTrainC.createPassengerTrain(1);
		PassengerTrain train2 = fakeTrainC.createPassengerTrain(2);
		trains.put(String.valueOf(train1.getTrainNumber()), train1);
		trains.put(String.valueOf(train2.getTrainNumber()), train2);
	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String trainNumber = request.getParameter("trainNumber");
		PassengerTrain train = trains.get(trainNumber);
		
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if (trainNumber.equals("")) {
			out.println("Please, enter train's number");
		} else if (trains.containsKey(trainNumber)) {
			out.println("<h3>information about train № " + trainNumber + ": </h3>");
			out.println("number of cars: " + train.getList().size());
			out.print("locomotive: " + train.getLocomotive().getFuel());
		} else {
			out.print("<h3>Train with number " + trainNumber + " is absent in base</h3>");
		}
		
		out.print("<br>");
		out.println("<a href='http://localhost:8080/TransportWebProject/TrainSearch.html'>Back on main search page</a>");
		
		out.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
