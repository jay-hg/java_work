<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="Entity.FormEntity" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

LinkedList<FormEntity> entityList = (LinkedList<FormEntity>)session.getAttribute("forms");
FormEntity fe = entityList.removeFirst();
session.setAttribute("forms", entityList);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  <form method="post" action="<%=fe.getDestUrl()%>">
    
    <input type="hidden" name="__VIEWSTATE" value="<%=fe.getParaV()%>"/>
    <input type="hidden" name="__EVENTVALIDATION" value="<%=fe.getParaE()%>"/>
   
   	<input type="hidden" name="ctl00$ContentPlaceHolder1$TB_zf" value="80" />
   	<input type="hidden" name="ctl00$ContentPlaceHolder1$TB_pj" value="发呢搞死他好友推荐愉快而我凡人歌好运姐法国人中泰化学" />
    <input type="hidden" name="ctl00$ContentPlaceHolder1$RB_List1" value="良好" />
    <input type="hidden" name="ctl00$ContentPlaceHolder1$RB_List2" value="良好" />
    <input type="hidden" name="ctl00$ContentPlaceHolder1$RB_List3" value="良好" />
    <input type="hidden" name="ctl00$ContentPlaceHolder1$RB_List4" value="良好" />
    <input type="hidden" name="ctl00$ContentPlaceHolder1$RB_List5" value="良好" />
    <input type="text" name="ctl00$ContentPlaceHolder1$verifycode" value="" />
     <img src="http://59.77.226.35/student/jscp/ValidNums.aspx"/>
    <input type="submit" name="ctl00$ContentPlaceHolder1$Button_xk" value="确定"/>
   </form>
  </body>
</html>
