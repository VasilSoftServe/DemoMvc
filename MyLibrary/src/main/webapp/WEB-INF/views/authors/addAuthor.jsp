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
<body class="jumbotron" >
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
					<li><a href="<c:url value='/authors/' />">Authors</a></li>			
				</ul>
			</div>			
		</div>		
	</nav>
	<div class="col-sm-4">
		<h2>Create Author</h2>
		<div class="btn-group">
			<form:form modelAttribute="author" >
				<form:input type="hidden" path="id" id="id" />
				<div >
					<table class="table" >				
						<tr>
							<td><label for="name">Name: </label></td>
							<td><form:input path="name" id="name" /></td>
							<td><form:errors path="name" cssClass="error" /></td>
						</tr>
						<tr>
							<td><label for="country">Country: </label></td>
							<td><form:input path="country" id="country" /></td>
							<td><form:errors path="country" cssClass="error" /></td>						
						</tr>				
						<tr>
							<td colspan="2">
								<c:choose>
									<c:when test="${edit}">    							
										<form:form action="/academy/authors/${author.id}" method="PUT" >
												<input type="submit" value="Update" class="btn btn-sm btn-info"/>										
										</form:form>								
									</c:when>
									<c:otherwise>
										<form:form action="/academy/authors/new" method="GET">
											<input type="submit" value="Add" class="btn btn-sm btn-info"/>
										</form:form>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
					</table>
				</div>
			</form:form>
		</div>
	<div>
		<a href="<c:url value='/authors/' />" class="btn btn-sm btn-info">Back</a>
	</div>
	</div>
	<script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>		
	
</body>
</html>