<%@ page contentType="text/html; charset=GB18030" pageEncoding="GB18030" %>
<%
String login = (String)session.getAttribute("login");
if(login == null || !login.equals("yes")) {
	response.sendRedirect("login.jsp");
}
%>