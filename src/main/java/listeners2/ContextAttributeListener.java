package listeners2;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

//@WebListener("Context Attribute Listener")
@SuppressWarnings("unused")
public class ContextAttributeListener implements ServletContextAttributeListener {
	
	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
		System.out.println("ServletContextAttributeListener.attributeAdded()");
		
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
		System.out.println("ServletContextAttributeListener.attributeRemoved()");
		
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {
		System.out.println("ServletContextAttributeListener.attributeReplaced()");
		
	}
	
	
}
