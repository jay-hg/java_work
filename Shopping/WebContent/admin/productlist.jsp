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
<title>��Ʒ�б�</title>
</head>
<body>
<table border="1" align="center" >
<tr>
	<td>ID</td>
	<td>Name</td>
	<td>Descr</td>
	<td>Normal price</td>
	<td>Member price</td>
	<td>pdate</td>
	<td>category id</td>
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
List<Product> products = new ArrayList<Product>();

if(pageCount > 0) {
	if(pageNo > pageCount) {
		pageNo = pageCount;
	}
}
pageCount = ProductMgr.getInstance().getProducts(products,pageNo,PAGE_SIZE);

Product p = new Product();
for(Iterator<Product> it=products.iterator(); it.hasNext(); ) {
	p = it.next();
	%>
	<tr>
		<td><%= p.getId() %></td>
		<td><%= p.getName() %></td>
		<td><%= p.getDescr() %></td>
		<td><%= p.getNormalPrice() %></td>
		<td><%= p.getMemberPrice() %></td>
		<td><%= p.getPdate() %></td>
		<td><%= p.getCategory().getName() %></td>
		<td>
		<a href="productdelete.jsp?id=<%=p.getId()%>" onclick="return confirm('ȷ��ɾ����')">ɾ��</a>
		</td>
		<td>
		<a href="productmodify.jsp?id=<%=p.getId()%>">�޸�</a>
		</td>
		<td>
		<a href="productimageup.jsp?id=<%=p.getId()%>">ͼƬ�ϴ�</a>
		</td>
	</tr>
<%
}
%>
</table>
<center>
&nbsp;
��<%=pageNo %>ҳ
&nbsp;
��<%=pageCount %>ҳ
&nbsp;
<a href="productlist.jsp?pageno=<%=pageNo-1 %>">��һҳ</a>
&nbsp;
<a href="productlist.jsp?pageno=<%=pageNo+1 %>">��һҳ</a>
&nbsp;
<a href="productlist.jsp?pageno=<%=pageCount %>">���һҳ</a>
</center>
</body>
</html>