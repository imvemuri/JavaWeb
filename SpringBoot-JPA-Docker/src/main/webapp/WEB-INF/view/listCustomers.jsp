<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
i.glyphicon glyphicon-search {
    font-size: 30px;
}
</style>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>All Customers</title>
		<link href="/webjars/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
		<h2 align = "center"> CRM - Customer Relation Manager</h2><br>
			<div class = "container">
			<!--  add a search box -->
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
				
				<table class ="table table-striped">
			  		<thead class="thead-inverse">		
			  			<tr>
				    		<th>First Name</th>
				    		<th>Last Name</th>
				    		<th>Email</th>
				    		<th>Action</th>
				    	</tr>
				    </thead>
				    
				     <c:forEach items = "${customers}" var = "customer">
				           <tr>
					           <td>${customer.firstName}</td>
					           <td>${customer.lastName}</td>
					           <td>${customer.email}</td>
					           <td><a href ="/update?ID=${customer.id}">Update </a>
					            | <a href ="/delete?ID=${customer.id}"> Delete</a></td>
				        	</tr>
				     </c:forEach>
				</table> <br>
				<a class ="btn btn-success" href="/add" >Add Customer</a>
			</div>
		<script src="/webjars/jquery/2.1.4/jquery.min.js"></script>
		<script src="/webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	</body>
</html>