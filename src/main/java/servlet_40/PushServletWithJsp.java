package servlet_40;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.PushBuilder;

//https://localhost:8181/TestServlet/pushServletJsp
@WebServlet("/pushServletJsp")
public class PushServletWithJsp extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PushBuilder pushBuilder = request.newPushBuilder();
		 
		if (pushBuilder != null) {
			System.out.println("Push NOT NULL");
			pushBuilder.path("css/myCss.css").addHeader("Content-type", "text/css").push();
			pushBuilder.path("css/smile.jpg").addHeader("Content-type", "image/png").push();
			
			request.getRequestDispatcher("push/push.jsp").forward(request, response);

		} else {
			System.out.println("Push NULL");
		}
		
		
		
		
		
		
		
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
