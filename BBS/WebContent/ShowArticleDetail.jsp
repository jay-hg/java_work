<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	String id = request.getParameter("id");
	Class.forName("com.mysql.jdbc.Driver");
	String url = "jdbc:mysql://localhost/bbs?user=root&password=tiger";
	Connection conn = DriverManager.getConnection(url);
	Statement stmt = conn.createStatement();
	ResultSet rs = stmt.executeQuery("select * from article where id ="+id);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<% if(rs.next()) { %>
	<tr>
	<td>ID:</td>
	<td><%= rs.getInt("id") %></td>
	</tr>
	
	<tr>
	<td>Title:</td>
	<td><%= rs.getString("title") %></td>
	</tr>
	
	<tr>
	<td>Content:</td>
	<% String cont = rs.getString("cont").replaceAll("\\n","<br/>"); %>
	<td><%= cont %></td>
	</tr>
<% } %>
</table>
<a href="Reply.jsp?id=<%= id=id%>&rootid=<%= rs.getInt("rootid") %>">回复</a>
</body>
<%
rs.close();
stmt.close();
conn.close();
%>
</html>