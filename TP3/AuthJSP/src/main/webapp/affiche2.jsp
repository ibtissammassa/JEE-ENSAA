<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Affichage</title>
</head>
<body>
	<jsp:useBean id="u" class="p1.User" scope="session"/>
	Votre Adresse email est:<jsp:getProperty name="u" property="mail"/><br/>
	Votre mot de passe:<jsp:getProperty name="u" property="password"/><br/>
</body>
</html>