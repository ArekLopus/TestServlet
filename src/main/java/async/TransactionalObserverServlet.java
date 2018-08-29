package async;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/eventTransactionServlet", asyncSupported=true)
public class TransactionalObserverServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	EJBWithAsyncMethod et;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();
		
		response.setContentType("text/html");
		
		pw.println("<h2>Transaction Event Servlet</h2>");
		
		//Code that fires the event must be in transaction
		et.testEventSuccess();
		
		et.testEventFail();
		
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
}
