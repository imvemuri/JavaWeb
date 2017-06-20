<%@ include file = "common/header.jspf" %>
<%@ include file = "common/navigationbar.jspf" %> 
 
<body>
<div class ="container">
<h3> Add the target </h3>
<form:form commandName = "target" method = "POST">
	<fieldset class ="form-group">
		<form:hidden path = "id"/>
		<form:hidden path = "user"/>
		<label>Description</label>
		<form:input path = "desc" type = "text"  class ="form-control" required ="required"/>
		<form:errors path= "desc" cssClass="error" />
	</fieldset>
	
	<fieldset class ="form-group">
		<label>Date</label>
		<form:input path = "date" type = "text"  class ="form-control" required ="required"/>
		<form:errors path= "date" cssClass="error" />
	</fieldset>
	
	<input type = "submit" class = "btn btn-success" value = "Submit">
</form:form>
</div>
</body>
<%@ include file = "common/footer.jspf" %> 
</html>