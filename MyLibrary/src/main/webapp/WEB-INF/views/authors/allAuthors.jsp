<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>University Enrollments</title>

<style>
tr:first-child {
	font-weight: bold;
	background-color: #C6C9C4;
}
</style>

</head>


<body>
	<h2>List of Authors</h2>
	<table>
		<tr>
			<th>Name</th>
			<th>Country</th>
		</tr>
		<c:forEach items="${authors}" var="author">
			<tr>
				<td>${author.name}</td>
				<td>${author.country}</td>
				<td><a href="<c:url value='/authors/edit-${author.id}-author' />">Edit</a></td>
				<td><a href="<c:url value='/authors/delete-${author.id}-author' />">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<a href="<c:url value='/authors/new' />">Add New Author</a>
	<br/>
	<a href="<c:url value='/books/' />">List of All Books</a>
	<br /> Go back to
	<a href="<c:url value='/' />">Home</a>	
</body>
</html>