<%@ page language="java" contentType="text/html; charset=GB18030"
	import="com.summer.shopping.*" pageEncoding="GB18030"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>表单</title>
<script language=JavaScript src="script/regcheckdata.js"></script>
<script type="text/javascript">
	var req;
	function validate() {
		if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
			req = new XMLHttpRequest();
		} else {// code for IE6, IE5
			req = new ActiveXObject("Microsoft.XMLHTTP");
		}
		var username = document.getElementById("username");
		var url = "validate.jsp?username="+escape(username.value);
		//alert(username);
		req.open("GET",url,true);
		req.onreadystatechange = callback;
		req.send(null);
	}
	
	function callback() {
		if(req.readyState == 4) {
			if(req.status == 200) {
				var msg = req.responseXML.getElementsByTagName("msg")[0];
				//alert(msg.childNodes[0].nodeValue);
				setMsg(msg.childNodes[0].nodeValue);
			}
		}
	}
	
	function setMsg(msg) {
		var eSpan = document.getElementById("usernameErr");
		if(msg == "invalidate") {
			eSpan.innerHTML = "<font color='red'>用户名已被使用</font>";
		} else {
			eSpan.innerHTML = "<font color='green'>可以使用</font>";
		}
	}
</script>
</head>
<body>
	<%
		request.setCharacterEncoding("gbk");
		String action = request.getParameter("action");
		if (action != null && action.equals("register")) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String phone = request.getParameter("phone");
			String addr = request.getParameter("addr");
			//需要验证信息

			User u = new User();
			u.setUsername(username);
			u.setPassword(password);
			u.setPhone(phone);
			u.setAddr(addr);
			u.setRdate(new java.util.Date(System.currentTimeMillis()));
			u.save();
	%>
	<center>Register OK!Thanks!</center>
	<%
		return;
		}
	%>
	<form name="form" action="register.jsp" method="post"
		onSubmit="return checkdata()">
		<input type="hidden" name="action" value="register" />
		<table width="750" align="center" border="2">
			<tr>
				<td colspan="2" align="center">用户注册</td>
			</tr>
			<tr>
				<td>用户名：</td>
				<td><input type=text name="username" id="username" size="30" maxlength="30"
					onblur="validate()">
					<span id="usernameErr"></span>
				</td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type=password name="password" size="15"
					maxlength="18"></td>
			</tr>
			<tr>
				<td>密码确认</td>
				<td><input type=password name="password2" size="15"
					maxlength="18"></td>
			</tr>

			<tr>
				<td>电话</td>
				<td><input type="text" name="phone" size="15" maxlength="20">
				</td>
			</tr>

			<tr>
				<td>地址</td>
				<td><textarea name="addr" rows="10" cols="80"></textarea></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="提交" onclick="checkdata()"> <input
					type="reset" value="重置"></td>
			</tr>

		</table>
	</form>
</body>
</html>