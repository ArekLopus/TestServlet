package session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessionServlet2")
public class SessionServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<h2>Session Servlet 2</h2>");
		out.println("");
		
		
		HttpSession session = request.getSession();
		
		//Life of session in seconds (overrides session-config / session-timeout in web.xml)
		session.setMaxInactiveInterval(20 * 60);
		
		if(session.isNew())
			out.println("New Session Created<br/>");
		
		//Protects from 2 thread changing the code (2 browser windows)
		synchronized (session) {
			Integer counter = (Integer) session.getAttribute("couner");
			out.println("Counter before: " + counter);
			
			if(counter == null) {
				session.setAttribute("couner", 1);
			} else {
				session.setAttribute("couner", ++counter);
			}
			
			counter = (Integer) session.getAttribute("couner");
			out.println("Counter after: " + counter);
			
			if(counter == 3) {
				out.println("<br/>Session Invalidated<br/>");
				session.invalidate();
			}
		}
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
