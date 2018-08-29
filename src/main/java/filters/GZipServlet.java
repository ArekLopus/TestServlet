package filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Downloads zipped response
//curl -H "Accept-Encoding: gzip,deflate" -D - http://localhost:8080/TestServlet/compression/compressionServlet --output a.zip
@WebServlet("/compression/compressionServlet")
public class GZipServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<h2>Compression Servlet</h2>");
		out.println("Use to download zipped Response: ");
		out.println("<br/>curl -H \"Accept-Encoding: gzip,deflate\" -D - http://localhost:8080/TestServlet/compression/compressionServlet --output a.zip");
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
