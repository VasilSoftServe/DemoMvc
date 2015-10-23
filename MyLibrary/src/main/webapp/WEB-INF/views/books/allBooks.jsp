<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>University Enrollments</title>

<style type="text/css">
    <%@include file="../libs/css/bootstrap-theme.min.css" %>
    <%@include file="../libs/css/bootstrap.min.css" %>
</style>

</head>


<body>
	<div class="jumbotron">
		<h2>List of Books</h2>
		
		<table class="table">
			<tr>
				<th><h3  class ="warning">Author: ${author.name}</h3></th>
			</tr>
			<tr>
				<th>Title</th>
				<th>Status</th>
			</tr>
			<c:forEach items="${books}" var="book">
				<tr>
					<td>${book.title}</td>
					<td>${book.status}</td>
					<td><form:form
							action="/academy/authors/${author.id}/books/${book.id}"
							method="GET">
							<input type="submit" value="Update" class="btn btn-sm btn-warning"/>
						</form:form>
					</td>
					<td><form:form
							action="/academy/authors/${author.id}/books/${book.id}"
							method="DELETE">
							<input type="submit" value="Delete" class="btn btn-sm btn-warning"/>
						</form:form>
					</td>
				</tr>
			</c:forEach>
		</table>
		<br />		
		<a href="<c:url value='/authors/${author.id}/books/new' />" class="btn btn-sm btn-warning">Add New
			Book</a>
		<br />
		<br/>
		<div>
			<a href="<c:url value='/authors/' />" class="btn btn-sm btn-warning">Back</a>
			<a href="<c:url value='/' />" class="btn btn-sm btn-warning">Back to Home</a>
		</div>			
	</div>
</body>
</html>