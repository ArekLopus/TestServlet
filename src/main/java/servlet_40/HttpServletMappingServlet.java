package servlet_40;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//http://localhost:8080/TestServlet/mappingServlet		- EXACT
//http://localhost:8080/TestServlet/abc.ext				- EXTENSION
//http://localhost:8080/TestServlet/path/abc			- PATH
@WebServlet(urlPatterns= {"/mappingServlet", "/path/*", "*.ext" })
public class HttpServletMappingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.println("");
		
		HttpServletMapping sm = request.getHttpServletMapping();
		
		out.println("");
		out.println("<br/>getMappingMatch() " + sm.getMappingMatch());
		out.println("<br/>sm.getMatchValue() " + sm.getMatchValue());
		out.println("<br/>sm.getPattern() " + sm.getPattern());
		out.println("<br/>getServletName() " + getServletName());
		
		
		
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
