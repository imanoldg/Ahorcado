package DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Logger;

import io.LoggerReg;

// he aprendido ha guardar usuarios en la base de datos gracias a unos videos de YT: https://www.youtube.com/watch?v=V2-1AEHfLlk&ab_channel=GoCodex

public class MetodosBD {
	
	public static ConnectDB conexion = new ConnectDB();
	private static Logger log = LoggerReg.ejecutarLogger();
	
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
			
			log.info("Usuario guardado correctamente");
		} catch (Exception e) {
			log.warning(String.format("%s   ->  Error guardando el usuario: %s", nombre, e.getMessage()));
		}
		
		return resultado;
	}
	
	public static int borrarUsuario(String usuario) {
		int usuarioBorrado = 0;
		Connection conexion = null;
		
		String consulta = ("DELETE FROM Usuario WHERE nombre = ?");
	
		try {
			conexion = ConnectDB.conectar();
			ps = conexion.prepareStatement(consulta);
			ps.setString(1, usuario);
			
			usuarioBorrado = ps.executeUpdate();
			ps.close();
			
			log.info("Usuario borrado");
			
		} catch (Exception e) {
			log.warning(String.format("Error borrando el usuario %s : %s", usuario, e.getMessage()));
		}
		
		return usuarioBorrado;
		
	}
	
	public static int generarCod() {
		double numero = Math.random() * 9000;
		return (int) numero;
	}
	
	public static int generarNuevoCod(int randomCod) {
		Connection conexion = null;
		
		while (existeCod(randomCod)) {
			if (existeCod(randomCod)) {
				randomCod = generarCod();
			}else {
				break;
			}
		}
		
		try {
			conexion = ConnectDB.conectar();
			String consulta = ("SELECT cod FROM Usuario WHERE cod = '" + randomCod + "'");
			ps = conexion.prepareStatement(consulta);
			ps.setInt(1, randomCod);
			resultado = ps.executeQuery();
			
			conexion.close();
			log.info("Codigo aleatorio generado");
		} catch (Exception e) {
			log.warning(String.format("Error intenando generar codigo aleatorio: %s", e.getMessage()));;
		}
		
		return randomCod;
	}
	
	
	public static boolean existeCod(int codigo) {
		Connection conexion = null;
		
		try {
			conexion = ConnectDB.conectar();
			String consulta = "SELECT cod FROM Usuario WHERE cod = ?";
			ps = conexion.prepareStatement(consulta);
			ps.setInt(1, codigo);
			resultado = ps.executeQuery();
			
			conexion.close();
			
			log.info("Codigo encontrado con exito");
			
			return resultado.next();
			
		} catch (Exception e) {
			log.warning(String.format("%s : Error encontrando el codigo: %s", codigo + "", e.getMessage()));
			return false;
		}
		
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
			
			log.info("Nombre encontrado con exito");
			return resultado.next();
			
		} catch (Exception e) {
			log.warning(String.format("%s : Error encontrando el nombre: %s", nombre, e.getMessage()));
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
				usuarioBusqueda = (nombre1);

				conn.close();
			}
			
			log.info("Usuario encontrado con exito");
			
		} catch (Exception e) {
			
			log.warning(String.format("%s : Error encontrando el usuario: %s", nombre, e.getMessage()));
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
				busquedaUsuario = usuario;
			}else {
				busquedaUsuario = "usuario no encontrado";
			}
			
			log.info("Usuario registrado encontrado con exito");
			
			conexion.close();
		} catch (Exception e) {
			log.warning(String.format("Error buscando al usuario registrado '%s' : %s", usuario, e.getMessage()));
			
		}
		
		return busquedaUsuario;
	}
	
	
}
