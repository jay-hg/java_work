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
<form name="form" action="cartupdate.jsp" method="post">
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
			<input type="text" name="p<%= p.getId() %>" value="<%= ci.getCount() %>" />
			</td>
		
			<td>
				<%= ci.getTotalPrice() %>
			</td>
		</tr>
	<%
}
%>
		</table>
		<center>
		��<%= cart.getTotalPrice() %>Ԫ<br>
		<input type="submit" value="�޸�����" />
		<input type="button" value="ȷ�Ϲ���" onclick="document.location.href='confirm.jsp'" />
		</center>
	</form>
</body>
</html>