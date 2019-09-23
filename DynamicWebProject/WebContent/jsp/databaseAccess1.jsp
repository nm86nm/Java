<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<html>
<head>
<title>Database Access 1</title>
</head>
<body>
	<!-- 
		driver = "org.apache.derby.jdbc.ClientDriver";
		driver = "org.hsqldb.jdbcDriver"
		driver = "oracle.jdbc.OracleDriver";
		driver = "org.postgresql.Driver"; 
				
		url = "jdbc:derby://localhost:1527/DerbyDatabase;create=true";
		url = "jdbc:hsqldb:hsql://localhost/";
		url = "jdbc:oracle:thin:@localhost:1521:OracleDataba"; 
		url = "jdbc:postgresql://localhost:5432/postgres";
 	-->
	<sql:setDataSource var="dataSource" driver = "org.postgresql.Driver"
		url="jdbc:postgresql://localhost:5432/postgres" user="Matthew"
		password="ateMthw" />

	<sql:query var="query" dataSource="${dataSource}">
		SELECT * FROM person;
	</sql:query>

	<table border="1">
		<tr bgcolor="#999999">
			<td>Id</td>
			<td>First Name</td>
			<td>Last Name</td>
		</tr>
		<c:forEach var="row" items="${query.rows}">
			<tr bgcolor="#CCCCCC">
				<td><c:out value="${row.id}"/></td>
				<td><c:out value="${row.firstname}"/></td>
				<td><c:out value="${row.lastname}"/></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>