package webservlet.noannotationservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class NoAnnotationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h2>Hello World from No Annotation Servlet!</h2>");
		out.println("<div style=\"white-space: pre;\" >");
	    
		out.println("It needs 2 enttries in web.xml file -> servet class and url-pattern");
	    
		out.println("");
	    
		out.println("&lt;servlet&gt;");
	    out.println("    &lt;servlet-name&gt;NoAnnotationServlet&lt;/servlet-name&gt;");
	    out.println("    &lt;servlet-class&gt;noannotationservlet.NoAnnotationServlet&lt;/servlet-class&gt;");
	    out.println("&lt;/servlet&gt;");
	    out.println("&lt;servlet-mapping&gt;");
	    out.println("    &lt;servlet-name&gt;NoAnnotationServlet&lt;/servlet-name&gt;");
	    out.println("    &lt;url-pattern&gt;/noAnnotationServlet&lt;/url-pattern&gt;");
	    out.println("&lt;/servlet-mapping&gt;");
	    out.println("</div>");
		
        
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
