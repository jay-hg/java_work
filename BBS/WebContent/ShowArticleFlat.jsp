<%@ page language="java" contentType="text/html; charset=gbk"
    pageEncoding="gbk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*" %>

<%
	int pageNo = 1;
	int pageSize = 3;
	int totalPage = 0;
	String p = (String)request.getParameter("pageNo");
	if(p != null) {
		try {
		pageNo = Integer.parseInt(p);			
		} catch (NumberFormatException e) {
			pageNo = 1;
		}
		
		if(pageNo < 1) {
			pageNo = 1;
		}
	}

	Class.forName("com.mysql.jdbc.Driver");
	String url = "jdbc:mysql://localhost/bbs?user=root&password=tiger";
	Connection conn = DriverManager.getConnection(url);
	Statement pageStmt = conn.createStatement();

	ResultSet pageRs = pageStmt.executeQuery("select count(*) from article where pid=0");
	
	int rows = 0;
	if(pageRs.next()) {
		 rows = pageRs.getInt(1);	
	}
	pageRs.close();
	pageRs.close();
	if(rows%pageSize==0) {
		totalPage = rows/pageSize;
	} else {
		totalPage = rows/pageSize + 1;
	}
	
	if(pageNo > totalPage) {
		pageNo = totalPage;
	}
	
	Statement stmt = conn.createStatement();
	ResultSet rs = stmt.executeQuery("select * from article where pid = 0 order by pdate desc limit "+pageSize*(pageNo-1)+","+pageSize);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<title>Insert title here</title>
</head>
<body>

<a href="Post.jsp">发表主题</a>
<table border="1">
<%
while(rs.next()) {
%>
	<tr>
	<td><%= rs.getString("title") %></td>
	</tr>
<%
}

rs.close();
stmt.close();
conn.close();
%>
</table>
第<%= pageNo %>页，共 <%= totalPage %>页
<a href="ShowArticleFlat.jsp?pageNo=<%= pageNo-1 %>"> ＜ </a>
<a href="ShowArticleFlat.jsp?pageNo=<%= pageNo+1 %>"> ＞ </a>

<br/>
<form name="form1" action="ShowArticleFlat.jsp">
<select name="pageNo" onchange="document.form1.submit()">
<%
for(int i=1; i<=totalPage; i++) {
%>
	<option value="<%= i %>" <%= i==pageNo?"selected":"" %>>
	第<%= i %>页
	</option>
<%	
}
%>
</select>
</form>

<br/>
<form name="form2" action="ShowArticleFlat.jsp">
<input type="text" size="4" name="pageNo" value="<%= pageNo %>" onblur="document.form2.submit()"/>
<input type="submit" value="go"/>
</form>
</body>
</html>