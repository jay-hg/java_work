<%@ page language="java" contentType="text/html; charset=GB18030" import="com.summer.shopping.*"
    pageEncoding="GB18030"%>
<%@ include file="sessioncheck.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>类别添加</title>
		<script language=JavaScript src="script/regcheckdata.js"></script>
		<script type="text/javascript">
			
		</script>
</head>
<body>
<%
request.setCharacterEncoding("gbk");
String action = request.getParameter("action");
if(action != null && action.equals("categoryadd")) {
	String name = request.getParameter("name");
	String descr = request.getParameter("descr");
	int pid = Integer.parseInt(request.getParameter("pid"));
	int grade = Integer.parseInt(request.getParameter("grade"));
	
	Category c = new Category();
	c.setId(-1);
	c.setName(name);
	c.setDescr(descr);
	c.setPid(pid);
	c.setLeaf(true);
	c.setGrade(grade);
	
	Category.addCategory(c);
%>
	<center>添加类别成功！</center>
<%
	response.sendRedirect("categorylist.jsp");
}
%>
<%
int pid;
int grade;
try {
	pid = Integer.parseInt(request.getParameter("id"));
	grade = Integer.parseInt(request.getParameter("grade"))+1;
} catch(NumberFormatException e) {
	pid = 0;
	grade = 1;
}

%>
<form name="form" action="categoryadd.jsp" method="post">
			<input type="hidden" name="action" value="categoryadd"/>
			<input type="hidden" name="pid" value="<%=pid%>"/>
			<input type="hidden" name="grade" value="<%=grade%>"/>
			<table width="750" align="center" border="2">
				<tr>
					<td colspan="2" align="center">添加类别</td>
				</tr>
				<tr>
					<td>类别名</td>
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