<%@ page language="java" contentType="text/html; charset=GB18030" 
    pageEncoding="GB18030"%>
<%@ page import="com.summer.shopping.User" %>
<%
	response.setContentType("text/xml");
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
	
	request.setCharacterEncoding("gb2312");
	String username = request.getParameter("username");
	if(User.usernameValidate(username)) {
		response.getWriter().write("<msg>validate</msg>");
	} else {
		response.getWriter().write("<msg>invalidate</msg>");
	}
%>