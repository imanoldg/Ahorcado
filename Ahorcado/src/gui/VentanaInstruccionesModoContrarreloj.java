package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaInstruccionesModoContrarreloj extends JFrame{
	
	public VentanaInstruccionesModoContrarreloj() {
		JLabel instrucciones = new JLabel("ES UNA PRUEBA");
		
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
		new VentanaInstruccionesModoContrarreloj();
	}
}
