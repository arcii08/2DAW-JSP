<%@page import="nombredominio.models.Usuario"%>
<%@page import="nombredominio.modelsDAO.UsuarioDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>USUARIOS | Edit</title>
</head>
<body>
	<h1>USUARIOS EDIT</h1>
	<%
	Usuario usuario = (Usuario) request.getAttribute("usu");
	%>

	<form method="POST" action="UsuariosController?action=update">
		<input type="hidden" name="id" value="<%=usuario.getId()%>">
		<p>Nombre</p>
		<input type="text" name="nombre" value="<%=usuario.getNombre()%>"><br>
		<p>Email</p>
		<input type="email" name="email" value="<%=usuario.getEmail()%>"><br>
			<p>Password</p>
		<input type="text" name="password" value="<%=usuario.getEmail()%>"><br>
		<button type="submit">Actualizar</button>


	</form>
</body>
</html>