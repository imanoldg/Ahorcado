package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import domain.Usuario;
import io.CargarPalabras;

public class VentanaModoMuerteSubita extends VentanaModoClasico{

	private static int adivinadas = 0;
	private static JLabel adivinadasLabel = new JLabel("Palabras adivinadas: " + adivinadas);
	private static int errores = 0;
	
	public VentanaModoMuerteSubita() throws FileNotFoundException {
		super();
		adivinadasLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panelIzquierda.setLayout(new GridLayout(8,1));
		
		System.out.println(letrasPalabra);
		panelIzquierda.add(adivinadasLabel);
		
		hasGanado(1, adivinadas);
		
		setVisible(true);
		setTitle("Modo Muerte Súbita");
	}
	
	public static void main(String[] args) {
			try {
				new VentanaModoMuerteSubita();
			} catch (FileNotFoundException e) {
				System.out.println("Error: Archivo de palabras no encontrado");
			}
		
	}
	
}
