package nombredominio.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import nombredominio.models.Usuario;
import nombredominio.modelsDAO.UsuarioDAO;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;

/**
 * Servlet implementation class UsuariosController
 */
public class UsuariosController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String acceso; // Variable que distingue entre las vistas a las que tengo que redireccionar
	String action; // Variable que recibo por url y que me enlaza con el metodo o vista
					// correspondiente

	Usuario usuario;
	UsuarioDAO usuarioDAO = new UsuarioDAO();

	String nombre, email, password;

	String index = "usuarios/index.jsp";
	String create = "usuarios/create.jsp";
	String edit = "usuarios/edit.jsp";

	ArrayList<Usuario> usuarios = new ArrayList<>();

	int id;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		acceso = "";
		action = request.getParameter("action");// Valor que recojo por url

		switch (action) {

		case "index":
			usuarios = usuarioDAO.all();
			request.setAttribute("usu", usuarios);
			acceso = index;
			break;
		case "create":
			acceso = create;
			break;
		case "edit":
			id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("usu", usuarioDAO.find(id));
			acceso = edit;
			break;
		case "delete":

			id = Integer.parseInt(request.getParameter("id"));
			usuarioDAO.delete(id);

			acceso = index;

			break;
		default:
			break;

		}
		RequestDispatcher vista = request.getRequestDispatcher(acceso);
		vista.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		acceso = "";
		action = request.getParameter("action");// Valor que recojo por url

		switch (action) {
		case "save":
			nombre = request.getParameter("nombre");
			email = request.getParameter("email");
			password = request.getParameter("password");

			usuario = new Usuario();
			usuario.setNombre(nombre);
			usuario.setEmail(email);
			usuario.setPassword(getMD5(password));
			usuarioDAO.save(usuario);
			acceso = index;
			break;

		case "update":

			id = Integer.parseInt(request.getParameter("id"));
			nombre = request.getParameter("nombre");
			email = request.getParameter("email");
			password = request.getParameter("password");
			usuario = new Usuario();
			usuario.setId(id);
			usuario.setNombre(nombre);
			usuario.setEmail(email);
			
			if (password!=null && password!="") {
				usuario.setPassword(getMD5(password));
			}
			//si usuario no introduce password, no hay set password
			usuarioDAO.update(usuario);

			acceso = index;
			System.out.println(acceso);
			break;

		default:
			break;

		}
		RequestDispatcher vista = request.getRequestDispatcher(acceso);
		vista.forward(request, response);
	}

	public String getMD5(String input) {

		try {

			MessageDigest md = MessageDigest.getInstance("MD5");

			byte[] encBytes = md.digest(input.getBytes());

			BigInteger numero = new BigInteger(1, encBytes);

			String encString = numero.toString(16);

			while (encString.length() < 32) {

				encString = "0" + encString;

			}

			return encString;

		} catch (Exception e) {

			throw new RuntimeException(e);

		}

	}
}
