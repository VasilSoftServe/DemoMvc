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
<body class="jumbotron">
	<nav class="navbar navbar-inverse navbar-fixed-top" id="my-navbar">
		<div class="container" >
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>				
				</button>	
				<a href="<c:url value='/authors/'/>"  class="navbar-brand">Authors</a>	
			</div>
			<div class="collapse navbar-collapse" id="navbar-collapse">
				<ul class="nav navbar-nav">
					<li><a href="#feedback">Feedback</a></li>
					<li><a href="#gallery">Gallery</a></li>
					<li><a href="#contact">Contact</a></li>				
				</ul>
			</div>			
		</div>		
	</nav>
	<br><br><br><br><br><br><br><br>
	<div class="container text-center">		
				<h1>${library}</h1>				
	</div>
	<br><br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br><br>
	<footer>
	<div class="container text-center">
	<ul class="list-inline">
		<li><a href="http://twitter.com">Twitter</a></li>
		<li><a href="http://facebook.com">Facebook</a></li>
		<li><a href="http://youtube.com">Youtube</a></li>
	</ul>
	<h6 class="fixed-bottom">&copy; Copyright @2015</h6>
	</div>
	</footer>
	
	<script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>		
</body>
</html>
