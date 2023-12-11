package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeListener;
import java.io.FileNotFoundException;

import javax.swing.Action;
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
import javax.swing.SwingUtilities;
import javax.swing.event.MenuKeyEvent;
import javax.swing.event.MenuKeyListener;

import domain.Usuario;
import io.CargarPalabras;

public class VentanaModoContrarreloj extends VentanaModoClasico{

	private int contador;
	private Thread hilo;
	private boolean ejecutarHilo;
	
	public VentanaModoContrarreloj() throws FileNotFoundException {		

		contador = 60;
		JLabel etiqueta = new JLabel();
		etiqueta.setHorizontalAlignment(SwingConstants.CENTER);//esta linea la he sacado buscando en la API como poner un texto centrado en una JLabel 
															  //(https://docs.oracle.com/en/java/javase/17/docs/api/java.desktop/javax/swing/JLabel.html#setHorizontalAlignment(int))
		//HILO PARA EL CRONOMETRO
		hilo = new Thread() {
			public void run(){
				while (ejecutarHilo) {
					contador--;
					etiqueta.setText("Tiempo restante: " + contador + " segundos") ; // usar invoke later
					if (contador == 0) {
						ejecutarHilo = false;
					}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						System.out.println("Crono parado");
					}
				}
			}
		};
		ejecutarHilo = true;
		hilo.start();
		
		panelIzquierda.add(etiqueta);
		setTitle("Modo Contrarreloj");
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		new VentanaModoContrarreloj();
	}
}
