<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home Page</title>
</head>
<body>
	<h1>${library}</h1>	

	<a href="<c:url value='/authors/allAuthors' />">List of All Authors</a>

</body>
</html>
