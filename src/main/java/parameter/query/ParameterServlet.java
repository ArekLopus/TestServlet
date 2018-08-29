package parameter.query;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//	parameters/paramPost.html
//	parameters/paramGet.html
@WebServlet("/parameterServlet")
public class ParameterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		worker(request, response, "GET");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		worker(request, response, "POST");
	}
	
	
	public void worker(HttpServletRequest request, HttpServletResponse response, String method) throws IOException {
		
		response.setContentType("text/html");
		
		String parameter = request.getParameter("name");
		
		PrintWriter out = response.getWriter();
		out.println("<h2>Hello World from Servlet!</h2>");

		out.println("Method used: "+ method +", name parameter: " + parameter);
	}
	
}
