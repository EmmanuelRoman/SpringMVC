<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>P�gina de Inicio</title>
</head>
<body>
	<h1>P�gina de Inicio</h1>
	<ul>
		<li><a href="<c:url value='/about'/>">Acerca de... </a></li>
		<li><a href="<c:url value='/admin'/>"> Gesti�n de
				Administradores </a></li>
	</ul>
</body>
</html>