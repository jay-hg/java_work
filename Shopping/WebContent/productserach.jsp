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
		<script type="text/javascript">
			function checkdata() {
				with(document.forms["complex"]) {
					if(lownormalprice == null || lownormalprice.value == "") {
						lownormalprice.value = -1;
					}
					
					if(highnormalprice == null || highnormalprice.value == "") {
						highnormalprice.value = -1;
					}
					
					if(lowmemberprice == null || lowmemberprice.value == "") {
						lowmemberprice.value = -1;
					}
					
					if(highmemberprice == null || highmemberprice.value == "") {
						highmemberprice.value = -1;
					}
				}
			}
		</script>
</head>
<body>
<%!
List<Category> categories = Category.getCategories(); 

%>
<%
request.setCharacterEncoding("gbk");
String action = request.getParameter("action");
if(action != null && action.equals("productserchcomplex")) {
	System.out.println("1");
	%>
	<jsp:forward page="productserachcomplex.jsp"></jsp:forward>
	<%
}

if(action != null && action.equals("productserchsimple")) {
	System.out.println("3");
	%>
	<jsp:forward page="productserachsimple.jsp"></jsp:forward>
	<%
}
%>
	<form name="simplesearch" action="productserach.jsp" method="post">
			<input type="hidden" name="action" value="productserchsimple"/>
			<table width="750" align="center" border="2">
				<tr>
					<th>简单搜索</th>
				</tr>
				<tr>
					<td>关键字：</td>
					<td>
						<input type=text name="keyword" size="30" maxlength="30" />
					</td>
				</tr>
				
				<tr>
					<td>类别</td>
					<td>
						<%
						for(Iterator<Category> it=categories.iterator(); it.hasNext();) {
							Category c = it.next();
							
							if(c.isLeaf()) {
						%>
						<input type="checkbox" name="categoryid" value="<%= c.getId() %>"><%= c.getName() %>
						<br>
						<%
							} else {
								%>
								<%= c.getName() %>
								<br>
								<%
							}
						}
						%>
					</td>
				</tr>
				
				<tr>
					<td></td>
					<td>
						<input type="submit" value="搜">
					</td>
				</tr>
				
			</table>
		</form>

<form name="complex" action="productserach.jsp" method="post" onsubmit="checkdata()">
			<input type="hidden" name="action" value="productserchcomplex"/>
			<table width="750" align="center" border="2">
				<tr>
					<th>复杂搜索</th>
				</tr>
				<tr>
					<td>关键字：</td>
					<td>
						<input type=text name="keyword" size="30" maxlength="30" />
					</td>
				</tr>
				<tr>
					<td>正常价格</td>
					<td>
						Form:<input type=text name="lownormalprice" size="30" maxlength="30" />
						To:<input type=text name="highnormalprice" size="30" maxlength="30" />
					</td>
				</tr>
				<tr>
					<td>会员价</td>
					<td>
						Form:<input type=text name="lowmemberprice" size="30" maxlength="30">
						To:<input type=text name="highmemberprice" size="30" maxlength="30">
					</td>
				</tr>
				<tr>
					<td>类别</td>
					<td>
						<select name="categoryid">
							<option value="0">所有类别</option>
							<%
							for(Iterator<Category> it=categories.iterator(); it.hasNext();) {
								Category c = it.next();
							%>
							<option value="<%= c.getId() %>"><%= c.getName() %></option>
							<%
							}
							%>
						</select>
					</td>
				</tr>
				<tr>
					<td>pdate</td>
					<td>
						Form:<input type=text name="startDate" size="30" maxlength="30">
						To:<input type=text name="endDate" size="30" maxlength="30">
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<input type="submit" value="搜">
					</td>
				</tr>
				
			</table>
		</form>
</body>
</html>