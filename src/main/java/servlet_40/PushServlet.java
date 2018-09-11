package servlet_40;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.PushBuilder;

//https://www.ibm.com/developerworks/library/wa-http2-under-the-hood/index.html
//https://www.ibm.com/developerworks/library/j-javaee8-servlet4/index.html	(video 1)
//chrome://net-internals/#http2		-> conversation between the browser and the server

//HTTPS needed!
//https://localhost:8181/TestServlet/pushServlet
@WebServlet("/pushServlet")
public class PushServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.write("<html>");
		out.write("<head>");
		out.write("<link rel='stylesheet' type='text/css' href='css/myCss.css'>");
		out.write("</head>");
		out.write("<body>");
		out.write("");
		
		out.write("<h2>Push Servlet 4.0</h2>");
		out.write("");
		
		out.write("<img src='css/smile.jpg' style='width:256px; height: auto;'>");
	    
		out.write("</body>");
		out.write("</html>");
		

		PushBuilder pushBuilder = request.newPushBuilder();
		 
		if (pushBuilder != null) {
			response.getWriter().println("<br/>PushBuilder NOT NULL");
			pushBuilder.path("css/myCss.css").addHeader("Content-type", "text/css").push();
			pushBuilder.path("css/smile.jpg").addHeader("Content-type", "image/png").push();

		} else {
			response.getWriter().println("<br/>PushBuilder was NULL");
		}
		
		
		
		
		
		
		
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
