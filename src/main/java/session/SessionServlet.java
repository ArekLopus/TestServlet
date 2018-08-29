package session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessionServlet")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<h2>Session Servlet</h2>");
		out.println("");
		
		
		HttpSession session = request.getSession();
		
		//Life of session in seconds (overrides session-config / session-timeout in web.xml)
		session.setMaxInactiveInterval(20 * 60);
		session.setAttribute("MyAttribute", "MyAttrib");
		
		if(session.isNew()) {
			out.println("New Session Created");
		} else {
			out.println("Session Already Exists");
		}
		
		out.println("<br/>getId(): " + session.getId());
		out.println("<br/>getCreationTime(): " + session.getCreationTime());
		out.println("<br/>getLastAccessedTime(): " + session.getLastAccessedTime());
		out.println("<br/>getMaxInactiveInterval(): " + session.getMaxInactiveInterval());
		out.println("<br/>getAttributeNames(): ");
		
		Enumeration<String> attributeNames = session.getAttributeNames();
		
		while(attributeNames.hasMoreElements()) {
			out.println("<br/>&nbsp;&nbsp;- "+attributeNames.nextElement());
		}
		
		
		
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
