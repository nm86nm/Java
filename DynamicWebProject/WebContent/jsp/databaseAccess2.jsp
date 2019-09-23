<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Database Access 2</title>
</head>
<body>
	<!-- 
		driver = "org.postgresql.Driver"; 
		url = "jdbc:derby://localhost:1527/DerbyDatabase;create=true";
		url = "jdbc:hsqldb:hsql://localhost/";
		url = "jdbc:oracle:thin:@localhost:1521:OracleDataba"; 
		url = "jdbc:postgresql://localhost:5432/postgres";
 	-->
	<%
		Integer hitsCount = (Integer) application.getAttribute("hitCounter");
		if (hitsCount == null || hitsCount == 0) {
			/* First visit */
			out.println("Welcome to my website!");
			hitsCount = 1;
		} else {
			/* return visit */
			out.println("Welcome back to my website!");
			hitsCount += 1;
		}
		application.setAttribute("hitCounter", hitsCount);
	%>
	visit counter: (<%=hitsCount%>)
	<br />
	<table border="1" cellpadding="3" cellspacing="3">
		<tr bgcolor="#a12bcc" font color="yellow">
			<td>Id</td>
			<td>First name</td>
			<td>Last name</td>
		</tr>
		<%
			String url = "jdbc:postgresql://localhost:5432/postgres";
			String user = "Matthew";
			String password = "ateMthw";			

			System.out.println("databaseAccess3(" + hitsCount + ") url = " + url);

			try {
				Connection conn = DriverManager.getConnection(url, user, password);
				Statement st = conn.createStatement();
				//ResultSet rs = st.executeQuery("SELECT table_name FROM user_tables ORDER BY table_name ASC");
				ResultSet rs = st.executeQuery("SELECT * FROM person ORDER BY id ASC");

				while (rs.next()) {
					Integer id = rs.getInt("id");
					String firstname = rs.getString("firstname");
					String lastname = rs.getString("lastname");
					System.out.println(id + ". " + firstname + " " + lastname);
		%>
		<tr bgcolor="#ff3333">
			<td><%=id%></td>
			<td><%=firstname%></td>
			<td><%=lastname%></td>
		</tr>
		<%
			}
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		%>
	</table>
</body>
</html>