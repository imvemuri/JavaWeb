<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customers</title>
<link href="/webjars/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<h2 align = "center"> CRM - Customer Relation Manager</h2><br>
	<div class = "container">
		<form:form action = "SaveCustomer" modelAttribute="customer" method = "POST">
		<form:hidden path = "id"/>
				<fieldset class ="form-group">
					<label> First Name </label>
				    <form:input path="firstName" class ="form-control"/>
					<label> Last Name </label>
					<form:input path="lastName" class ="form-control"/>
					<label> Email </label>
					<form:input path="email" class ="form-control"/>
				</fieldset>
			<br><input type = "submit" value = "Save" class="btn btn-info"/>
		</form:form>
	</div>
	
	<br><a class ="btn" href="lists">Back to lists</a>
<script src="/webjars/jquery/2.1.4/jquery.min.js"></script>
<script src="/webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>