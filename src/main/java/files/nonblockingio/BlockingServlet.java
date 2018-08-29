package files.nonblockingio;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//https://plumbr.io/blog/java/how-to-use-asynchronous-servlets-to-improve-performance
@WebServlet(urlPatterns = "/blockingServlet")
public class BlockingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.setContentType("text/html");
		
		int sleep = waitForData();
		
		PrintWriter out = response.getWriter();
		out.println("<h2>Blocking Servlet</h2>");
		out.println("Servlet was blocked for ms: "+sleep);
	}

	public static int waitForData() {
		try {
			int sleep = ThreadLocalRandom.current().nextInt(2000);
			Thread.sleep(sleep);
			return sleep;
		} catch (InterruptedException e) {
			e.printStackTrace();
			return 0;
		}
	}
}