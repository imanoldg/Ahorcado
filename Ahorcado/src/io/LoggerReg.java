package io;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.*;

import javax.swing.JOptionPane;


public class LoggerReg {

	private static Logger log = Logger.getLogger(LoggerReg.class.getName());
		
	public static Logger ejecutarLogger(){
		try (FileInputStream fis = new FileInputStream("conf/reg.properties")){
			LogManager.getLogManager().readConfiguration(fis);
				
		} catch (IOException e) {
			e.printStackTrace();
			log.log(Level.SEVERE, "lectura fallida");
			JOptionPane.showConfirmDialog(null, "no se ha podido leer fichero", "error", JOptionPane.PLAIN_MESSAGE);
		}
		
		return log;
	}

}
