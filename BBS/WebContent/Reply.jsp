<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
String pid = request.getParameter("id");
String rootid = request.getParameter("rootid");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>

<form action="ReplyOk.jsp" method="post">
<input type="hidden" name="pid" value="<%= pid %>"/>
<input type="hidden" name="rootid" value="<%= rootid %>"/>
<table width="400" border="1">
  <tr>
    <td><input type="text" width="400" name="title"/></td>
  </tr>
  <tr>
    <td><textarea rows="15" cols="55" name="cont"></textarea></td>
  </tr>
  <tr>
    <td>
      <input type="submit" value="提交" />
  	</td>
  </tr>
</table>
</form>

</body>
</html>