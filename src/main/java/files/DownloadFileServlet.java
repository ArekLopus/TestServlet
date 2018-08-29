package files;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/downloadFileServlet")
public class DownloadFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//To display file
		response.setContentType("text/plain");
		
		//To dpwnload file
		//response.setContentType("application/octet-stream");
		//response.setHeader("Content-Disposition", "attachment; filename=\"alice.txt\"");
		
		
		int read = 0;
		byte[] buffer = new byte[1024];
		
		InputStream is = getServletContext().getResourceAsStream("/WEB-INF/classes/alice30.txt");
		OutputStream os = response.getOutputStream();
		
		while( (read = is.read(buffer)) != -1) {
			os.write(buffer, 0, read);
		}
		os.flush();
		os.close();
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
