package DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MetodosBD {
	
	public static UsuarioContraBD conexion = new UsuarioContraBD();
	
	public static PreparedStatement sp;
	public static ResultSet rs;
	public static String sql;
	public static int result = 0;
	
	public int guardar(String nombre, String password) {
		int resultado = 0;
		Connection conexion = null;
		
		String saveStatement = ("INSERT INTO usuario (cod, nombre, contraseña, puntuación) VALUES (0,?,?,0)");
		
		try {
			conexion = UsuarioContraBD.conectar();
			sp = conexion.prepareStatement(saveStatement);
			sp.setString(2,nombre);
			sp.setString(3, password);
			
			
			resultado = sp.executeUpdate();
			sp.close();
		} catch (Exception e) {
			System.out.println("error");
		}
		
		return resultado;
	}
}
