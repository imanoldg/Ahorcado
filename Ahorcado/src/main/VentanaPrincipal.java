package main;

import javax.swing.SwingUtilities;
import gui.VentanaUsuarios;

public class VentanaPrincipal {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new VentanaUsuarios();
				
			}
		});
		
	}
}
