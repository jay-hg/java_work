<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
request.setCharacterEncoding("gbk");	
String action = request.getParameter("action");
if(action != null && action.equals("login")) {

		String userName = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		
		if(userName == null || !userName.equals("admin")) {
			out.println("�û�������");
		} else if(userName == null || !userName.equals("admin")) {
			out.println("�������");
		} else {
			session.setAttribute("login","yes");
			response.sendRedirect("ShowArticleTree.jsp");
		}
		//response.sendRedirect("ShowArticleTree.jsp");
}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>

<form action="Login.jsp" method="post">
<input type="hidden" name="action" value="login"/>
<table width="400" border="1">
  <tr>
  	<td>�û�����</td>
    <td><input type="text" width="400" name="uname"/></td>
  </tr>
  <tr>
    <td>���룺</td>
    <td><input type="password" width="400" name="pwd"/></textarea></td>
  </tr>
  <tr>
    <td>
      <input type="submit" value="��½" />
  	</td>
  </tr>
</table>
</form>

</body>
</html>