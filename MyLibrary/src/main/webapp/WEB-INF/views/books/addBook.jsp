<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Registration Form</title>

<style>
.error {
	color: #ff0000;
}
</style>

</head>

<body>

	<h2>Add Book</h2>

	<form:form method="POST" modelAttribute="book">
		<form:input type="hidden" path="id" id="id" />
		<table>

			<tr>
				<td><label for="name">Author: </label></td>
				<td><form:form modelAttribute="author">
						<select>
							<option id="author" value="" disabled selected>Please
								select an author...</option>
							<c:forEach items="${authors}" var="author">
								<option>${author.name}</option>
							</c:forEach>
						</select>
					</form:form></td>
			</tr>
			<tr>
				<td><label for="name">Name: </label></td>
				<td><form:input path="name" id="name" /></td>
				<td><form:errors path="name" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label for="status">Status: </label></td>
				<td><form:input path="status" id="status" /></td>
				<td><form:errors path="status" cssClass="error" /></td>
			</tr>

			<tr>
				<td colspan="3"><c:choose>
						<c:when test="${edit}">
							<input type="submit" value="Update" />
						</c:when>
						<c:otherwise>
							<input type="submit" value="Add" />
						</c:otherwise>
					</c:choose></td>
			</tr>
		</table>
	</form:form>
	<br />
	<br /> Go back to
	<a href="<c:url value='/' />">Home</a>
</body>
</html>