package listeners3_1;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionIdListener;

//@WebListener("Session Id Listener")
@SuppressWarnings("unused")
public class SessionIdListener implements HttpSessionIdListener {
	
	@Override
	public void sessionIdChanged(HttpSessionEvent event, String oldSessionId) {
		System.out.println("HttpSessionIdListener.sessionIdChanged()");
		
	}
	
	
}
