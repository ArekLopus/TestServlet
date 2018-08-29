package listeners3_0;

import java.io.IOException;

import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;

//Unlike other servlet listeners dont use @WebListener, use AsyncContext.addListener() instead.
public class AsyncListenerTest implements AsyncListener {
	//https://coderanch.com/t/487555/java/Asynchronous-Servlet-onStartAsync-AsyncEvent-event
	@Override
	public void onStartAsync(AsyncEvent event) throws IOException {
		System.out.println("AsyncListener.onStartAsync()");
		event.getAsyncContext().addListener(this);
		event.getAsyncContext().getResponse().getWriter().println("<h2 style = 'color: red'>AsyncListener.onStartAsync() called</h2>");
		
	}
	
	@Override
	public void onComplete(AsyncEvent event) throws IOException {
		System.out.println("AsyncListener.onComplete()");
		event.getAsyncContext().getResponse().getWriter().println("<h2 style = 'color: red'>AsyncListener.onComplete() called</h2>");
	}

	@Override
	public void onTimeout(AsyncEvent event) throws IOException {
		System.out.println("AsyncListener.onTimeout()");
		event.getAsyncContext().getResponse().getWriter().println("<h2 style = 'color: red'>Timeout Cccured!</h2>");
	}

	@Override
	public void onError(AsyncEvent event) throws IOException {
		System.out.println("AsyncListener.onError()");
		event.getAsyncContext().getResponse().getWriter().println("<h2 style = 'color: red'>AsyncListener.ononError() called</h2>");
	}

}
