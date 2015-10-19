<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Form</title>
</head>
<body>
<div>
<h2>Login Form</h2>
	<form:form action="login" method="post" commandName="loginForm">
		<table border="1">
			<tr>
				<td>User Name:</td>
				<td><form:input path="username" /><td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><form:input type="password" path="password" /><td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><form:input type="email" path="email" /><td>
			</tr>
			<tr>
				<td colspan="3">
					<input type="submit" value="login" />
				</td>
			</tr>
		</table>	
	</form:form>
	</div>
</body>
</html>