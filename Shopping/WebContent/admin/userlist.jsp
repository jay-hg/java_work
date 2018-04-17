<%@ page language="java" contentType="text/html; charset=GB18030" import="com.summer.shopping.*"
    pageEncoding="GB18030"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ include file="sessioncheck.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
<table border="1" align="center" >
<tr>
	<td>ID</td>
	<td>User Name</td>
	<td>Phone</td>
	<td>Address</td>
	<td>Register Date</td>
</tr>
<%
List<User> users = User.getUsers();
User u = new User();
for(Iterator<User> it=users.iterator(); it.hasNext(); ) {
	u = it.next();
	%>
	<tr>
		<td><%= u.getId() %></td>
		<td><%= u.getUsername() %></td>
		<td><%= u.getPhone() %></td>
		<td><%= u.getAddr() %></td>
		<td><%= u.getRdate() %></td>
		<td><a href="delete.jsp?id=<%= u.getId() %>" target="detail">删除</a></td>
	</tr>
<%
}
%>
</table>
</body>
</html>