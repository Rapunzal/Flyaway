package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import DAO.AdminLoginDAOImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class ChangePassword
 */
@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePassword() {
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
		PrintWriter pw=response.getWriter();
		HttpSession session=request.getSession();
		String name=(String) session.getAttribute("username");
		System.out.println(name+"===========");
		String password=request.getParameter("oldpassword");
		String newpassword=request.getParameter("newpassword");
		String newpassword1=request.getParameter("newpassword1");
		if(!newpassword.equals(newpassword1)) {
			pw.println("password do not match");
			RequestDispatcher rd=request.getRequestDispatcher("AdminHomePage.jsp");
			rd.include(request, response);
		}else {
		boolean b=new AdminLoginDAOImpl().changePassword(name, newpassword);
		if(b==true) {
			System.out.println("Password changed successfully");
			RequestDispatcher rd=request.getRequestDispatcher("AdminHomePage.jsp");
			rd.include(request, response);
		}else {
			System.out.println("Password not changed");
		}
	}
	}
}
