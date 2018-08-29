package async;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/asyncServ4", asyncSupported=true)
public class AsyncServletWithEvent1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	@AsyncQualifier(1)
	private Event<AsyncContext> event;
	
	@Resource
	ManagedExecutorService mes;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		
		pw.println("<h2>Async Servlet with Event firing </h2>");
		
		AsyncContext startAsync = request.startAsync(request,response);
		
		mes.execute(()->{
			try {
				request.setAttribute("message", "Start Message");
				startAsync.getResponse().getWriter().println("Staring Thread:<br/>"+Thread.currentThread().getName()+"<br/><br/>");
			
				event.fire(startAsync);
				Thread.sleep(1000);
		
				request.setAttribute("message", "Message1");
				event.fire(startAsync);
			
				Thread.sleep(1000);
				//if(true)throw new RuntimeException();
				request.setAttribute("message", "Message2");
			
				event.fire(startAsync);
				Thread.sleep(1000);
			
				request.setAttribute("message", "Final Message");
				event.fire(startAsync);
			} catch (InterruptedException | IOException e) {
				e.printStackTrace();
			}
		});
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
