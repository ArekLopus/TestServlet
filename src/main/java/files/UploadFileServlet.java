package files;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

//fileUpload/upload.html
@WebServlet("/uploadFileServlet")
@MultipartConfig(location="d:/ccc",				// Very important, files are written relative to this location
		fileSizeThreshold = 1024 * 1024 * 2, 	// 2MB
		maxFileSize = 1024 * 1024 * 10, 		// 10MB
		maxRequestSize = 1024 * 1024 * 50) 		// 50MB
public class UploadFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.write("<h2>Upload File Servlet</h2>");
		
		File f = new File("d:/ccc");
		if(!f.exists()) {
			f.mkdir();
			out.write("<h2>Uplad dir created -> " + f.getPath() +  "</h2>");	
		}
		
		Collection<Part> parts = request.getParts();
		
        out.write("<h3> Total files : "+parts.size()+"</h3>");
 
        for(Part part : parts) {
            printPart(part, out);
            out.write("<br/>part.getSubmittedFileName() -> "+part.getSubmittedFileName());    
            part.write(part.getSubmittedFileName());
        }
		
	}

	private void printPart(Part part, PrintWriter pw) {
        StringBuffer sb = new StringBuffer();
        sb.append("Name : "+part.getName());
        sb.append("<br>");
        sb.append("Content Type : "+part.getContentType());
        sb.append("<br>");
        sb.append("Size : "+part.getSize());
        sb.append("<br>");
        sb.append("Headers:");
        sb.append("<br>");
        for(String header : part.getHeaderNames()) {
            sb.append(header + " : "+part.getHeader(header));
            sb.append("<br>");
        }
        pw.write(sb.toString());
 
    }
	
}
