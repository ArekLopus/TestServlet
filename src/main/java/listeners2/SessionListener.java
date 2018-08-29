package listeners2;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener("Session Listener")
public class SessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("HttpSessionListener.sessionCreated()");
		System.out.println("Object creating: " + se.getSource());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("HttpSessionListener.sessionDestroyed()");
		
	}
	
	
}
