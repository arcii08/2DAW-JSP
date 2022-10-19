<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>Insertando la cookie</p>

	<%
	//1. Recoger el elemneto del select
	String deporte = request.getParameter("favorito");
	//2. Creo la cookie --> (clave, valor)
	Cookie cookie = new Cookie("deporte_favorito", deporte);
	//3. Establecer la vida de la cookie
	cookie.setMaxAge(60 * 60);//1 hora
	//4. Enviar la cookie
	response.addCookie(cookie);
	%>
	<a href="getCookies.jsp">Ver deportes</a>
</body>
</html>