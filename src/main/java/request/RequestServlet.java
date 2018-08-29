package request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//To see parameters: 
//http://localhost:8080/TestServlet/requestServlet?name=paramName
@WebServlet("/requestServlet")
public class RequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<h2>Request Servlet!</h2>");
		
		out.println("<br/>Port that request was sent to - getServerPort(): "+request.getServerPort());
		out.println("<br/>Port that request got to - getLocalPort(): "+request.getLocalPort());
		out.println("<br/>request.getLocalAddr(): "+request.getLocalAddr());
		out.println("<br/>request.getLocalName(): "+request.getLocalName());
		out.println("<br/>Client port - getRemotePort(): "+request.getRemotePort());
		out.println("<br/>request.getRemoteAddr(): "+request.getRemoteAddr());
		out.println("<br/>request.getRemoteHost(): "+request.getRemoteHost());
		out.println("<br/>request.getRemotePort(): "+request.getRemotePort());
		out.println("<br/>request.getRemoteUser(): "+request.getRemoteUser());
		
		out.println("<br/>getAuthType(): "+request.getAuthType());
		out.println("<br/>getCharacterEncoding(): "+request.getCharacterEncoding());
		out.println("<br/>getContentLength(): "+request.getContentLength());
		out.println("<br/>getContentType(): "+request.getContentType());
		out.println("<br/>getContextPath(): "+request.getContextPath());
		out.println("<br/>getCookies(): "+request.getCookies().length);
		out.println("<br/>getHeader(\"User-Agent\"): "+request.getHeader("User-Agent"));
		out.println("<br/>getLocale(): "+request.getLocale());
		out.println("<br/>getMethod(): "+request.getMethod());
		out.println("<br/>getParameter(\"name\"): "+request.getParameter("name"));
		out.println("<br/>getProtocol(): "+request.getProtocol());
		out.println("<br/>getQueryString(): "+request.getQueryString());
		out.println("<br/>getRequestedSessionId(): "+request.getRequestedSessionId());
		out.println("<br/>getRequestURI(): "+request.getRequestURI());
		out.println("<br/>getRequestURL(): "+request.getRequestURL());
		out.println("<br/>getScheme(): "+request.getScheme());
		out.println("<br/>getServerName(): "+request.getServerName());
		out.println("<br/>getServerPort(): "+request.getServerPort());
		out.println("<br/>getServletPath(): "+request.getServletPath());
		out.println("<br/>getUserPrincipal(): "+request.getUserPrincipal());
		out.println("<br/>isAsyncStarted(): "+request.isAsyncStarted());
		out.println("<br/>isAsyncSupported(): "+request.isAsyncSupported());
		out.println("<br/>isSecure(): "+request.isSecure());
		out.println("<br/>isUserInRole(\"admin\"): "+request.isUserInRole("admin"));
		
		//request.authenticate(response)
		//request.changeSessionId()
		//request.getAsyncContext()
		//request.getDateHeader(name)
		//request.getDispatcherType()
		//request.getHttpServletMapping()
		//request.getInputStream()
		//request.getIntHeader(name)
		//request.getPart(name)
		//request.getParts()
		//request.getReader()
		//request.getRequestDispatcher(path)
		//request.getServletContext()
		//request.getSession()
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
