package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import DAO.MasterListDAO;

/**
 * Servlet implementation class ListOfPlaces
 */
@WebServlet("/ListOfPlaces")
public class ListOfPlaces extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListOfPlaces() {
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
		MasterListDAO obj=new MasterListDAO();
		List<String> list=obj.getMasterListOfPlaces();
		PrintWriter out=response.getWriter();
		out.println("<html><head></head><body>");
		out.println("<form method='post' >");
		out.println("<table>");
		for(String str:list) {
			out.println("<tr><td>");
			System.out.println(str);
		out.println(str);
		out.println("</td>");
		out.println("</tr>");
		
		}
		out.println("<tr><td><input type='submit' value='Add Place'></td></tr>");
		out.println("</table></form></body></html>");
		
		//RequestDispatcher rd=request.getRequestDispatcher("");
		//rd.include(request, response);
	}

}
