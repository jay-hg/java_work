<%@ page language="java" contentType="text/html; charset=GB18030" import="com.summer.shopping.*"
    pageEncoding="GB18030"%>
<%@ include file="islogin.jsp" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>��</title>
		<script language=JavaScript src="script/regcheckdata.js"></script>
		<script type="text/javascript">
			
		</script>
</head>
<body>
<%
request.setCharacterEncoding("gbk");
String action = request.getParameter("action");
if(action != null && action.equals("modify")) {
	String id = request.getParameter("id");
	String username = request.getParameter("username");
	String password = request.getParameter("password");	
	String phone = request.getParameter("phone");	
	String addr = request.getParameter("addr");	
	//��Ҫ��֤��Ϣ
	
	User u = new User();
	u.setId(Integer.parseInt(id));
	u.setUsername(username);
	u.setPhone(phone);
	u.setAddr(addr);
	u.update();
%>
	<center>Modify success!</center>
<%
	return;
}
User user = (User)session.getAttribute("user");
%>
<form name="form" action="usermodify.jsp" method="post" onSubmit="return checkdata()">
			<input type="hidden" name="action" value="modify"/>
			<input type="hidden" name="id" value="<%= user.getId() %>"/>
			<table width="750" align="center" border="2">
				<tr>
					<td colspan="2" align="center">�û�ע��</td>
				</tr>
				<tr>
					<td>�û�����</td>
					<td>
						<input type=text name="username" size="30" maxlength="30" value="<%= user.getUsername() %>" onblur="checkUserName(this.value.toLowerCase())">
						<div id="usernameErr"></div>
						<!--<span id="usernameErr"></span>-->
					</td>
				</tr>
				
				<tr>
					<td>�绰</td>
					<td>
						<input type="text" name="phone" value="<%= user.getPhone() %>" size="15" maxlength="20">
					</td>
				</tr>
				
				<tr>
					<td>��ַ</td>
					<td>
						<textarea name="addr" rows="10" cols="80"><%= user.getAddr() %></textarea>
					</td>
				</tr>
				
				<tr>
					<td>ע��ʱ��</td>
					<td>
						<p name="rdate" size="15" maxlength="20"><%= user.getRdate() %></p>
					</td>
				</tr>
				
				<tr>
					<td></td>
					<td>
						<input type="submit" value="�ύ">
						<input type="reset" value="����">
					</td>
				</tr>
				
			</table>
		</form>
</body>
</html>