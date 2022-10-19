<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	String favorito = null;
	//1. Leer la cookie del  navegador
	Cookie[] cookies = request.getCookies();
	//2. Buscamos la cookie con el nombre que queremos
	if (cookies != null) {
		for (Cookie cookie_temporal : cookies) {
			if ("deporte_favorito".equals(cookie_temporal.getName())) {
		favorito = cookie_temporal.getValue();
			}
		}
	} else {
		favorito = "No existe";
	}
	%>
	<p>
		Deporte favorito
		<%=favorito%></p>
</body>
</html>