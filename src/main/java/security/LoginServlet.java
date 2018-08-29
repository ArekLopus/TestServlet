package security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<h2>Login Servlet</h2>");
		
		//Need to create a session to login be 'remembered'
		//Otherwise secured resource is logged and browser remembers the token
		HttpSession session  = request.getSession();
		session.setAttribute("Before login attribute", "Before login attribute");
		out.println("<br/>Session Id before log in: "+session.getId());
		
		try {
			request.login("admin", "admin");
			out.println("<br/>Login SUCCESSFUL!");

			session  = request.getSession();
			if(session != null) {
				session.setAttribute("After login attribute", "After login attribute");
				out.println("<br/>Session Id after log in: "+session.getId());
				out.println("<br/><br/>Session is created before login. After login its ID changes but attribute stays, "
						+ "so it is not destroyed. Container only changes its ID.");
			} else {
				out.println("<br/><br/>Session is NULL");
			}
			
			out.println("<br/><br/>Is user in role 'admin': "+request.isUserInRole("admin"));
			out.println("<br/>Before login attribute: "+session.getAttribute("Before login attribute"));
			out.println("<br/>After login attribute: "+session.getAttribute("After login attribute"));
			out.println("<br/>Principal: "+ request.getUserPrincipal());
			
		} catch (Exception e) {
			out.println("<br/>Login FAILED!");
		}
		

		
		

	
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
