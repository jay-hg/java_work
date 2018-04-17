<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ page import="com.summer.shopping.*,java.util.*" %>

<% 
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
	
	request.setCharacterEncoding("gb2312");
	String parentId = request.getParameter("categoryid");
	int pid;
	
	try {
		pid = Integer.parseInt(parentId);
	} catch(NumberFormatException e) {
		e.printStackTrace();
		out.println("³ö´í");
		return;
	}
	List<Category> children = Category.getChildCategories(pid);
	Category c = null;
	StringBuffer buf = new StringBuffer();
	for(int i=0; i<children.size(); i++) {
		c = children.get(i);
		buf.append(c.getId()+","+c.getName()+"_");
	}
	if(buf.length()>0) buf.deleteCharAt(buf.length() - 1);//delete the last "_" of the string
	
	response.getWriter().write(buf.toString());
	
%>