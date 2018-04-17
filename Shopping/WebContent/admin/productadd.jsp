<%@ page language="java" contentType="text/html; charset=GB18030" import="com.summer.shopping.*"
    pageEncoding="GB18030"%>
<%@ include file="sessioncheck.jsp" %>    
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>产品添加</title>
		<script type="text/javascript">
			var arrLeaf = new Array();
			function checkdata() {
				if(arrLeaf[document.form.categoryid.selectedIndex] != "leaf") {
					alert("应选择详细类别");
					document.form.categoryid.focus();
					return false;
				}
				return true;
			}
		</script>
</head>
<body>
<%
request.setCharacterEncoding("gbk");
String action = request.getParameter("action");

String strCategoryID = request.getParameter("categoryid");
int categoryID=0;
try {
	categoryID = Integer.parseInt(request.getParameter("categoryid"));
} catch(NumberFormatException e) {
	categoryID = 0;
}

if(action != null && action.equals("productadd")) {
	String name = request.getParameter("name");
	String descr = request.getParameter("descr");
	int id = -1;
	double normalPrice;
	double memberPrice;
	try {
		categoryID = Integer.parseInt(request.getParameter("categoryid"));
		normalPrice = Double.parseDouble(request.getParameter("normalprice"));
		memberPrice = Double.parseDouble(request.getParameter("memberprice"));

	} catch(NumberFormatException e) {
		e.printStackTrace();
		out.println("添加产品出错，请重试！");
		return;
	}
	
	Category c = Category.loadById(categoryID);
	if(!c.isLeaf()) {
		out.println("应该在详细的类别下添加商品");
		return;
	}
	
	Product p = new Product();
	p.setId(id);
	p.setName(name);
	p.setDescr(descr);
	p.setCategoryID(categoryID);
	p.setNormalPrice(normalPrice);
	p.setMemberPrice(memberPrice);
	p.setPdate(new java.util.Date(System.currentTimeMillis()));

	ProductMgr.getInstance().addProduct(p);
%>
	<center>添加产品成功！</center>
<%
	response.sendRedirect("productlist.jsp");
}
%>

<form name="form" action="productadd.jsp" method="post" onsubmit="return checkdata()">
			<input type="hidden" name="action" value="productadd"/>
			<table width="750" align="center" border="2">
				<tr>
					<td colspan="2" align="center">添加产品</td>
				</tr>
				<tr>
					<td>产品名</td>
					<td>
						<input type=text name="name" size="30" maxlength="30">
					</td>
				</tr>
				<tr>
					<td>描述</td>
					<td>
						<textarea name="descr" cols="40" rows="15"></textarea>
					</td>
				</tr>
				<tr>
					<td>正常价格</td>
					<td>
						<input type=text name="normalprice" size="30" maxlength="30">
					</td>
				</tr>
				<tr>
					<td>会员价</td>
					<td>
						<input type=text name="memberprice" size="30" maxlength="30">
					</td>
				</tr>
				<tr>
					<td>类别</td>
					<td>
						<select name="categoryid">
							<%
							int index = 0;
							List<Category> categories = Category.getCategories();
							for(Iterator<Category> it=categories.iterator(); it.hasNext();) {
								Category c = it.next();
							%>
							<option value="<%= c.getId() %>" <%= c.getId()==categoryID? "selected":"" %>><%= c.getName() %></option>
							<script type="text/javascript">
								arrLeaf[<%= index %>] = <%= c.isLeaf()?"'leaf'":"'notleaf'" %>;
							</script>
							<%
							index ++;
							}
							%>
						</select>
					</td>
				</tr>
				
				<tr>
					<td></td>
					<td>
						<input type="submit" value="提交">
						<input type="reset" value="重置">
					</td>
				</tr>
				
			</table>
		</form>
</body>
</html>