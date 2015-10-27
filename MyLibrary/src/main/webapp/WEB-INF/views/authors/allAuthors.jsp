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
<body class="jumbotron">
	<nav class="navbar navbar-inverse navbar-fixed-top" id="my-navbar">
		<div class="container" >
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>			
				</button>	
				<a href="<c:url value='/'/>"  class="navbar-brand">Home</a>	
			</div>
			<div class="collapse navbar-collapse" id="navbar-collapse">
				<ul class="nav navbar-nav">
					<li><a href="#gallery">Gallery</a></li>			
				</ul>
			</div>			
		</div>		
	</nav>
	<div>
		<h2 class="text-info">List of Authors</h2>
		<div class="btn-group">
			<c:choose>
				<c:when test="${emptyListOfAuthors}">
					<h3 class="text-center">The list of authors is empty!!!</h3>
				</c:when>
				<c:otherwise>			
					<table class="table">
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
				</c:otherwise>		
			</c:choose>
		</div>
		<br />
		<a href="<c:url value='/authors/new' />" class="btn btn-sm btn-info">Add New Author</a>		
	</div>	
	
	<script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>		
	
</body>
</html>