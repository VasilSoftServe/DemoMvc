<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>

<style type="text/css">
    <%@include file="libs/css/bootstrap-theme.min.css" %>
    <%@include file="libs/css/bootstrap.min.css" %>
</style>

<title>Home Page</title>
</head>
<body>
	<div class="jumbotron">
		<div class="container" >
			<div class="btn-group">		
				<h1>${library}</h1>
				<a href="<c:url value='/authors/'/>"  class="btn btn-ln btn-info">List of All Authors</a>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="libs/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="libs/js/jquery-2.1.4.min.js"></script>
</body>
</html>
