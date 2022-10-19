<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<div class="row">
		<div class="col-lg-5"></div>
		<div class="col-lg-5">
			<h1>Formulario</h1>
			<form method="POST" action="AuthController?action=login">
				<p>Email:</p>
				<input type="email" name="email"><br>
				<p>Password:</p>
				<input type="text" name="password"><br>
				<br>
				<button type="submit">Enviar</button>


			</form>
			<div class="col-lg-2"></div>
		</div>
	</div>
</body>
</html>