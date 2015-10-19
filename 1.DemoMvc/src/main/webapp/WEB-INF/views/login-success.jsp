<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.ss.java.Login"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>You are successfully logged in!</p>
	<div>
		<h1>Login Form</h1>
		<div>
			User Name:
			<p>${username}</p>
		</div>
		<div>
			Password:
			<p>${password}</p>
		</div>
		<div>
			E-mail:
			<p>${email}</p>
		</div>
	</div>
</body>
</html>