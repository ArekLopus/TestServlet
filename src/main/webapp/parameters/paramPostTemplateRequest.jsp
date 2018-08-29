<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Action for Form</title>
	</head>
	
	<body>
		
		<jsp:useBean id="user" class="helper.User" scope="request">
			<jsp:setProperty name = "user" property = "*" />
		</jsp:useBean>
		
		<br/>User: ${user}
		<br/>Name: ${user.name}
		<br/>Surname: ${user.surname}
		<br/>City: ${user.city}
		<br/>Phone: ${user.phone}
		
		
	</body>
</html>