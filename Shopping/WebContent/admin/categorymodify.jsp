<%@ page language="java" contentType="text/html; charset=GB18030" import="com.summer.shopping.*"
    pageEncoding="GB18030"%>
<%@ include file="sessioncheck.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
request.setCharacterEncoding("gbk");

int id;
try {
	id = Integer.parseInt(request.getParameter("id"));
} catch(NumberFormatException e) {
	out.println("修改出错，请重试！");
	return;
}

String action = request.getParameter("action");
if(action != null && action.endsWith("categorymodify")) {
	String name = request.getParameter("name");
	String descr = request.getParameter("descr");
	int pid = Integer.parseInt(request.getParameter("pid"));
	int grade = Integer.parseInt(request.getParameter("grade"));
	
	Category c = new Category();
	c.setId(id);
	c.setName(name);
	c.setDescr(descr);
	c.setPid(pid);
	c.setLeaf(true);
	c.setGrade(grade);	
	
	c.modify();
	
	out.println("修改成功");
	return;
}

Category c = Category.loadById(id);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Modify</title>
</head>
<body>
<form name="form" action="categorymodify.jsp" method="post">
			<input type="hidden" name="action" value="categorymodify"/>
			<input type="hidden" name="id" value="<%= id %>" />
			<input type="hidden" name="pid" value="<%=c.getPid() %>"/>
			<input type="hidden" name="grade" value="<%=c.getGrade() %>"/>
			<table width="750" align="center" border="2">
				<tr>
					<td colspan="2" align="center">添加类别</td>
				</tr>
				<tr>
					<td>类别名</td>
					<td>
						<input type=text name="name" value="<%= c.getName() %>" size="30" maxlength="30">
					</td>
				</tr>
				<tr>
					<td>描述</td>
					<td>
						<textarea name="descr" cols="40" rows="15"><%= c.getDescr() %></textarea>
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