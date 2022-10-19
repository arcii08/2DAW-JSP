<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="nombredominio.modelsDAO.UsuarioDAO"%>
<%@page import="nombredominio.models.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="daw"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>USUARIOS | Index</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
	crossorigin="anonymous">

</head>
<body>
	<div class="row">
		<div class="col-lg-4"></div>
		<div class="col-lg-4">
			<table class="table">
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">Nombre</th>
						<th scope="col">Email</th>
						<th scope="col">Acciones</th>
					</tr>
				</thead>
				<tbody class="table-group-divider">

					<%-- <%

					ArrayList<Usuario>usuarios=(ArrayList<Usuario>)request.getAttribute("usu");

					for (int i = 0; i < usuarios.size(); i++) {
						Usuario usuario = usuarios.get(i);
					%>

					<tr>
						<th><%=usuario.getId()%></th>
						<td><%=usuario.getNombre()%></td>
						<td><%=usuario.getEmail()%></td>
						<td><a
							href="UsuariosController?action=edit&id=<%=usuario.getId()%>">Edit</a>
							<a href="UsuariosController?action=delete&id=<%=usuario.getId()%>">Delete</a>
						</td>
					</tr>
					<%
					}
					%> --%>

					<daw:forEach var="usuario" items="${usu}">
						<tr>
							<th>${usuario.id}</th>
							<td>${usuario.nombre}</td>
							<td>${usuario.email}</td>
							<td><a
								href="UsuariosController?action=edit&id=${usuario.id}">Edit</a>
								<a href="UsuariosController?action=delete&id=${usuario.id}">Delete</a></td>
						</tr>
					</daw:forEach>

				</tbody>
			</table>
			<button>
				<a href="UsuariosController?action=create">Agregar Usuario</a>
			</button>
		</div>
		<div class="col-lg-4"></div>
	</div>
</body>
</html>