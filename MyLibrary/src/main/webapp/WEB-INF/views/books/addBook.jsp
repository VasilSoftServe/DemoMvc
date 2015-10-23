<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee Registration Form</title>

<style type="text/css">
    <%@include file="../libs/css/bootstrap-theme.min.css" %>
    <%@include file="../libs/css/bootstrap.min.css" %>
</style>

</head>

<body>

	<div class="jumbotron">
		<h2>Add Book</h2>	
		<form:form modelAttribute="book">
			<form:input type="hidden" path="id" id="id" />
			<table>
				<tr>
					<td><label for="title">Title: </label></td>
					<td><form:input path="title" id="title" /></td>
					<td><form:errors path="title" cssClass="error" /></td>
				</tr>
				<tr>
					<td><label for="status">Status: </label></td>
					<td><form:input path="status" id="status" /></td>
					<td><form:errors path="status" cssClass="error" /></td>
				</tr>
	
				<tr>
					<td colspan="3"><c:choose>
							<c:when test="${edit}">
								<form:form action="/academy/authors/${author.id}/books/${book.id}" method="PUT">
									<input type="submit" value="Edit" class="btn btn-sm btn-warning"/>
								</form:form>
							</c:when>
							<c:otherwise>
								<form:form action="/academy/authors/${author.id}/books/new" method="POST">
									<input type="submit" value="Add" class="btn btn-sm btn-warning" />
								</form:form>
							</c:otherwise>
						</c:choose></td>
				</tr>
			</table>
		</form:form>
		<br />
		<a href="<c:url value='/' />" class="btn btn-sm btn-warning">Back to Home</a>
	</div>
</body>
</html>