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

public class VentanaModoContrarreloj extends VentanaModoClasico {

	private int contadorErrores = 0;
	private int contador;
	private Thread hilo;
	private boolean ejecutarHilo;
	
	public static JLabel etiqueta = new JLabel();

	public class BotonContrarrelojListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton boton = (JButton) e.getSource();

			for (int j = 0; j < palabraSeleccionada.length(); j++) {

				if (boton.getText().charAt(0) == palabraSeleccionada.charAt(j)) {
					textoLabel.replace(j, j + 1, boton.getText());
					palabraOculta.setText(textoLabel.toString());

					if (letrasPalabra.contains(boton.getText().charAt(0))) {
						boton.setBackground(Color.GREEN);
						boton.setEnabled(false);
					}

				} else if (palabraSeleccionada.charAt(j) != boton.getText().charAt(0)
						&& boton.getBackground() != Color.GREEN) {
					boton.setEnabled(false);
					boton.setBackground(Color.RED);
				}

			}

			if (boton.getBackground() == Color.RED) {
				contadorErrores++;
			}
			
			if (hasGanado()) {
				new VentanaHasGanadoClasico();
				dispose();

			}

			if (hasPerdido()) {
				new VentanaHasPerdido();
				dispose();
			}

		}

	}

	public VentanaModoContrarreloj() throws FileNotFoundException {

		panelAbecedario.removeAll();
		panelAbecedario.add(crearTeclado(new BotonContrarrelojListener()));
		
		contador = 60;
		
		etiqueta.setHorizontalAlignment(SwingConstants.CENTER);// esta linea la he sacado buscando en la API como poner
																// un texto centrado en una JLabel
																// (https://docs.oracle.com/en/java/javase/17/docs/api/java.desktop/javax/swing/JLabel.html#setHorizontalAlignment(int))
		// HILO PARA EL CRONOMETRO
		hilo = new Thread() {
			public void run() {
				while (ejecutarHilo) {
					contador--;
					etiqueta.setText("Tiempo restante: " + contador + " segundos"); // usar invoke later
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
		
		botonPalabraNueva.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				contador = 60;
			}
		});
		
		MouseListener[] mouseListeners = instrucciones.getMouseListeners();
		
		for (MouseListener mouseListener : mouseListeners) {
			instrucciones.removeMouseListener(mouseListener);
		}
		
		instrucciones.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				new VentanaInstruccionesModoContrarreloj();
				
			}
		});
		
		panelIzquierda.add(etiqueta);
		setTitle("Modo Contrarreloj");
		setVisible(true);
	}

	public static void main(String[] args) throws FileNotFoundException {
		new VentanaModoContrarreloj();
		System.out.println(letrasPalabra);
	}
}
