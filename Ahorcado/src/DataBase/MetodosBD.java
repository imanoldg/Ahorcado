package DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import domain.Usuario;
import gui.VentanaUsuarios;
import io.LoggerReg;

// he aprendido a guardar usuarios en la base de datos gracias a unos videos de YT: https://www.youtube.com/watch?v=V2-1AEHfLlk&ab_channel=GoCodex

public class MetodosBD {
	
	public static ConnectDB conexion = new ConnectDB();
	private static Logger log = LoggerReg.ejecutarLogger();
	
	public static PreparedStatement ps;
	public static ResultSet resultado;
	public static String sql;
	public static int resultadoNumero = 0;

	
	public int guardar(int cod, String nombre, String password, int puntuacionClasica, int puntuacionContrarreloj, int puntuacionSubita) {
		int resultado = 0;
		Connection conexion = null;
		
		 if (existeNombre(nombre)) {  
		        return resultado;
		    }
		
		String sentenciaGuardar = ("INSERT INTO Usuario (cod, nombre, contraseña, puntuacionClasico, puntuacionContrarreloj, puntuacionSubita) VALUES(?, ?, ?, ?, ?, ?) ;");
		
		try {
			conexion = ConnectDB.conectar();
			ps = conexion.prepareStatement(sentenciaGuardar);
			ps.setInt(1, cod);
			ps.setString(2, nombre);
			ps.setString(3, password);
			ps.setInt(4, puntuacionClasica);
			ps.setInt(5, puntuacionContrarreloj);
			ps.setInt(6, puntuacionSubita);
			
			resultado = ps.executeUpdate();
			conexion.close();
			
			log.info("Usuario guardado correctamente");
		} catch (Exception e) {
			log.warning(String.format("%s   ->  Error guardando el usuario: %s ", nombre, e.getMessage()));
		}
		
		return resultado;
	}
	
	public static int borrarUsuario(String usuario) {
		int usuarioBorrado = 0;
		Connection conexion = null;
		
		String consulta = ("DELETE FROM Usuario WHERE nombre = ? ;");
	
		try {
			conexion = ConnectDB.conectar();
			ps = conexion.prepareStatement(consulta);
			ps.setString(1, usuario);
			
			usuarioBorrado = ps.executeUpdate();
			ps.close();
			conexion.close();
			
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
			String consulta = ("SELECT cod FROM Usuario WHERE cod = '" + randomCod + "' ;");
			ps = conexion.prepareStatement(consulta);
			ps.setInt(1, randomCod);
			resultado = ps.executeQuery();
			
			ps.close();
			conexion.close();
			log.info("Codigo aleatorio generado");
		} catch (Exception e) {
			log.warning(String.format("Error intenando generar codigo aleatorio: %s ;", e.getMessage()));;
		}
		
		return randomCod;
	}
	
	
	public static boolean existeCod(int codigo) {
		Connection conexion = null;
		
		try {
			conexion = ConnectDB.conectar();
			String consulta = "SELECT cod FROM Usuario WHERE cod = ? ;";
			ps = conexion.prepareStatement(consulta);
			ps.setInt(1, codigo);
			resultado = ps.executeQuery();
			
			ps.close();
			conexion.close();
			
			log.info("Codigo encontrado con exito");
			
			return resultado.next();
			
		} catch (Exception e) {
			log.warning(String.format("%s : Error encontrando el codigo: %s", codigo + " ;", e.getMessage()));
			return false;
		}
		
	}
	
	
	
