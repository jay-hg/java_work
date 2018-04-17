<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>Insert title here</title>
</head>
<body>

<%
out.println("Hello World from Eclipse");
%>

<center>
试一下验证码
<img alt="" src="Certification" width="100" hight="80">
<input type="text" name="verification">
<input type="submit" value="提交">
</center>
</body>
</html>