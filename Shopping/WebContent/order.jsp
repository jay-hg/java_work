<%@ page language="java" contentType="text/html; charset=GB18030" import="com.summer.shopping.*"
    pageEncoding="GB18030"%>
<%@ include file="islogin.jsp" %>    
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>��Ӷ���</title>
</head>
<body>
<%
request.setCharacterEncoding("gbk");

Order order = new Order();
String addr = request.getParameter("addr");
Cart cart = (Cart)session.getAttribute("cart");
order.setUser(usr);
order.setAddr(addr);
order.setCart(cart);
order.setOdate(new Date(System.currentTimeMillis()));
order.setStatus(0);

OrderMgr.getInstance().saveOrder(order);
session.removeAttribute("cart");
%>
<center>��Ϊ���ύ������ף��������죡</center>
</body>
</html>