<%@ include file = "common/header.jspf" %>
<%@ include file = "common/navigationbar.jspf" %> 

<html>
<head>
<title>Yahoo!!</title>
</head>
<body>
	<div class = "container">
	<h3> Welcome ${user}. Check and manage your targets. </h3>
	<table class ="table">
	<tr>
    	<th>ID</th>
    	<th>User</th> 
    	<th>Date</th>
    	<th>Desc</th>
    	<th>Update</th>
    	<th>Delete</th>
    </tr>
    
    <c:forEach items = "${usertargets}" var = "target">
        <tr>
           <td>${target.id}</td>
           <td>${target.user}</td>
           <td><fmt:formatDate pattern = "yyyy-MM-dd" value = "${target.date}" /></td>
           <td>${target.desc}</td>
           <td><a class ="btn btn-success" href ="/updateTarget?id=${target.id}">Update</a></td>
           <td><a class ="btn btn-danger" href ="/deleteTarget?id=${target.id}">Delete</a></td>
        </tr>
     </c:forEach>
     
</table>

<br><br>
<a class = "btn btn-success" href = "/addTarget">New Targets</a>
</div>
	<%@ include file = "common/footer.jspf" %> 
</body>
</html>
