<%@ page language="java" contentType="text/html; charset=gbk"
    pageEncoding="gbk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*" %>
<%
String isLogin = (String)session.getAttribute("login");
if(isLogin == null || !isLogin.equals("yes")) {
	out.println("小贼，别想耍花招");
	return;
}
%>
<%!
private void delete(int id, Connection conn) {
	Statement stmt = null;
	ResultSet rs = null;	
	try {
		stmt = conn.createStatement();
		String sql = "select * from article where pid ="+id;
		rs = stmt.executeQuery(sql);
		while(rs.next()) {
			delete(rs.getInt(1),conn);
		}
		
		stmt.executeUpdate("delete from article where id="+id);
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
	String id = request.getParameter("id");
	String pid = request.getParameter("pid");

	Class.forName("com.mysql.jdbc.Driver");
	String url = "jdbc:mysql://localhost/bbs?user=root&password=tiger";
	Connection conn = DriverManager.getConnection(url);
	Statement stmt = conn.createStatement();

	conn.setAutoCommit(false);
	delete(Integer.parseInt(id),conn);
	ResultSet rs = stmt.executeQuery("select count(*) from article where pid="+pid);
	rs.next();
	int count = rs.getInt(1);
	rs.close();

	if(count <= 0) {
		stmt.executeUpdate("update article set isleaf=0 where id = "+pid);
	}
	
	conn.commit();
	conn.setAutoCommit(true);
	stmt.close();
	conn.close();
	
	response.sendRedirect("ShowArticleTree.jsp");
%>