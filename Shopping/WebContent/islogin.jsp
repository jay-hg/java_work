<%@ page contentType="text/html; charset=GB18030" 
pageEncoding="GB18030" import="com.summer.shopping.*" %>
<%
User usr = (User)session.getAttribute("user");
if(usr == null) {
	response.sendRedirect("login.jsp");
	return;
}
%>