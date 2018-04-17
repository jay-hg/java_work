<%@ page language="java" contentType="text/html; charset=GB18030" import="com.summer.shopping.*"
    pageEncoding="GB18030"%>
<%@ include file="sessioncheck.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>删除</title>
</head>
<body>
<%
request.setCharacterEncoding("gbk");
try {
	int id = Integer.parseInt(request.getParameter("id"));
	int[] arrayId = new int[1];
	arrayId[0] = id;
	if (!ProductMgr.getInstance().deleteProductsById(arrayId)) {
		out.println("删除失败");
		return;
	}
} catch(NumberFormatException e) {
	e.printStackTrace();
	out.println("系统出错了...请刷新重试或联系管理员");
	return;
}

%>
<h1>删除成功！</h1>
<%
response.sendRedirect("productlist.jsp");
%>
</body>
</html>