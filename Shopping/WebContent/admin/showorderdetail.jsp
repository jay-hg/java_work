<%@ page language="java" contentType="text/html; charset=GB18030" import="com.summer.shopping.*"
    pageEncoding="GB18030"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.ArrayList" %>
<%@ include file="sessioncheck.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>订单详情</title>
</head>
<body>
<form action="ordermodify.jsp" action="post">
<input type="hidden" name="action" value="modify">
<table border="1" align="center" >
<tr>
	<td>ID</td>
	<td>User</td>
	<td>Addr</td>
	<td>Order Date</td>
	<td>Status</td>
</tr>
<%
request.setCharacterEncoding("gb2312");
int id;
try {
	id = Integer.parseInt(request.getParameter("id"));
} catch(NumberFormatException e) {
	out.println("系统出错");
	return;
}
Order o = OrderMgr.getInstance().loadById(id);
	%>
	<tr>
		<td name="id"><%= o.getId() %></td>
		<td><%= o.getUser().getUsername() %></td>
		<td><%= o.getAddr() %></td>
		<td><%= o.getOdate() %></td>
		<td>
		<select name="status">
			<option value="0">未处理</option>
			<option value="1">已处理</option>
			<option value="2">废单</option>
		</select>
		</td>
	</tr>
</table>
<center>
	<input type="submit" value="修改">
</center>
</form>
<center>
明细：<br>
<table border="1">
	<tr>
		<td>商品名称</td>
		<td>单价</td>
		<td>数量</td>
	</tr>
	
	<%
	CartItem item = null;
	for(Iterator<CartItem> items=o.getCart().getCartItems().iterator(); items.hasNext(); ) {
		item = items.next();
		
		%>
	
	<tr>
		<td><%= item.getProduct().getName() %></td>
		<td><%= item.getPrice() %></td>
		<td><%= item.getCount() %></td>
	</tr>
	
		<%
	}
	%>
</table>
</center>

<script type="text/javascript">
for(var option in document.getElementById("status").options) {
	if(option.value == <%= o.getStatus() %>) {
		document.getElementById("status").selectIndex = option.index;
	}
}
</script>
</body>
</html>