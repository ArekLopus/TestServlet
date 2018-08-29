package params.init;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/initParamsServlet", name="InitParamsServlet",
	initParams = {@WebInitParam(name="abc", value="abc"), @WebInitParam(name="def", value="def")}
)
public class InitParamsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<h3>Init Params Servlet</h3>");
		out.println("<br/>Init params can be defined in @WebServlet using @WebInitParam");
		out.println("<br/>Or in web.xml using &lt;init-param&gt;");
		out.println("<br/>You can also override @WebInitParam in web.xml<br/>");
		
		String parm1 = getServletConfig().getInitParameter("abc");
		String parm2 = getServletConfig().getInitParameter("def");
		
		out.println("<br/>param abc -> "+parm1);
		out.println("<br/>param def -> "+parm2);
		
		String ctxParam = getServletContext().getInitParameter("email");
		out.println("<br/><br/>All servlets have access to the ServletContext param, email -> " + ctxParam);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
