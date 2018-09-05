<jsp:directive.page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />
<!DOCTYPE html>
<html>
	<head>
		<title>Error Page</title>
	</head>
	
	<body>
		
		<h2>This is BIG FAT ERROR Page</h2>
		The error was: ${ requestScope.exception }
		<br/>
		pageContext.exception.message: ${ requestScope.exception.message }
		<br/>
		pageContext.exception.stackTrace: ${ requestScope.exception.stackTrace }
	</body>
	
	<script>
		//Custom page with exception object passed as attribute
	</script>
</html>