<%@ page language="java" contentType="text/html; charset=GB18030" import="com.summer.shopping.*"
    pageEncoding="GB18030"%>
<%@ page import="java.util.*" %>
<%@ include file="islogin.jsp" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>购物车</title>
		
</head>
<body>
		
<%
request.setCharacterEncoding("gbk");
Cart cart = (Cart)session.getAttribute("cart");
List<CartItem> items = cart.getCartItems();
CartItem ci = null;
int count;
for(Iterator<CartItem> it=items.iterator();it.hasNext() ; ) {
	ci = it.next();
	try {
		count = Integer.parseInt(request.getParameter("p"+ci.getProduct().getId()));
		if(count <= 0) {
			it.remove();
		}
		ci.setCount(count);
	} catch(NumberFormatException e) {
		out.println("输入的数量出错，不做修改");
	}
	
}

%>
<center>
修改成功！
</center>

<span id="num">3</span>秒后跳转
<script type="text/javascript">
	var leftTime = 2;
	function go() {
		document.getElementById("num").innerText = leftTime;
		leftTime --;
		if(leftTime <= 0) {
			document.location.href = "cart.jsp";
		}
	}
	
	setInterval(go,1000);//每隔1000毫秒调用，setTimeOut是几毫秒后调用
</script>
</body>
</html>