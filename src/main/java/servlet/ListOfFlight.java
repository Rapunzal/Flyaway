package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import DAO.FlightDAO;
import DAO.FlightDAOImpl;
import DAO.MasterListDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import persistence.Flight;

/**
 * Servlet implementation class ListOfFlight
 */
@WebServlet("/ListOfFlight")
public class ListOfFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListOfFlight() {
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
	
		List<Flight> list=MasterListDAO.getMasterListOfFlights();
		
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<head><meta charset=\"UTF-8\">\n"
				+ "<link rel=\"stylesheet\"\n"
				+ "	href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\n"
				+ "<script\n"
				+ "	src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js\"></script>\n"
				+ "<script\n"
				+ "	src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>\n"
				+ "<title>Flight List</title></head><body><div class=\"text-center\" style=\"margin: auto\"><h2>List of Flights</h2></div>");
		out.println("<form action='addFlight.jsp' method='post'>");
		out.println("<input type='submit' value='Add Flight'>");
		out.println("<table class=\"table table-bordered text-center\" style=\"width: 500px; margin-left: auto; margin-right: auto; margin-top: 40px; margin-bottom: 40px border: 0px\">");
		out.println("<tbody class=\"text-center\">");
		out.println("<tr style=\"font-size: 1.00em\"><td>Flight No</td><td>Airline Name</td><td>Source</td><td>Destination</td><td>Price</td><td>Seat Capacity</td></tr>");
		
		for(Flight f:list) {
			out.println("<tr><td style=\"padding-top: 5px; padding-bottom: 5px\">");
			String airlineName=FlightDAO.getAirlineName(f.getAirlineId());
			System.out.println(f.getFlightNo());
		out.println(f.getFlightNo());
		out.println("</td>");
		out.println("<td style=\"padding-top: 5px; padding-bottom: 5px\">");
		out.println(airlineName);
		out.println("</td>");
		out.println("<td style=\"padding-top: 5px; padding-bottom: 5px\">");
		out.println(f.getSource());
		out.println("</td>");
		out.println("<td style=\"padding-top: 5px; padding-bottom: 5px\">");
		out.println(f.getDestination());
		out.println("</td>");
		out.println("<td style=\"padding-top: 5px; padding-bottom: 5px\">");
		out.println(f.getPrice());
		out.println("</td>");
		out.println("<td style=\"padding-top: 5px; padding-bottom: 5px\">");
		out.println(f.getSeatCapacity());
		out.println("</td></tr>");
		}
		
		out.println("</tbody");
		out.println("</table>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		//RequestDispatcher rd=request.getRequestDispatcher("");
		//rd.include(request, response);
	}

}
