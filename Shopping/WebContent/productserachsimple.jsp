<%@ page language="java" contentType="text/html; charset=GB18030" import="com.summer.shopping.*"
    pageEncoding="GB18030"%>  
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.Timestamp" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>产品搜索</title>
</head>
<body>
<%!
int pageNo = 1;
int pageCount = 1;
static int PAGE_SIZE = 3;
%>
<%
	request.setCharacterEncoding("gbk");
	String action = request.getParameter("action");
	String keyword = request.getParameter("keyword");
	String[]  categoryIds = request.getParameterValues("categoryid");
	
	int[] categoryArr;
	
	if(categoryIds == null || categoryIds.length == 0) {
		categoryArr = null;
	} else {
		categoryArr = new int[categoryIds.length];
		for(int i=0; i<categoryIds.length; i++) {
			try {
				categoryArr[i] = Integer.parseInt(categoryIds[i]);
			} catch(NumberFormatException e) {
				e.printStackTrace();
				out.println("搜索出错，请重试！");
				return;
			} finally {
				categoryArr = null;
				categoryIds = null;
			}
		}
	}
	
	try {
		pageNo = Integer.parseInt(request.getParameter("pageno"));
	} catch(NumberFormatException e) {
		pageNo = 1;
	}
	
	List<Product> products = new ArrayList<Product>();
	int resultCount = ProductMgr.getInstance().findProducts(products, categoryArr, keyword, -1.0, -1.0, -1.0, -1.0, null, null, pageNo, PAGE_SIZE);
	pageCount = ((resultCount-1)/PAGE_SIZE)+1;
	
	if(pageNo < 1) {
		pageNo = 1;
	}
	if(pageNo > pageCount) {
		pageNo = pageCount;
	}
	%>
	
	<center>搜索结果</center>
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
		<td><%= p.getCategoryID() %></td>
	</tr>
	<%
	}
	%>
	</table>
	<center>
	共找到<%=resultCount %>项相关商品
	</center>
	<br>
	<center>
	共<%=pageCount %>页
	&nbsp;
	<a href="productserach.jsp?action=<%=action %>&keyword=<%= keyword %>&pageno=<%=pageNo+1%>">下一页</a>
	</center>

</body>
</html>