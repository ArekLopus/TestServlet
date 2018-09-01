package redirectandforward;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import helper.User;

//-Redirect will send a HTTP 302 response instructing the browser to perform a new GET request to the specified URL.
//-To do this, we use the sendRedirect() belonging to the HttpServletResponse interface:
//		response.sendRedirect("https://www.google.com");
//-This is useful when we want to send the user to a different domain or server outside of our web application.
//-The drawback is that we lose the original request along with its parameters and attributes.

//	parameters/paramPostTemplateRedirect.html
@WebServlet("/parameterServletTemplateRedirect")
public class ParameterServletTemplateRedirect extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		worker(request, response, "GET");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		worker(request, response, "POST");
	}
	
	
	public void worker(HttpServletRequest request, HttpServletResponse response, String method) throws IOException, ServletException {
		
		
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String city = request.getParameter("city");
		
		User user = new User();
		user.setName(name);
		user.setSurname(surname);
		user.setCity(city);
		int phone = ThreadLocalRandom.current().nextInt(100000000);
		user.setPhone(String.valueOf(phone));
		
		HttpSession session = request.getSession(true);
		session.setAttribute("user", user);
		
		response.sendRedirect("parameters/paramPostTemplateSession.jsp");
		
//		RequestDispatcher requestDispatcher = request.getRequestDispatcher("parameters/formActionSession.jsp");
//		requestDispatcher.forward(request, response);
		
	}
	
}
