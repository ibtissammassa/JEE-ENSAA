<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    <%@page import="p1.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		String mail = request.getParameter("email");
		String password = request.getParameter("password");
		User u = new User(mail,password);
		session.setAttribute("user",u);
		response.sendRedirect("affiche1.jsp");
	%>
</body>
</html>