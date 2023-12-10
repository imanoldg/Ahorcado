package DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MetodosBD {
	
	public static ConnectDB conexion = new ConnectDB();
	
	public static PreparedStatement ps;
	public static ResultSet resultado;
	public static String sql;
	public static int resultadoNumero = 0;
	
	public int guardar(int cod, String nombre, String password, int puntuacion) {
		int resultado = 0;
		Connection conexion = null;
		
		String sentenciaGuardar = ("INSERT INTO Usuario (cod, nombre, contraseña, puntuación) VALUES(?, ?, ?, ?)");
		
		try {
			conexion = ConnectDB.conectar();
			ps = conexion.prepareStatement(sentenciaGuardar);
			ps.setInt(1, cod);
			ps.setString(2, nombre);
			ps.setString(3, password);
			ps.setInt(4, puntuacion);
			
			resultado = ps.executeUpdate();
			ps.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return resultado;
	}
}
