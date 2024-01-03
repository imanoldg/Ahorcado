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
		
		 if (existeNombre(nombre)) {  
		        return resultado;
		    }
		
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
	
	private boolean existeNombre(String nombre) {
		Connection conexion = null;
		
		try {
			conexion = ConnectDB.conectar();
			String consulta = "SELECT nombre FROM Usuario WHERE nombre = ?";
			ps = conexion.prepareStatement(consulta);
			ps.setString(1, nombre);
			resultado = ps.executeQuery();
			
			conexion.close();
			
			return resultado.next();
			
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		
	}
	
	public static String buscarUsuario(String nombre) {
		String usuarioBusqueda = null;
		Connection conn = null;
		
		try {
			conn = ConnectDB.conectar();
			String buscar = ("SELECT nombre, contraseña FROM Usuario WHERE nombre = '" + nombre + "'");
			ps = conn.prepareStatement(buscar);
			resultado = ps.executeQuery();
			
			if(resultado.next()) {
				String nombre1 = resultado.getString("nombre");
				String pass = resultado.getString("contraseña");
				usuarioBusqueda = (nombre1 + "" + pass);

				conn.close();
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return usuarioBusqueda;
	}
	
	public static String registeredUser(String usuario, String pass) {
		String busquedaUsuario = null;
		Connection conexion = null;
		
		try {
			conexion = ConnectDB.conectar(); 
			String sentenciaBuscarUsuario = ("SELECT nombre, contraseña FROM Usuario WHERE nombre = '" + usuario + "' AND contraseña = '" + pass + "'");
			ps = conexion.prepareStatement(sentenciaBuscarUsuario);
			
			resultado = ps.executeQuery();
			if(resultado.next()) {
				busquedaUsuario = "usuario encontrado";
			}else {
				busquedaUsuario = "usuario no encontrado";
			}
			
			conexion.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return busquedaUsuario;
	}
}
