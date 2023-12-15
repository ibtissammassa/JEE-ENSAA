<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Date"  %>
<%@page import="java.net.InetAddress"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Exercice 1.1</title>
</head>
<body>
	<%!private Date d=new Date();  %>
	<p>Nous somme le <%=d%></p>
	<p>Le nom de votre machine : <%=System.getProperty("user.name") %></p>
	<p>Votre adresse IP est : <%=InetAddress.getLocalHost().getHostAddress()%></p>
	<p>Le nom du serveur sur lequel vous etes connecté : <%=request.getServerName()%></p>
</body>
</html>