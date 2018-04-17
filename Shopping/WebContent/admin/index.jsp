<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ include file="sessioncheck.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script language="javascript">
	state = 0;
	menuState = 0;
	mainState = 0;
</script>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>Shopping管理</title>
</head>

<frameset rows="29,*" border="0" cols="*">
	<frame name="top" scrolling="no" noresize="noresize" src="top.html" />
    <frameset cols="20%,*" border="0" rows="*">
    	<frame frameborder="0" name="mleft" src="menu.html" />
        <frameset rows="20,*" cols="*">
			<frame noresize="noresize" scrolling="no" name="mtitle" src="title.html" />
            <frame name="main" marginwidth="0" marginheight="0" scrolling="yes" src="UntitledFrame-24"/>
        	<frame name="detail" src="" />
        </frameset>
    </frameset>
</frameset><noframes></noframes>
</html>
