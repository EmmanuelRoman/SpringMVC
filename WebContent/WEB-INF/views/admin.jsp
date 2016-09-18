<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Página del Administrador</title>
</head>
<body>
	<h1>admin.jsp</h1>
	<form:form commandName="admin" method="post"
		action="${pageContext.request.contextPath}/admin/save">
		<table>
			<tr>
				<td>Estado :</td>
				<td><input type="text" name="estado"/></td>
			</tr>
			<tr>
				<td>Nombre :</td>
				<td><form:input path="nombre" type="text" /></td>
			</tr>
			<tr>
				<td>Cargo :</td>
				<td><form:input path="cargo" type="text" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Guardar Datos" /></td>
			</tr>
		</table>
	</form:form>
	<br>
	<c:out value="${resultado}" />
</body>
</html>