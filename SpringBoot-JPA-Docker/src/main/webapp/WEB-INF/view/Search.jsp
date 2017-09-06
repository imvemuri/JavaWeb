<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Search Customer</title>
</head>
<link href="/webjars/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
<body>
	<h3 align="center"> Search for Customer</h3>
	<br> <br>
		<div class = "container">
			<form:form method = "GET" action="/search">
			  <div class="input-group">
				    <input type="text" name="SearchName" class="form-control">
				    <div class="input-group-btn">
				      <button class="btn btn-primary" type="submit">
				        <span class="glyphicon glyphicon-search">
				        </span> Search 
				      </button>
				    </div>
			    </div>
			</form:form>
			<br>
			<a href = "/">Home</a>
		</div>
</body>
<script src="/webjars/jquery/2.1.4/jquery.min.js"></script>
<script src="/webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</html>