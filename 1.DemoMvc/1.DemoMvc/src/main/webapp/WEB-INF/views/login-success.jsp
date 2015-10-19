
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Logged successfully</title>
</head>
<body>
	<div>
		<h2 style="color: green;">You are successfully logged in!</h2>
		<table >
			<tr>
				<td>User Name:</td>
				<td>${loginForm.username}</td>
			</tr>
			<tr>
				<td>Password:</td>
				<td>${loginForm.password}</td>
			</tr>
			<tr>
				<td>Email:</td>
				<td>${loginForm.email}</td>
			</tr>
		</table>
	</div>
</body>
</html>