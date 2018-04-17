<%@ page language="java" contentType="text/html; charset=GB18030" import="com.summer.shopping.*"
    pageEncoding="GB18030"%>
<%@ page import="java.util.*" %>
<%@ include file="islogin.jsp" %>   

<%
request.setCharacterEncoding("gbk");
int id;
try {
	id = Integer.parseInt(request.getParameter("id"));
} catch(NumberFormatException e) {
	out.println("¹ºÂò³ö´í");
	return;
}

Cart cart = (Cart)session.getAttribute("cart");
if(cart == null) {
	cart = new Cart();
	session.setAttribute("cart", cart);
}

Product p = ProductMgr.getInstance().loadById(id);
CartItem ci = new CartItem();
ci.setProduct(p);
ci.setPrice(p.getMemberPrice());
ci.setCount(1);
cart.add(ci);

response.sendRedirect("cart.jsp");
%>
