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
	<h2>List of Books</h2>
	<table>
		<tr>
			<th>Name</th>
			<th>Status</th>
		</tr>
		<c:forEach items="${books}" var="book">
			<tr>
				<td>${book.name}</td>
				<td>${book.status}</td>
				<td><a href="<c:url value='/books/edit-${book.id}-book' />">Edit</a></td>
				<td><a href="<c:url value='/books/delete-${book.id}-book' />">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<a href="<c:url value='/books/new' />">Add New Book</a>
	<br/>
	<a href="<c:url value='/authors/allAuthors' />">Back</a>
	<br /> Go back to
	<a href="<c:url value='/' />">Home</a>
</body>
</html>