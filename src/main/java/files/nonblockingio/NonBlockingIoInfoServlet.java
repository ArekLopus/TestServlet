package files.nonblockingio;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.ReadListener;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//-If a client is submitting a large HTTP POST request over a slow network connection, the server can read the request faster
// than the client can provide it. Using traditional I/O, the container thread associated with this request would be
// sometimes sitting idle waiting for the rest of the request.
//-JEE provides nonblocking I/O support for servlets and filters when processing requests in asynchronous mode.
// The following steps summarize how to use nonblocking I/O to process requests and write responses inside service methods.
// • Put the request in asynchronous mode as described in Asynchronous Processing.
// • Obtain an input stream and/or an output stream from the request and response objects in the service method.
// • Assign a read listener to the input stream and/or a write listener to the output stream.
// • Process the request and the response inside the listener's callback methods.
@WebServlet(urlPatterns = "/nonblockingioInfoServlet", asyncSupported = true)
public class NonBlockingIoInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final AsyncContext acontext = request.startAsync();
	    final ServletInputStream input = request.getInputStream();
	      
	    input.setReadListener(new ReadListener() {
	    	byte buffer[] = new byte[4*1024];
	    	StringBuilder sbuilder = new StringBuilder();
	         
	    	@Override
	    	public void onDataAvailable() {
	    		try {
	    			do {
	    				int length = input.read(buffer);
	                    sbuilder.append(new String(buffer, 0, length));
	    			} while(input.isReady());
	    			
	    			
	    			
	    		} catch (IOException ex) {
	    			System.out.println("Exception reading IS: "+ex.getMessage());
	    		}
	    	}
	           
	        @Override
	        public void onAllDataRead() {
	        	try {
	        		acontext.getResponse().getWriter().write("...the response...");
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
