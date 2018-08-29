package files.nonblockingio;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.AsyncContext;
import javax.servlet.ReadListener;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

//	fileUpload/uploadNonBlockingIoMultipart.html
@WebServlet(urlPatterns = "/nonblockingioServlet", asyncSupported = true)
@MultipartConfig(location="d:/ccc",		// Very important, files are written relative to this location
fileSizeThreshold = 1024 * 1024 * 2, 	// 2MB
maxFileSize = 1024 * 1024 * 10, 		// 10MB
maxRequestSize = 1024 * 1024 * 50) 		// 50MB
public class NonBlockingIoMultipartUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<h2>Non Blocking IO Servlet</h2>");
		out.println("");
		
		File f = new File("d:/ccc");
		if(!f.exists()) {
			f.mkdir();
			out.write("<h2>Uplad dir created -> " + f.getPath() +  "</h2>");	
		}
		
		
		final AsyncContext acontext = request.startAsync();
	    final ServletInputStream input = request.getInputStream();
	    
	    input.setReadListener(new ReadListener() {
	         
	    	@Override
	    	public void onDataAvailable() {
	    		
				try {
					Collection<Part> parts = request.getParts();
					
					out.write("<h3> Total files : "+parts.size()+"</h3>");
				     
		            for(Part part : parts) {
		                out.write("<br/>part.getSubmittedFileName() -> "+part.getSubmittedFileName());
		                acontext.getResponse().getWriter().write("<br/>onDataAvailable() Thread: "+Thread.currentThread().getName());
		                part.write(part.getSubmittedFileName());
		            }
				} catch (IOException | ServletException e) {
					e.printStackTrace();
				}
	    		
	            
	    	}
	           
	        @Override
	        public void onAllDataRead() {
	        	try {
	        		acontext.getResponse().getWriter().write("<br/>onAllDataRead(), Thread: "+Thread.currentThread().getName());
	        	} catch (IOException ex) {
	        		System.out.println("Exception onAllDataRead: "+ex.getMessage());
	        	}
	        	acontext.complete();
	        }
	        
	        @Override
	        public void onError(Throwable t) {
	        	
	        }
	    });
	}


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	
}
