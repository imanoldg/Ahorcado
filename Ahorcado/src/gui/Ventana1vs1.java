package gui;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ventana1vs1 extends JFrame{
	public Ventana1vs1() {
		JPanel panel= new JPanel(); 
		
		
		this.add(panel);
		this.setTitle("Selector de Modo de Juego");
		this.setSize(800, 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
	
	}
}
