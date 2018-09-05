package exceptionsHandling;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/exceptionServlet2")
public class TestServletCustomExceptionObject extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<h2>Servlet</h2>");
		
		try {
			int x = 10/0;
			out.println( x );
		} catch (Exception e) {
			request.setAttribute("exception", e);
			request.getRequestDispatcher("/exceptionsHandling/errorPageCustomExceptionObject.jsp").forward(request, response);
		}
		
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
