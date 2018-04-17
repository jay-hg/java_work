<%@ page language="java" contentType="text/html; charset=GB18030" import="com.summer.shopping.*"
    pageEncoding="GB18030"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ include file="sessioncheck.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>类别列表</title>
</head>
<body>
<table border="1" align="center" >
<tr>
	<td>ID</td>
	<td>Name</td>
	<td>Descr</td>
	<td>pid</td>
	<td>grade</td>
</tr>
<%
String preStr = "";
List<Category> categories = Category.getCategories();
Category c = new Category();
for(Iterator<Category> it=categories.iterator(); it.hasNext(); ) {
	c = it.next();
	for(int i=1;i<c.getGrade();i++) {
		preStr += "----";
	}
	%>
	<tr>
		<td><%= c.getId() %></td>
		<td><%= preStr+c.getName() %></td>
		<td><%= c.getDescr() %></td>
		<td><%= c.getPid() %></td>
		<td><%= c.getGrade() %></td>
		<td>
		<a href="categoryadd.jsp?id=<%=c.getId()%>&grade=<%=c.getGrade()%>">添加子类别</a>
		</td>
		<td>
		<a href="deletecategory.jsp?id=<%=c.getId()%>&pid=<%=c.getPid() %>">删除</a>
		</td>
		<td>
		<a href="categorymodify.jsp?id=<%=c.getId()%>">修改</a>
		</td>
		
		<%if(c.isLeaf()) { %>
		<td>
		<a href="productadd.jsp?categoryid=<%= c.getId() %>">添加商品</a>
		</td>
		<%} %>
		
	</tr>
<%
preStr = "";
}
%>
</table>
</body>
</html>