package files.nonblockingio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helper.ServletUtil;

//https://plumbr.io/blog/java/how-to-use-asynchronous-servlets-to-improve-performance
@WebServlet(asyncSupported = true, value = "/blockingServlet2")
public class BlockingServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final BlockingQueue<AsyncContext> queue = new ArrayBlockingQueue<>(20000);
	private static ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
	static {
	    executorService.scheduleAtFixedRate(BlockingServlet2::newEvent, 0, 2, TimeUnit.SECONDS);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		addToWaitingList(request.startAsync());
	}

	

	private static void newEvent() {
		List<AsyncContext> clients = new ArrayList<>(queue.size());
		queue.drainTo(clients);
		
		clients.parallelStream().forEach( ac -> {
			ServletUtil.writeResponse(ac.getResponse(), "OK");
		    ac.complete();
		});
	}

	

	public static void addToWaitingList(AsyncContext c) {
		queue.add(c);
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