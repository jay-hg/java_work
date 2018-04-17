<%@ page language="java" contentType="text/html; charset=GB18030" import="com.summer.shopping.*"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
request.setCharacterEncoding("gbk");	
String action = request.getParameter("action");
if(action != null && action.equals("login")) {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User u = null;
		try {
			u = User.validate(username,password);
		} catch(UserNotFoundException e) {
			out.println("用户不存在！");
			return;
		} catch(PasswordNotCorrectException e) {
			out.println("密码错误！");
			return;
		}
		
		session.setAttribute("user", u);
		response.sendRedirect("selfservice.jsp");
}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>

<form action="login.jsp" method="post">
<input type="hidden" name="action" value="login"/>
<table width="400" border="1">
  <tr>
  	<td>用户名：</td>
    <td><input type="text" width="400" name="username"/></td>
  </tr>
  <tr>
    <td>密码：</td>
    <td><input type="password" width="400" name="password"/></td>
  </tr>
  <tr>
    <td>
      <input type="submit" value="登陆" />
  	</td>
  </tr>
</table>
</form>

</body>
</html>