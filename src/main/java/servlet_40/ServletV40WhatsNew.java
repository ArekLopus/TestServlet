package servlet_40;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletV40WhatsNew extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//https://www.ibm.com/developerworks/library/j-javaee8-servlet4/index.html
		//1. Server push 
		//2. HttpServletMapping interface
		//3. The Trailer response header allows the sender to include additional fields at the end of chunked messages.
		//   This is used to supply metadata that might be dynamically generated while the message body is sent,
		//   such as a message integrity check, digital signature, or post-processing status.
		//4. Servlet 4.0 adds the GenericFilter and HttpFilter abstract classes, which simplify writing filters
		//   by providing minimal implementations of the lifecycle methods init() and destroy().
		//5. Servlet 4.0 also integrates the new HTTP Trailer, which allows the sender
		//   to include additional fields at the end of a chunked message.
		//6. The ServletContext interface has new methods:
		//	 - addJspFile() adds the servlet with a given JSP file to the servlet context.
		//	 - getSessionTimeout() and setSessionTimeout() provide access to the session timeout.
		//	 - get/setRequestCharacterEncoding() provide access and mutate the default request char encoding for the current servlet context.
		//7. The isRequestedSessionIdFromUrl() method on the HttpServletRequest interface has been deprecated.
		//8. Default methods have been added to listener interfaces, thanks to the uplift to Java SE 8.
		
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
