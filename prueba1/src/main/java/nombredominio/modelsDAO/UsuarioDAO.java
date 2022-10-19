package nombredominio.modelsDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import nombredominio.config.conexion;
import nombredominio.models.Usuario;

public class UsuarioDAO {
	conexion conexion = new conexion();

	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	Statement statement;

	Usuario usuario = new Usuario();
	ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

	public Usuario save(Usuario usuario) {
		String sql = "INSERT INTO usuarios (nombre, email, password) VALUES ('" + usuario.getNombre() + "','"
				+ usuario.getEmail() + "','" + usuario.getPassword() + "')";

		try {
			conn = conexion.getConnection();
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usuario;
	}

	public boolean delete(int id) {
		String sql = "DELETE FROM usuarios WHERE id = " + id;

		try {
			conn = conexion.getConnection();
			statement = conn.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

	public Usuario update(Usuario usuario) {
		String sql = "";

		if (usuario.getPassword() != null) {
			sql = "UPDATE usuarios SET nombre='" + usuario.getNombre() + "',email='" + usuario.getEmail()
					+ "',password='" + usuario.getPassword() + "' WHERE id=" + usuario.getId();
		} else {
			sql = "UPDATE usuarios SET nombre='" + usuario.getNombre() + "',email='" + usuario.getEmail()
					+ "' WHERE id=" + usuario.getId();
		}

		try {
			conn = conexion.getConnection();
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return usuario;
	}

	public Usuario find(int id) {
		String sql = "SELECT * FROM usuarios WHERE id = " + id;

		try {
			conn = conexion.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				usuario.setId(rs.getInt("id"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setEmail(rs.getString("email"));
				usuario.setPassword(rs.getString("password"));
				return usuario;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Usuario> all() {

		String sql = "SELECT * FROM usuarios";
		usuarios = new ArrayList<Usuario>();

		try {
			conn = conexion.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setEmail(rs.getString("email"));
				usuario.setPassword(rs.getString("password"));
				usuarios.add(usuario);
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return usuarios;
	}

	public boolean validate(String email, String password) {

		String sql = "SELECT * FROM usuarios WHERE email='" + email + "' AND password ='" + password + "'";
		try {
			conn = conexion.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public Usuario getUsuario(String email, String password) {

		String sql = "SELECT * FROM usuarios WHERE email='" + email + "' AND password='" + password + "'";

		try {
			conn = conexion.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				usuario.setId(rs.getInt("id"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setEmail(rs.getString("email"));
				usuario.setPassword(rs.getString("password"));
				return usuario;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
