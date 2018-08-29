package security.ssl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ssl/sslServlet")
public class SslServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<h2>Ssl Servlet</h2>");
		
		if(request.getSession(false) != null) {
			System.out.println("/ssl/sslServlet called, session: " + request.getSession(false).getId());
			out.println("<br/>/ssl/sslServlet called, session: " + request.getSession(false).getId());
		} else {
			System.out.println("/ssl/sslServlet called, session: NULL");
			out.println("<br/>/ssl/sslServlet called, session: NULL");
		}
		
		out.println("<br/>request.isSecure(): " + request.isSecure());
		out.println("<br/>request.getScheme(): " + request.getScheme());
		
		out.println("<br/>Principal: " + request.getUserPrincipal());
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
