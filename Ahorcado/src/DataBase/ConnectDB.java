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

/*
public static void main(String[] args) {
	
	try {
		Class.forName("org.sqlite.JDBC");
	}catch(ClassNotFoundException e1) {
		System.out.println("error");
	}
	
	try {
		Connection conn = DriverManager.getConnection("jdbc:sqlite:resources/db/Usuarios.db");
		Statement stmt = (Statement) conn.createStatement();
		ResultSet rs = ((java.sql.Statement) stmt).executeQuery("SELECT * FROM usuario");
		
		while (rs.next()) {
			String nombre = rs.getString("nombre");
			String contraseña = rs.getString("contraseña");
			System.out.format("\"Nombre: %s, Contraseña: %s%n\"", nombre, contraseña);

			
	}
		((Connection) stmt).close();
		conn.close();
		} catch (SQLException e) {
		System.out.println("error");
		}
	System.out.println("Programa terminado");
}

*/