package files.nonblockingio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;
import javax.servlet.ReadListener;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//-The problem is that IS from request contains binary data and additional information when <form> posted
//	Use Postman to post some data as raw / binary / others
//	fileUpload/uploadNonBlockingIoFetch.html - > uses fetch to post only jpg picture binary 
@WebServlet(urlPatterns = "/nonblockingioServlet2", asyncSupported = true)
public class NonBlockingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.setContentType("text/html; charset=utf-8");
		
		final AsyncContext acontext = request.startAsync(request, response);
	    final ServletInputStream input = request.getInputStream();
	      
	    input.setReadListener(new ReadListener() {
	    	byte buffer[] = new byte[4*1024];
	    	StringBuilder sbuilder = new StringBuilder();
	    	FileOutputStream to = new FileOutputStream("d:/ccc/abc.jpg");
	    	
	    	@Override
	    	public void onDataAvailable() {
	    		try {

	    			while(input.isReady()) {
	    				int length = input.read(buffer);
	    				to.write(buffer, 0, length);
	                    sbuilder.append(new String(buffer, 0, length));
	    			}
	    			to.flush();
	    			to.close();
	    			
	    		} catch (IOException ex) {
	    			System.out.println("Exception reading IS: "+ex.getMessage());
	    		}
	    	}
	           
	        @Override
	        public void onAllDataRead() {
	        	try {
	        		
	        		PrintWriter out = acontext.getResponse().getWriter();
	        		
	        		out.println("...Finished downloading...");
	        		out.println("Thread: "+ Thread.currentThread().getName());
	        		out.println("Data: "+ sbuilder.toString());
	        		
	        		
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
}
