package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import DAO.BookingDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class SaveBooking
 */
@WebServlet("/SaveBooking")
public class SaveBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveBooking() {
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
		int passengerid=(int)session.getAttribute("passId");
		String fltId=(String)session.getAttribute("flightId");
		int noOfPerson=(int)session.getAttribute("noOfPerson");
		int totalprice=(int)session.getAttribute("price");
		String date=(String)session.getAttribute("date");
		
		
		System.out.println(passengerid+"======>>>>>>");
		String str=request.getParameter("flightno");
		System.out.println(str);
		String str1=(String) session.getAttribute("seat");
		int seat=Integer.parseInt(str1);
		System.out.println(str1);
		int x=BookingDAO.setBookingDetails(fltId, noOfPerson, passengerid,totalprice,date,seat);
		PrintWriter out=response.getWriter();
		out.println("Booked Successfully");
		out.println("Booking id is "+BookingDAO.getBookingId(fltId));
	}

}
