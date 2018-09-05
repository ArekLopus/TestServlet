<jsp:directive.page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true" />
<!DOCTYPE html>
<html>
	<head>
		<title>Error Page</title>
	</head>
	
	<body>
		
		<h2>This is BIG FAT ERROR Page</h2>
		The error was: ${ pageContext.exception }
		<br/>
		pageContext.exception.message: ${ pageContext.exception.message }
		<br/>
		pageContext.exception.stackTrace: ${ pageContext.exception.stackTrace }
	</body>
	
	<script>
		//isErrorPage="true" gives us access to the exception object
		
		//-Use <error-page> in DD to declare different pages for different exceptions ( <exception-type> or <erroe-code> )
		//	<error-page>
		//		<exception-type>java.lang.ArithmeticException</exception-type>
		//		<location>/errorPage.jsp</location>
		//	</error-page>
		//	<error-page>
		//		<erroe-code>404</erroe-code>
		//		<location>/pageNotFound.html</location>
		//	</error-page>
		
		//-If we use errorPage attributein JSP page, it takes precedence
		//-The error page gets additional object - excetion -> $ { pageContext.exception }
		//-In EL expressions we can use message and stackTrace props
		//	$ { pageContext.exception.message }
		//	$ { pageContext.exception.stackTrace }
	</script>
</html>