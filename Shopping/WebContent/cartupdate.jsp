<%@ page language="java" contentType="text/html; charset=GB18030" import="com.summer.shopping.*"
    pageEncoding="GB18030"%>
<%@ page import="java.util.*" %>
<%@ include file="islogin.jsp" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>���ﳵ</title>
		
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
		out.println("������������������޸�");
	}
	
}

%>
<center>
�޸ĳɹ���
</center>

<span id="num">3</span>�����ת
<script type="text/javascript">
	var leftTime = 2;
	function go() {
		document.getElementById("num").innerText = leftTime;
		leftTime --;
		if(leftTime <= 0) {
			document.location.href = "cart.jsp";
		}
	}
	
	setInterval(go,1000);//ÿ��1000������ã�setTimeOut�Ǽ���������
</script>
</body>
</html>