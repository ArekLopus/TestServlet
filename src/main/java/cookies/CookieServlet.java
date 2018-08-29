package cookies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookieServlet")
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		Cookie cookie = new Cookie("name", "John Doe");
		cookie.setMaxAge(20 * 60);
		cookie.setHttpOnly(true);
		cookie.setSecure(false);
		
		response.addCookie(cookie);
		
		PrintWriter out = response.getWriter();
		out.println("<h2>Cookie Servlet</h2>");
		out.println("");
		
		String name = null;
		
		Cookie[] cookies = request.getCookies();
		for(Cookie c : cookies) {
			if (c.getName().equals("name") ) {
				name = c.getValue();
				break;
			}
		}
		
		if(name == null) {
			out.println("Hello Unknown");
		} else {
			out.println("Hello "+name);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
