package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class UsuarioContraBD {
	
	public static String url = "jdb:sqlite:resources/db/Usuarios.db";
	public static String org = "org.sqlite.JDBC";
	
	public static Connection conectar() {
		Connection conn = null;
		
		try {
			Class.forName(org);
		} catch (ClassNotFoundException e) {
			System.out.println("error");
		}
		
		try {
			conn = (Connection) DriverManager.getConnection(url);
			System.out.println("conexion ok");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
		
	}

}
