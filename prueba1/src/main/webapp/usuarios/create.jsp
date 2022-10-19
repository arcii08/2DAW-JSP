<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="nombredominio.modelsDAO.UsuarioDAO"%>
<%@page import="nombredominio.models.Usuario"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>USUARIOS | Create</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
	crossorigin="anonymous">
</head>
<body>
	<div class="row">
		<div class="col-lg-5"></div>
		<div class="col-lg-5">
			<h1>Formulario</h1>
		<form method="POST" action="UsuariosController?action=save">
	<input type="hidden" name="id" >
	<p>Nombre</p>
	<input type="text" name="nombre" ><br>
	<p>Email</p>
	<input type="email" name="email" ><br><br>
	<p>Password</p>
	<input type="text" name="password" ><br><br>
	<button type="submit">Actualizar</button>
	

	</form>
			<div class="col-lg-2"></div>
		</div>
	</div>
</body>
</html>