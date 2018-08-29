package lifecycle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/lifecycleServlet", name = "lifecycleServlet")
public class ServletLifeCycleExample extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ServletContext ctx;
	private int count;
	private String contextParam;
	private String initParam;
	
	
    @Override
    public void init(final ServletConfig config) throws ServletException {
        super.init(config);
        ctx = getServletContext();
        
        contextParam = getServletContext().getInitParameter("email");
        initParam = config.getInitParameter("initParam");
        
        count = 0;
        ctx.log("init() called");
    }
 
    @Override
    protected void service(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        ctx.log("service() called");
        
        PrintWriter out = response.getWriter();
        out.println("Incrementing the count to " + ++count);
        out.println("");
        out.println("Context Param, mail - > " + contextParam);
        out.println("Init Param, initParam -> " + initParam);
        out.println("");
        out.println("Servlet's lifecycle:");
        out.println("-Every request is processed in its own thread");
        out.println("-The container maps this request to a particular servlet.");
        out.println("-The servlet is dynamically retrieved and loaded into the address space of the container.");
        out.println("-The default constructor is invoked (dont put anything in the constructor).");
        out.println("-The container invokes the init() method of the servlet and passes ServletConfig as a argument.");
        out.println(" -Use init() to initialize serlvet.");
        out.println(" -This method is invoked only when the servlet is first loaded into memory.");
        out.println("-ServletConfig is one per servlet, it grants access to the init params, context params from web.xml and ServletContext object");
        out.println("-The container invokes the service() method of the servlet and passes created Request and Response objects.");
        out.println(" -It retrieves the HTTP method name (GET, POST) and ivokes the appropriate servlet method (doGet, doPost).");
        out.println("-The servlet remains in the container's address space and is available to process any other HTTP requests received from clients.");
        out.println(" -The service() method is called for each HTTP request.");
        out.println("-The container may, at some point, decide to unload the servlet from its memory.");
        out.println(" -The container calls the servlet's destroy() method to relinquish any resources such as file handles that are allocated for the servlet.");
        out.println("- The memory allocated for the servlet and its objects can then be garbage collected.");
        out.println("");
    }
 
    @Override
    public void destroy() {
        getServletContext().log("destroy() called");
    }
}