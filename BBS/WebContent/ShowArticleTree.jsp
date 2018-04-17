<%@ page language="java" contentType="text/html; charset=gbk"
    pageEncoding="gbk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*" %>

<%!
boolean login = false;
String str = "";
String strLogin = "";
private void tree(int id, Connection conn, int level) {
	Statement stmt = null;
	ResultSet rs = null;
	String preStr = "";
	
	for(int i=0; i<level; i++) {
		preStr += "----";
	}
	try {
		stmt = conn.createStatement();
		String sql = "select * from article where pid ="+id;
		rs = stmt.executeQuery(sql);
		while(rs.next()) {
			if(login) {
				strLogin = "<td><a href='Delete.jsp?id="+rs.getInt("id")+"&pid="+rs.getInt("pid")+"'>删除</a></td>";
			}
			str += "<tr><td>"+rs.getInt("id")+"</td><td>"
					+"<a href='ShowArticleDetail.jsp?id="+rs.getInt("id")+"'>"
					+preStr+rs.getString("title")+"</a>"+"</td>"
					+strLogin+"</tr>";
			
			if(rs.getInt("isleaf") == 1) {
				tree(rs.getInt("id"),conn,level+1);
			}
		}
	} catch(SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			if(rs != null) {
				rs.close();
			}
			if(stmt != null) {
				stmt.close();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
%>
<%
	String isLogin = (String)session.getAttribute("login");	
	if(isLogin != null && isLogin.equals("yes")) {
		login = true;
	}	
	Class.forName("com.mysql.jdbc.Driver");
	String url = "jdbc:mysql://localhost/bbs?user=root&password=tiger";
	Connection conn = DriverManager.getConnection(url);
	Statement stmt = conn.createStatement();
	ResultSet rs = stmt.executeQuery("select * from article where pid = 0");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<title>Insert title here</title>
</head>
<body>
<%
while(rs.next()) {
	if(login) {
		strLogin = "<td><a href='Delete.jsp?id="+rs.getInt("id")+"&pid="+rs.getInt("pid")+"'>删除</a></td>";
	}
	str += "<tr><td>"+rs.getInt("id")+"</td><td>"
			+"<a href='ShowArticleDetail.jsp?id="+rs.getInt("id")+"'>"+rs.getString("title")+"</a>"
	+"</td>"
	+strLogin+"</tr>";;
			
	if(rs.getInt("isleaf") == 1) {
		tree(rs.getInt("id"),conn,1);
	}
}

rs.close();
stmt.close();
conn.close();
%>
<a href="Post.jsp">发表主题</a>
<table border="1">
	<%= str %>
</table>
<% 
str = "";
strLogin = "";
login = false;
%>
</body>
</html>