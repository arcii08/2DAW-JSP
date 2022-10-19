package nombredominio.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {
	Connection conection;

	public conexion() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto2daw", "root", "");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection desconectar() {
		conection = null;
		return conection;
	}

	public Connection getConnection() {
		// TODO Auto-generated method stub
//		
		return conection;

	}
}
