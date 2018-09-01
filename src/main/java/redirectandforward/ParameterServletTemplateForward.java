package redirectandforward;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helper.User;

//-When forwarding the URL remains the same!
//-Forwards the request to another resource in our web application. This resource is typically another servlet or JSP page.
//-To do this, we use the forward method belonging to the RequestDispatcher interface.
//		request.getRequestDispatcher("products.jsp").forward(request, response);
//-This approach is faster because everything happens in a single response-request cycle.

//	parameters/paramPostTemplateForward.html
@WebServlet("/parameterServletTemplateForward")
public class ParameterServletTemplateForward extends HttpServlet {
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
		
		request.setAttribute("user", user);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("parameters/paramPostTemplateRequest.jsp");
		requestDispatcher.forward(request, response);
		
	}
	
}
