<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
request.setCharacterEncoding("gbk");	
String action = request.getParameter("action");
if(action != null && action.equals("post")) {

		String title = request.getParameter("title");
		String cont = request.getParameter("cont");
		
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost/bbs?user=root&password=tiger";
		Connection conn = DriverManager.getConnection(url);
		PreparedStatement pstmt = 
				conn.prepareStatement("insert into article values(null,0,-1,?,?,now(),0)",
						Statement.RETURN_GENERATED_KEYS);

		conn.setAutoCommit(false);
		pstmt.setString(1, title);
		pstmt.setString(2,cont);
		pstmt.executeUpdate();
		
		ResultSet rsKeys = pstmt.getGeneratedKeys();
		rsKeys.next();
		int key = rsKeys.getInt(1);
		rsKeys.close();
		Statement stmt = conn.createStatement();
		stmt.executeUpdate("update article set rootid="+key+" where id="+key);
		stmt.close();
		
		conn.commit();
		conn.setAutoCommit(true);
		
		pstmt.close();
		conn.close();
		
		response.sendRedirect("ShowArticleFlat.jsp");
}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>

<form action="Post.jsp" method="post">
<input type="hidden" name="action" value="post"/>
<table width="400" border="1">
  <tr>
    <td><input type="text" width="400" name="title"/></td>
  </tr>
  <tr>
    <td><textarea rows="15" cols="55" name="cont"></textarea></td>
  </tr>
  <tr>
    <td>
      <input type="submit" value="Ìá½»" />
  	</td>
  </tr>
</table>
</form>

</body>
</html>