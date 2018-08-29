package async;

import java.io.IOException;
import java.io.PrintWriter;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/asyncServ44", asyncSupported=true)
public class AsyncServletWithEvent2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	@AsyncQualifier(2)
	private Event<AsyncContext> event;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		
		pw.println("<h2>Async Servlet with Event firing </h2>");
		
		pw.println("Starting thread: "+Thread.currentThread().getName() + "<br/>");
		pw.println("Starting async...<br/>");
		
		AsyncContext asyncCtx = request.startAsync(request,response);
		event.fire(asyncCtx);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
