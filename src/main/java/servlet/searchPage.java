package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import DAO.FlightDAO;
import DAO.FlightDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import persistence.Availability;
import persistence.DaysOFOperation;
import persistence.Flight;

/**
 * Servlet implementation class searchPage
 */
@WebServlet("/searchPage")
public class searchPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchPage() {
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
		
		HttpSession session=request.getSession();
		
		PrintWriter out=response.getWriter();
		String date=request.getParameter("dateOfTravel");
		System.out.println(date+"======");
		String source=request.getParameter("source");
		String destination=request.getParameter("destination");
		String noOfPerson=request.getParameter("numOfPerson");
		int n=Integer.parseInt(noOfPerson);
		session.setAttribute("noOfPerson", n);
		System.out.println(source+"  "+destination+"  "+noOfPerson);
		int i=0;
		List<Flight> flight=FlightDAO.getAllFlightSearch(source, destination, date, n);
		Availability a=new  Availability();
		out.println("<head><meta charset=\"UTF-8\">\n"
				+ "<link rel=\"stylesheet\"\n"
				+ "	href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\n"
				+ "<script\n"
				+ "	src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js\"></script>\n"
				+ "<script\n"
				+ "	src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>\n"
				+ "<title>Available Flights</title></head><body><div class=\"text-center\" style=\"margin: auto\"><h2>Available Flights</h2></div><form method='post' action='PassengerRegistration.jsp'>");
		out.println("<table class=\"table table-bordered text-center\" style=\"width: 700px; margin-left: auto; margin-right: auto; margin-top: 40px; margin-bottom: 40px\">");
		out.println("<tbody class=\"text-center\">");
		out.println("<tr style=\"font-size: 1.00em\"><td>Flight No</td><td>Airline Name</td><td>Price</td><td>Available seats</td></tr>");
		for(Flight f:flight) {
			System.out.println(i++);
		out.println("<tr><td>"+	f.getFlightNo());
		DaysOFOperation d=FlightDAO.getFlightDaysOfOperation(f.getFlightNo(),date);
		
		//System.out.println("days of operation---"+d.getMonday());
		if(d.getMonday().equals("YES")|| d.getTuesday().equals("YES")|| d.getWednesday().equals("YES")||d.getThursday().equals("YES")|| d.getFriday().equals("YES")||d.getSaturday().equals("YES")||d.getSunday().equals("YES")) {
			a=FlightDAO.getFlightAvaliablity(f.getFlightNo(), date,n);
			if(a.getFlightNo()==null) {
				FlightDAO.insertIntoAvaliblity(f.getFlightNo(),date);
				a=FlightDAO.getFlightAvaliablity(f.getFlightNo(), date,n);
			}
		} 
		 
		
		String airLineName=FlightDAO.getAirlineName(f.getAirlineId());
		out.println("</td><td>"+airLineName);
		
			out.println("</td><td>"+a.getPrice()+"</td>");
			out.println("<td>"+(a.getBookedSeat())+"</td>");
			int price =(int) a.getPrice();
			int priceOfTicket=n*price;
			session.setAttribute("price", priceOfTicket);
			session.setAttribute("flightId", f.getFlightNo());
			session.setAttribute("date", date);
			//session.setAttribute("", a);
			//session.setAttribute("numOfPerson",numOfPerson );
			out.println("<td><input class=\"btn btn-primary center\" type='submit' value='Book'></td>");
			out.println("</tr>");
		}
		out.println("</tbody>");
		out.println("</table>");
		out.print("</form></body>");
		}
		
	}


