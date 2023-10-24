package gui;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class VentanaInstruccionesModoContrarreloj extends JFrame{
	
	public VentanaInstruccionesModoContrarreloj() {
		JLabel instrucciones = new JLabel("<html><body>Este programa generara aleatoriamente una palabra "
				+ "pero aparecera con espacios vacíos donde <br> deben ir los caracteres que la forman, "
				+ "tu tendrás que adivinarla. Necesitarás adivinar la palabra con <br> la menor cantidad de letras posibles"
				+ " para evitar ser 'ahorcado'. <html><body>");
		
		instrucciones.setPreferredSize(new Dimension(800,600));
		instrucciones.setHorizontalAlignment(SwingConstants.CENTER);
		
		JMenuBar barraTitulo = new JMenuBar();
		JMenu titulo = new JMenu("INSTRUCCIONES MODO CLÁSICO");
		barraTitulo.add(titulo);
		
		
		this.add(instrucciones);
		this.setJMenuBar(barraTitulo);
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
