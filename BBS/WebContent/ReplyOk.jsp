<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	request.setCharacterEncoding("gbk");	

	int pid;
	int rootid;
	String title = request.getParameter("title");
	String cont = request.getParameter("cont");
	
	try {
		pid = Integer.parseInt(request.getParameter("pid"));
		rootid = Integer.parseInt(request.getParameter("rootid"));
	} catch(NumberFormatException e) {
		out.println("请通过合法手段发帖");
		return;
	}
	
	if(title == null) {
		out.println("标题不能为空");
		return;
	} else if(title.trim().equals("")) {
		out.println("标题不能为空");
		return;
	}
	
	if(pid<0 | rootid<0) {
		out.println("请通过合法手段发帖");
		//实际上还得判断数据库中有没有这个pid和rootid
		return;
	}
	
	Class.forName("com.mysql.jdbc.Driver");
	String url = "jdbc:mysql://localhost/bbs?user=root&password=tiger";
	Connection conn = DriverManager.getConnection(url);
	Statement stmt = conn.createStatement();
	PreparedStatement pstmt = 
			conn.prepareStatement("insert into article values(null,?,?,?,?,now(),0)");

	conn.setAutoCommit(false);
	pstmt.setInt(1,pid);
	pstmt.setInt(2, rootid);
	pstmt.setString(3, title);
	pstmt.setString(4,cont);
	pstmt.executeUpdate();
	stmt.executeUpdate("update article set isleaf=1 where id="+pid);
	conn.commit();
	conn.setAutoCommit(true);
	
	stmt.close();
	pstmt.close();
	conn.close();
	
	response.sendRedirect("ShowArticleTree.jsp");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
</body>
</html>