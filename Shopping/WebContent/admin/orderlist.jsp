<%@ page language="java" contentType="text/html; charset=GB18030" import="com.summer.shopping.*"
    pageEncoding="GB18030"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.ArrayList" %>
<%@ include file="sessioncheck.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%!
int pageNo = 1;
int pageCount = 1;
static int PAGE_SIZE = 3;
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>订单列表</title>
</head>
<body>
<table border="1" align="center" >
<tr>
	<td>ID</td>
	<td>User</td>
	<td>Addr</td>
	<td>Order Date</td>
	<td>Status</td>
</tr>
<%
try {
	pageNo = Integer.parseInt(request.getParameter("pageno"));
	if(pageNo<1) {
		pageNo = 1;
	}
} catch(NumberFormatException e) {
	pageNo = 1;
}
List<Order> orders = new ArrayList<Order>();

if(pageCount > 0) {
	if(pageNo > pageCount) {
		pageNo = pageCount;
	}
}
pageCount = OrderMgr.getInstance().getOrders(orders,pageNo,PAGE_SIZE);

Order o = new Order();
for(Iterator<Order> it=orders.iterator(); it.hasNext(); ) {
	o = it.next();
	%>
	<tr>
		<td><%= o.getId() %></td>
		<td><%= o.getUser().getUsername() %></td>
		<td><%= o.getAddr() %></td>
		<td><%= o.getOdate() %></td>
		<td><%= o.getStatus() %></td>
		<td><a href="showorderdetail.jsp?id=<%= o.getId() %>">详细订单</a></td>
		<td><a href="ordermodify.jsp?id=<%= o.getId() %>">修改订单</a></td>
	</tr>
<%
}
%>
</table>
<center>
&nbsp;
第<%=pageNo %>页
&nbsp;
共<%=pageCount %>页
&nbsp;
<a href="orderlist.jsp?pageno=<%=pageNo-1 %>">上一页</a>
&nbsp;
<a href="orderlist.jsp?pageno=<%=pageNo+1 %>">下一页</a>
&nbsp;
<a href="orderlist.jsp?pageno=<%=pageCount %>">最后一页</a>
</center>
</body>
</html>