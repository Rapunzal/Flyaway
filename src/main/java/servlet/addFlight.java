package servlet;

import java.io.IOException;

import DAO.FlightDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class addFlight
 */
@WebServlet("/addFlight")
public class addFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addFlight() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String flightno=request.getParameter("flightno");
		String airlineName=request.getParameter("airlinename");
		String source=request.getParameter("source");
		String destination=request.getParameter("destination");
		String price=request.getParameter("price");
		String seatcapacity=request.getParameter("seatCapacity");
		int n=Integer.parseInt(price);
		int capacity=Integer.parseInt(seatcapacity);
		int x=FlightDAO.addFlightrecord(flightno, airlineName, source, destination,n,capacity);
		//FlightDAO.delete();
		if(x>0) {
			System.out.println("Airline added successfully"+x);
			RequestDispatcher rd=request.getRequestDispatcher("ListOfFlight");
			rd.include(request, response);
			}
			else {
				System.out.println("Cannot add ...error occured");
			}
		System.out.println("Record added...");
	}

}
