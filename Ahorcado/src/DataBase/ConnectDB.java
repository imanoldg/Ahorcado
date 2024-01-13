package DataBase;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import io.LoggerReg;

public class ConnectDB {
	
	private static Logger log = Logger.getLogger(LoggerReg.class.getName());
	public static String url = "jdbc:sqlite:resources/db/Usuarios.db";
	public static String fn = "org.sqlite.JDBC";
	public static Connection conectar() {
		Connection conexion = null;
		
		try {
			Class.forName(fn);
			conexion = DriverManager.getConnection(url);
			System.out.println("conected");
			
			log.info("Conexion con la base de datos exitosa");
		} catch (ClassNotFoundException | SQLException e) {
			log.warning(String.format("Error conectando con la base de datos: %s", e.getMessage()));
		}
		
		
		
		return conexion;
	}
	
}

