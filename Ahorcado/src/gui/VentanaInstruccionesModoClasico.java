package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaInstruccionesModoClasico extends JFrame {
	public VentanaInstruccionesModoClasico() {
		JLabel instrucciones = new JLabel("INSTRUCCIONES MODO CLASICO");
		
		JPanel panel= new JPanel(); 
		
		panel.add(instrucciones);
		
		this.add(panel);
		this.setTitle("Instrucciones del Modo Contrarreloj");
		this.setSize(800, 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
	}
	public static void main(String[] args) {
		new VentanaInstruccionesModoClasico();
	}
}
