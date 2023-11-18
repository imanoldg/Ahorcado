package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class UsuarioContraBD {{
	
	
	try {
		Class.forName("org.sqlite.JDBC");
	}catch(ClassNotFoundException e1) {
		System.out.println("error");
	}
	
	try {
		Connection conn = DriverManager.getConnection("jdbc:sqlite:/resources/db/Usuarios.db");
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM usuario");
		
		while (rs.next()) {
			String nombre = rs.getString("nombre");
			String contraseña = rs.getString("contraseña");
			System.out.format("%d - %s, %s: %.2f €%n", nombre, contraseña);

			
	}
		stmt.close();
		conn.close();
		} catch (SQLException e) {
		System.out.println("error");
		}
	System.out.println("Programa terminado");

}}
