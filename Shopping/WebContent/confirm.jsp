<%@ page language="java" contentType="text/html; charset=GB18030" import="com.summer.shopping.*"
    pageEncoding="GB18030"%>
<%@ page import="java.util.*" %>
<%@ include file="islogin.jsp" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>���ﳵ</title>
		
</head>
<body>
<form name="form" action="order.jsp" method="post">
			<center>
			���ѹ���
			</center>
			<table width="750" align="center" border="2">
			<tr>
				<td>��ƷID:</td>
				<td>��Ʒ��</td>
				<td>����</td>
				<td>����</td>
				<td>�ܼ�</td>
			</tr>
		
<%
request.setCharacterEncoding("gbk");
Cart cart = (Cart)session.getAttribute("cart");
List<CartItem> items = cart.getCartItems();
CartItem ci = null;
Product p = null;
for(Iterator<CartItem> it=items.iterator();it.hasNext() ; ) {
	ci = it.next();
	p = ci.getProduct();
	%>
		<tr>
			<td>
				<%= p.getId() %>
			</td>
	
			<td>
				<%= p.getName() %>
			</td>
			
			<td>
				<%= ci.getPrice() %>
			</td>
		
			<td>
				<%= ci.getCount() %>
			</td>
		
			<td>
				<%= ci.getTotalPrice() %>
			</td>
		</tr>
	<%
}
%>
	</form>
	<center>
		��<%= cart.getTotalPrice() %>Ԫ<br>
		��ӭ<%= usr.getUsername() %>����ȷ�������ջ���Ϣ<br>
		<textarea name="addr" rows="" cols="">
		<%= usr.getAddr() %>
		</textarea>
		<input type="submit" value="�µ�" />
	</center>
</body>
</html>