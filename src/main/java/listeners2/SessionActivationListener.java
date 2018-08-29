package listeners2;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

//@WebListener("Session Activation Listener")
@SuppressWarnings("unused")
public class SessionActivationListener implements HttpSessionActivationListener {

	@Override
	public void sessionWillPassivate(HttpSessionEvent se) {
		System.out.println("HttpSessionActivationListener.sessionWillPassivate()");
		
	}

	@Override
	public void sessionDidActivate(HttpSessionEvent se) {
		System.out.println("HttpSessionActivationListener.sessionDidActivate()");
		
	}
	
}
