package DataBase;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectDB {
	
	public static String url = "jdbc:sqlite:resources/db/Usuarios.db";
	public static String fn = "org.sqlite.JDBC";
	public static Connection conectar() {
		Connection conexion = null;
		
		try {
			Class.forName(fn);
			conexion = DriverManager.getConnection(url);
			System.out.println("conected");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
		}
		
		return conexion;

	}
	
}

