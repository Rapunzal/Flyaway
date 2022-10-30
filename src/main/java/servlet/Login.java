package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import org.hibernate.Session;

import DAO.AdminLoginDAOImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("username");
		String password=request.getParameter("password");
		PrintWriter out=response.getWriter();
		boolean b=new AdminLoginDAOImpl().validate(name, password);
		if(b==true) {
			HttpSession session=request.getSession();
			session.setAttribute("username", name);
			System.out.println("Welcome login successful");
			RequestDispatcher rd=request.getRequestDispatcher("AdminHomePage.jsp");
			rd.forward(request, response);
		}else {
			HttpSession session=request.getSession();
			   String message = "Invalid email/password";
               request.setAttribute("message", message);
			RequestDispatcher rd=request.getRequestDispatcher("adminLogin.jsp");
			rd.forward(request, response);
		}
	}

}
