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
import gui.VentanaModoClasico.BotonActionListener;
import io.CargarPalabras;

public class VentanaModoMuerteSubita extends VentanaModoClasico {

	private static int adivinadas = 0;
	public static JLabel adivinadasLabel = new JLabel("Palabras adivinadas: " + adivinadas);
	private int errores = 0;
	

	private void ReiniciarJuego() {
		palabraSeleccionada = SeleccionarPalabra();
		textoLabel = ocultarPalabra(palabraSeleccionada);
		letrasPalabra.clear();
		letrasPalabra.addAll(añadirLetras());
		palabraOculta.setText(textoLabel.toString());;
		panelAbecedario.removeAll();
		panelAbecedario.add(crearTeclado(new BotonSubitaListener()));
	}
	
	public class BotonSubitaListener implements ActionListener {

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
					errores++;
				}

			}
			
			if (hasGanado()) {
				ReiniciarJuego();
				adivinadas++;
				adivinadasLabel.setText("Palabras adivinadas: " + adivinadas);
			}
			
			if (hasPerdido()) {
				new VentanaHasPerdido();
			}
			
			
		}

	}

	public VentanaModoMuerteSubita() throws FileNotFoundException {
		super();
		adivinadasLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panelIzquierda.setLayout(new GridLayout(8, 1));

		panelAbecedario.removeAll();
		panelAbecedario.add(crearTeclado(new BotonSubitaListener()));

		System.out.println(letrasPalabra);
		panelIzquierda.add(adivinadasLabel);

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
