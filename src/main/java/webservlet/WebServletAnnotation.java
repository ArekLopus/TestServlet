package webservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//	@WebServlet
//-Classes @ed with @WebServlet must extend the javax.servlet.http.HttpServlet class.
//-Use the value attribute when the only attribute on the @ is the URL pattern;
// otherwise, use the urlPatterns attribute when other attributes are also used.

@WebServlet("/testServlet")
public class WebServletAnnotation extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<h2>Test Servlet</h2>");
		out.println("@WebServlet(\"/testServlet\")");
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
