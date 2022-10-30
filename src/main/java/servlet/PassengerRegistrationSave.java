package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import DAO.SaveRegistrationDAO;
import jakarta.servlet.http.HttpSession;
import persistence.Passenger;

/**
 * Servlet implementation class PassengerRegistrationSave
 */
@WebServlet("/PassengerRegistrationSave")
public class PassengerRegistrationSave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PassengerRegistrationSave() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("PassengerRegistrationSave");
		
		String firstname=request.getParameter("fname");
		String lastname=request.getParameter("lastname");
		String dob=request.getParameter("dateOfBirth");
		String idno=request.getParameter("idNo");
		String emailId=request.getParameter("emailId");
		String password=request.getParameter("password");
		Passenger pass=new Passenger();
		pass.setFname(firstname);
		pass.setLname(lastname);
		pass.setDOB(dob);
		pass.setIdentificationNum(idno);
		pass.setEmailId(emailId);
		pass.setPassword(password);
		SaveRegistrationDAO obj=new SaveRegistrationDAO();
		obj.addPassengerC(pass);
		System.out.println("user added");
		int passengerId=obj.getPassengerId(emailId);
		HttpSession session=request.getSession();
		System.out.println(passengerId+"=========passenger id");
		System.out.println("-----flight--->"+session.getAttribute("flightId"));
		session.setAttribute("passId", passengerId);
		RequestDispatcher rd=request.getRequestDispatcher("Booking.jsp");
		rd.forward(request, response);
	}

}
