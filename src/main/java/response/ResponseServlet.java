package response;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/responseServlet")
public class ResponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.println("<h2>Response Servlet!</h2>");
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		response.setLocale(Locale.US);
		response.addCookie(new Cookie("servletCookie", "servletCookieValue"));
		response.setDateHeader("MyDateHeader", System.currentTimeMillis());
		response.setHeader("MyHeader", "MyHeaderValue");
		
		//The logic determine whether the session ID needs to be encoded in the URL.
		//Fe, if the browser supports cookies, or session tracking is turned off, URL encoding isunnecessary. 
		out.println("response.encodeRedirectURL(\"/responseServlet\"): "+response.encodeRedirectURL("/responseServlet"));
		out.println("<br/>response.encodeURL(\"/responseServlet\"): "+response.encodeURL("/responseServlet"));
		
		out.println("<br/>response.getBufferSize(): "+response.getBufferSize());
		out.println("<br/>response.getCharacterEncoding(): "+response.getCharacterEncoding());
		
		out.println("<br/>response.getStatus(): "+response.getStatus());
		out.println("<br/>response.getContentType(): "+response.getContentType());
		
		out.println("<br/>response.isCommitted(): "+response.isCommitted());
		
		out.println("<br/>response.getLocale(): "+response.getLocale());
		
		//response.getOutputStream()
		
		//response.flushBuffer();		//Automatically commits the response
		//response.reset();				//Clears any data that exists in the buffer as well as the status code,headers. 
		
		//response.sendRedirect("./sessionServlet2");
		
		//response.sendError(404);
		//response.sendError(200, "ALL IS GOOD");
		//response.setStatus(200);
		
				
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
