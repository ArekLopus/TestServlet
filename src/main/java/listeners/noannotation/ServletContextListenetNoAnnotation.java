package listeners.noannotation;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import helper.User;

public class ServletContextListenetNoAnnotation implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("ServletContextListenetNoAnnotation.contextInitialized() called.");
		System.out.println("ServletContext is 1 per application so it is initialized only once.");
		System.out.println("Uses web.xml root");
		System.out.println("<listener>");
		System.out.println("    <listener-class>listeners.noannotation.ServletContextListenetNoAnnotation</listener-class>");
    	System.out.println("</listener>");
    	
    	User user = new User();
    	user.setName("User From ServletContext ");
    	user.setSurname("Iitialized by ServletContextListener");
    	
    	sce.getServletContext().setAttribute("user", user);
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("ServletContextListener.contextDestroyed() called.");
		
	}

}
