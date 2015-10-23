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
		<h2>List of Authors</h2>
		<div class="btn-group">
			<table class="table ">
				<tr>
					<th>Name</th>
					<th>Country</th>
				</tr>
				<c:forEach items="${authors}" var="author">
					<tr>
						<td>${author.name}</td>
						<td>${author.country}</td>
						<td><form:form action="/academy/authors/${author.id}"
								method="GET">
								<input type="submit" value="Edit" class="btn btn-sm btn-info"/>
							</form:form></td>
						<td><form:form action="/academy/authors/${author.id}"
								method="DELETE">
								<input type="submit" value="Delete" class="btn btn-sm btn-info"/>
							</form:form></td>
						<td>
						<td><form:form action="${author.id}/books"
								method="GET">
								<input type="submit" value="List of books" class="btn btn-sm btn-warning" />
							</form:form></td>
						</tr>
				</c:forEach>
			</table>
		</div>
		<br />
		<a href="<c:url value='/' />" class="btn btn-sm btn-info">Back to Home</a>	
		<a href="<c:url value='/authors/new' />" class="btn btn-sm btn-info">Add New Author</a>		
	</div>
	
	<script type="text/javascript" src="../../libs/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../../libs/js/jquery-2.1.4.min.js"></script>
</body>
</html>