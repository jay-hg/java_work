<%@ page language="java" contentType="text/html; charset=GB18030" import="com.summer.shopping.*"
    pageEncoding="GB18030"%>
<%@ include file="sessioncheck.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>ɾ��</title>
</head>
<body>
<%
request.setCharacterEncoding("gbk");
try {
	int id = Integer.parseInt(request.getParameter("id"));
	int[] arrayId = new int[1];
	arrayId[0] = id;
	if (!ProductMgr.getInstance().deleteProductsById(arrayId)) {
		out.println("ɾ��ʧ��");
		return;
	}
} catch(NumberFormatException e) {
	e.printStackTrace();
	out.println("ϵͳ������...��ˢ�����Ի���ϵ����Ա");
	return;
}

%>
<h1>ɾ���ɹ���</h1>
<%
response.sendRedirect("productlist.jsp");
%>
</body>
</html>