<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<div>
	<h1>Persons list</h1>
	<table border="1">
		<th>Id</th>
		<th>Firstname</th>
		<th>Lastname</th>
		
		<c:forEach var="person" items="${listPerson}" varStatus="status">
		<tr>
			<td>${status.index + 1}</td>
			<td>${person.firstname}</td>
			<td>${person.lastname}</td>			
		</tr>			
		</c:forEach>
	</table>
</div>
</body>
</html>
