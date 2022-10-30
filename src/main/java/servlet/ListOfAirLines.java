package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import DAO.MasterListDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListOfAirplanes
 */
@WebServlet("/ListOfAirLines")
public class ListOfAirLines extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListOfAirLines() {
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
		// TODO Auto-generated method stub
		MasterListDAO obj=new MasterListDAO();
		List<String> list=obj.getMasterListOfAirLines();
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<body>");
		
		out.println("<head><meta charset=\"UTF-8\">\n"
				+ "<link rel=\"stylesheet\"\n"
				+ "	href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\n"
				+ "<script\n"
				+ "	src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js\"></script>\n"
				+ "<script\n"
				+ "	src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>\n"
				+ "<title>Available Flights</title></head>");
		
		out.println("<div class=\"text-center\" style=\"margin: auto\"><h2>List of Airlines</h2></div>");
		
		
		out.println("<form action='addAirline.jsp'>");
		out.println("<div class=\"text-center\" style=\"margin: auto\"><input class=\"btn btn-primary \" type='submit' value='Add New Airline'></div>");
		out.println("<table class=\"table table-bordered text-center\" style=\"width: 300px; margin-left: auto; margin-right: auto; margin-top: 40px; margin-bottom: 40px\">");
		out.println("<th class=\"text-center\">");
		out.println("OPERATING AIRLINES");
		out.println("</th>");
		for(String str:list) {
			out.println("<tr><td>");
		out.println(str);
		out.println("</td></tr>");
		}
		
		out.println("</table></form></body></html>");

	}

}
