<%@page import="com.sarje.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="cache_control_page.jsp" %> 
<%
	User user = (User)session.getAttribute("user");
	if(user!=null && user.getUname()!=null){
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Home</title>
</head>
<body>
	<%@ include file="user_menu.jsp" %>
	<h3>Logged In User : <%=user.getUname()%></h3>
	<a href="user_upload_form.jsp" >Upload Profile Pic</a>
</body>
</html>
<% }else{	
	response.sendRedirect("logout.jsp");
} %>