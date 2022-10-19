<%

if(request.getSession().getAttribute("usuario")!=null){
	out.println("<p>Existe usuario logueado</p>");
}else{
	response.sendRedirect("AuthController?action=login");
}

%>