	public boolean existeNombre(String nombre) {
		Connection conexion = null;
		
		try {
			conexion = ConnectDB.conectar();
			String consulta = "SELECT nombre FROM Usuario WHERE nombre = ? ;";
			ps = conexion.prepareStatement(consulta);
			ps.setString(1, nombre);
			resultado = ps.executeQuery();
			
			ps.close();
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
			String buscar = ("SELECT nombre, contraseña FROM Usuario WHERE nombre = '" + nombre + "' ;");
			ps = conn.prepareStatement(buscar);
			resultado = ps.executeQuery();
			
			if(resultado.next()) {
				String nombre1 = resultado.getString("nombre");
				String pass = resultado.getString("contraseña");
				usuarioBusqueda = (nombre1);

				ps.close();
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
			String sentenciaBuscarUsuario = ("SELECT nombre, contraseña FROM Usuario WHERE nombre = '" + usuario + "' AND contraseña = '" + pass + "' ;");
			ps = conexion.prepareStatement(sentenciaBuscarUsuario);
			
			resultado = ps.executeQuery();
			if(resultado.next()) {
				busquedaUsuario = usuario;
			}else {
				busquedaUsuario = "usuario no encontrado";
			}
			
			log.info("Usuario registrado encontrado con exito");
			
			ps.close();
			conexion.close();
		} catch (Exception e) {
			log.warning(String.format("Error buscando al usuario registrado '%s' : %s", usuario, e.getMessage()));
			
		}
		
		return busquedaUsuario;
	}
	
	public Usuario obtenerUsuario(String usuario) {
		
		Connection con = ConnectDB.conectar();
		
		try (Statement st = con.createStatement()){
			Usuario usuarioCargado = null;
			ResultSet rs = st.executeQuery(String.format("SELECT * FROM usuario WHERE nombre = '%s' ;", usuario));
			
			
			if(rs.next()) {
				int cod = rs.getInt("cod");
				String nombre = rs.getString("nombre");
				String contra = rs.getString("contraseña");
				int puntuacionClasico = rs.getInt("puntuacionClasico");
				int puntuacionContrarreloj = rs.getInt("puntuacionContrarreloj");
				int puntuacionSubita = rs.getInt("puntuacionSubita");
				
				usuarioCargado = new Usuario(cod, nombre, contra, puntuacionClasico, puntuacionContrarreloj, puntuacionSubita);
			} else {
				System.out.println("Usuario no encontrado");;
			}
			
			rs.close();
			st.close();
			con.close();
			
			return usuarioCargado;
		} catch (SQLException e) {
			log.warning(String.format("Error intentando cargar el usuario %s : %s", usuario, e.getMessage()));
			return null;
		}
		
		
	}
	
	
	public Map<Integer, Usuario> obtenerListaUsuarios(){
		Connection con = ConnectDB.conectar();
		
		Map<Integer, Usuario> mapaUsuarios = new HashMap<>();
		
		try (Statement st = con.createStatement()){
			ResultSet rs = st.executeQuery("SELECT * FROM usuario");
			
			Usuario usuario = null;
			
			while(rs.next()) {
				int cod = rs.getInt("cod");
				String nombre = rs.getString("nombre");
				String contra = rs.getString("contraseña");
				int puntuacionClasico = rs.getInt("puntuacionClasico");
				int puntuacionContrarreloj = rs.getInt("puntuacionContrarreloj");
				int puntuacionSubita = rs.getInt("puntuacionSubita");
				
				usuario = new Usuario(cod, nombre, contra, puntuacionClasico, puntuacionContrarreloj, puntuacionSubita);
				
				if(!mapaUsuarios.containsKey(cod)) {
					mapaUsuarios.put(cod, usuario);
				}
			}
			
		} catch (SQLException e) {
			log.warning(String.format("Error al cargar la lista de usuarios: %s", e.getMessage()));;
		}
		
		return mapaUsuarios;
	}
	
	public void actualizarPuntuacion(Usuario u) {
		
		
		try (Connection con = ConnectDB.conectar();
			PreparedStatement st = con.prepareStatement("UPDATE usuario SET puntuacionClasico = puntuacionClasico + ?, puntuacionContrarreloj = puntuacionContrarreloj + ?, puntuacionSubita = ? WHERE cod = ?")){
			st.setInt(1, u.getPuntuacionClasico());
			st.setInt(2, u.getPuntuacionContrarreloj());
			st.setInt(3, u.getPuntuacionSubita());
			st.setInt(4, u.getCod());
			
			st.executeUpdate();
			
			log.info("Puntuacion actualizada con exito");
			
		} catch (SQLException e) {
			log.warning(String.format("Error actualizando las puntuaciones: %s", e.getMessage()));
		}
	}
	
}
