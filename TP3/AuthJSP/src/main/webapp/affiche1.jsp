<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="p1.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Affichage</title>
</head>
<body>
	<%
		User u = new User();
		u = (User)session.getAttribute("user");
		String mail = u.getMail();
		String password = u.getPassword();
	%>
	<h1>Votre adresse email est: <%=mail%></h1>
	<h1>Votre mot de passe: <%=password %></h1>
</body>
</html>