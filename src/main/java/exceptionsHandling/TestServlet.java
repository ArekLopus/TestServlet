package exceptionsHandling;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//-Use <error-page> in DD to declare different pages for different exceptions ( <exception-type> or <erroe-code> )
//	<error-page>
//		<exception-type>java.lang.ArithmeticException</exception-type>
//		<location>/errorPage.jsp</location>
//	</error-page>
//	<error-page>
//		<erroe-code>404</erroe-code>
//		<location>/pageNotFound.html</location>
//	</error-page>

@WebServlet("/exceptionServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<h2>Servlet</h2>");
		out.println( 10/0 );
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
