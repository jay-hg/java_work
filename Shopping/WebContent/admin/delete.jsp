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
	User.delete(id);
} catch(NumberFormatException e) {
	e.printStackTrace();
}

%>
<h1>删除成功！</h1>
<script type="text/javascript">
window.parent.main.document.location.reload();
</script>
</body>
</html>