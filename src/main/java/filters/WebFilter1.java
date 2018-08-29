package filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

//-The filtering API is defined by the Filter, FilterChain, and FilterConfig interfaces in the javax.servlet package.
//-You define a filter by impl the Filter interface.
//-In addition to doFilter(), you must implement the init() and destroy().
// The init() called by the container when the filter is instantiated.
//-If you wish to pass init params to the filter, you retrieve them from the FilterConfig object passed to init.
//-The filter invokes the next entity by calling the doFilter() on the chain object, passing in the request and response
// it was called with or the wrapped versions it may have created.
//-Alternatively, the filter can choose to block the request by not making the call to invoke the next entity.
// In the latter case, the filter is responsible for filling out the response.
//-To override request methods, you wrap the request in an object that extends either ServletRequestWrapper or HttpServletRequestWrapper.
// To override response methods, you wrap the response in an object that extends either ServletResponseWrapper or HttpServletResponseWrapper.
//-The order of the filters in the chain is the same as the order in which filter mappings appear in the web app DD.
//-You can map a filter to one or more web resources, and you can map more than one filter to a web resource.

//-All 3 methods must be implemented for Tomee 7.02 ( init() / destroy() are default )!
@WebFilter(filterName = "MyFilter",	urlPatterns = {"/filter/*"},
	initParams = {
		@WebInitParam(name = "filterParam", value = "filterValue")
	}
)
public class WebFilter1 implements Filter {
	
	private FilterConfig filterConfig;
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		String initParameter = filterConfig.getInitParameter("filterParam");
		System.out.println("Filter1 works!, filter InitParam, filterParam -> "+initParameter);
		
		PrintWriter out = response.getWriter();
		
		out.println("<br/>Filter1 works!, filter InitParam, filterParam -> "+initParameter);
				
		chain.doFilter(request, response);
		
	}
	
	
	@Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }


    @Override
    public void destroy() {
    }
}
