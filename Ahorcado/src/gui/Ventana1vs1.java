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
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import domain.Palabra;

public class Ventana1vs1 extends VentanaModoClasico {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static int erroresDerecha = 0;

	//Label del ahorcado del jugador 2
	private JLabel etiquetaAhorcado2 = new JLabel(Ahorcado_STAGE0);
	
	public static JPanel panelArribaIzquierda = panelArriba;
	public static JPanel panelIzquierdaIzquierda = panelIzquierda;
	public static JPanel panelAbecedarioIzquierda = panelAbecedario;
	public static JPanel panelDerechaIzquierda = panelDerecha;

	public static Palabra palabraSeleccionadaDerecha = SeleccionarPalabra();
	public static StringBuilder textoLabelDerecha = ocultarPalabra(palabraSeleccionadaDerecha.getPalabra());
	public static List<Character> letrasPalabraDerecha = new ArrayList<>(añadirLetras());
	public static JLabel palabraOcultaDerecha = new JLabel(textoLabelDerecha.toString());
	public static JPanel panelArribaDerecha = new JPanel();
	public static JPanel panelDerechaDerecha = new JPanel();
	public static JPanel panelIzquierdaDerecha = new JPanel();
	public static JPanel panelAbecedarioDerecha = new JPanel();
	public static JLabel erroresDerechaLabel = new JLabel("ERRORES: " + erroresDerecha);


	public static int contador = 0;

	//Metodo para detectar si ha ganado
	public boolean hasPerdido1vs1() {
		if (erroresDerecha == 6)
			return true;
		return false;
	}

	//Metodo para detectar si ha perdido
	public boolean hasGanado1vs1() {
		if (palabraOcultaDerecha.getText().equals(palabraSeleccionadaDerecha.getPalabra())) {
			return true;
		}
		return false;
	}

	//ActionListener de los botones del teclado
	class BotonIzquierdaListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JButton boton = (JButton) e.getSource();
			contador++;

			if (contador % 2 == 0) {
				panelAbecedarioDerecha.setVisible(false);
				panelAbecedarioIzquierda.setVisible(true);
			} else {
				panelAbecedarioIzquierda.setVisible(false);
				panelAbecedarioDerecha.setVisible(true);
			}


			for (int j = 0; j < palabraSeleccionadaDerecha.length(); j++) {

				if (boton.getText().charAt(0) == palabraSeleccionadaDerecha.getPalabra().charAt(j)) {
					textoLabelDerecha.replace(j, j + 1, boton.getText());
					palabraOcultaDerecha.setText(textoLabelDerecha.toString());

					if (letrasPalabraDerecha.contains(boton.getText().charAt(0))) {
						boton.setBackground(Color.GREEN);
						boton.setEnabled(false);
					}

				} else if (palabraSeleccionadaDerecha.getPalabra().charAt(j) != boton.getText().charAt(0)
						&& boton.getBackground() != Color.GREEN) {
					boton.setEnabled(false);
					boton.setBackground(Color.RED);
				}

			}

			if (boton.getBackground() == Color.RED) {
				erroresDerecha++;
				erroresDerechaLabel.setText("ERRORES: " + erroresDerecha);
				
				if (erroresDerecha == 1) {
					etiquetaAhorcado2.setIcon(Ahorcado_STAGE1);
				}else if (erroresDerecha == 2) {
					etiquetaAhorcado2.setIcon(Ahorcado_STAGE2);
				} else if (erroresDerecha == 3) {
					etiquetaAhorcado2.setIcon(Ahorcado_STAGE3);
				} else if (erroresDerecha == 4) {
					etiquetaAhorcado2.setIcon(Ahorcado_STAGE4);
				} else if (erroresDerecha == 5) {
					etiquetaAhorcado2.setIcon(Ahorcado_STAGE5);
				} else{
					etiquetaAhorcado2.setIcon(Ahorcado_STAGE6);
				}
			}

			if (hasGanado1vs1()) {
				new VentanaHasGanado1vs1();
				contadorErrores = 0;
				erroresDerecha = 0;
				erroresDerechaLabel.setText("ERRORES: " + erroresDerecha);
				errores.setText("ERRORES: " + contadorErrores);
				dispose();

			}

			if (hasPerdido1vs1()) {
				new VentanaHasPerdido1vs1();
				contadorErrores = 0;
				erroresDerecha = 0;
				erroresDerechaLabel.setText("ERRORES: " + erroresDerecha);
				errores.setText("ERRORES: " + contadorErrores);
				dispose();
			}
		}

	}

	//Segundo ActionListener para el segundo teclado
	class BotonDerechaListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JButton boton = (JButton) e.getSource();
			contador++;

			if (contador % 2 == 0) {
				panelAbecedarioDerecha.setVisible(false);
				panelAbecedarioIzquierda.setVisible(true);
			} else {
				panelAbecedarioIzquierda.setVisible(false);
				panelAbecedarioDerecha.setVisible(true);
			}
			
			for (int j = 0; j < palabraSeleccionada.length(); j++) {

				if (boton.getText().charAt(0) == palabraSeleccionada.getPalabra().charAt(j)) {
					textoLabel.replace(j, j + 1, boton.getText());
					palabraOculta.setText(textoLabel.toString());

					if (letrasPalabra.contains(boton.getText().charAt(0))) {
						boton.setBackground(Color.GREEN);
						boton.setEnabled(false);
					}

				} else if (palabraSeleccionada.getPalabra().charAt(j) != boton.getText().charAt(0)
						&& boton.getBackground() != Color.GREEN) {
					boton.setEnabled(false);
					boton.setBackground(Color.RED);
				}

			}

			if (boton.getBackground() == Color.RED) {
				contadorErrores++;
				errores.setText("ERRORES: " + contadorErrores);
				
				if (contadorErrores == 1) {
					etiquetaAhorcado.setIcon(Ahorcado_STAGE1);
				}else if (contadorErrores == 2) {
					etiquetaAhorcado.setIcon(Ahorcado_STAGE2);
				} else if (contadorErrores == 3) {
					etiquetaAhorcado.setIcon(Ahorcado_STAGE3);
				} else if (contadorErrores == 4) {
					etiquetaAhorcado.setIcon(Ahorcado_STAGE4);
				} else if (contadorErrores == 5) {
					etiquetaAhorcado.setIcon(Ahorcado_STAGE5);
				} else{
					etiquetaAhorcado.setIcon(Ahorcado_STAGE6);
				}
			}

			if (hasGanado()) {
				new VentanaHasGanado1vs1();
				contadorErrores = 0;
				erroresDerecha = 0;
				erroresDerechaLabel.setText("ERRORES: " + erroresDerecha);
				errores.setText("ERRORES: " + contadorErrores);
				dispose();

			}

			if (hasPerdido()) {
				new VentanaHasPerdido1vs1();
				contadorErrores = 0;
				erroresDerecha = 0;
				erroresDerechaLabel.setText("ERRORES: " + erroresDerecha);
				errores.setText("ERRORES: " + contadorErrores);
				dispose();
			}
		}

	}

	//Inicializacion de la ventana
	public Ventana1vs1() throws FileNotFoundException {
		
		panelIzquierda.remove(botonResolver);
		panelIzquierda.remove(botonPalabraNueva);
		panelAbecedario.removeAll();
		panelAbecedario.add(crearTeclado(new BotonDerechaListener()));

		// Para hacer esto he tenido ayuda de este articulo del foro:
		// https://stackoverflow.com/questions/64526090/remove-an-actionlistener-from-jbutton
		ActionListener[] listenersPalabraNueva = botonPalabraNueva.getActionListeners();

		for (ActionListener listener : listenersPalabraNueva) {
			botonPalabraNueva.removeActionListener(listener);
		}

		MouseListener[] mouseListeners = instrucciones.getMouseListeners();

		for (MouseListener mouseListener : mouseListeners) {
			instrucciones.removeMouseListener(mouseListener);
		}

		instrucciones.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				new VentanaInstrucciones1vs1();

			}
		});


		JPanel panelGeneral1vs1 = panelGeneral;
		panelGeneral1vs1.setLayout(new GridLayout(1, 2));
		JPanel panelGeneralIzquierda = new JPanel();
		panelGeneralIzquierda.setLayout(new GridLayout(2, 1));
		panelArribaIzquierda.setLayout(new GridLayout(1, 2));
		panelIzquierdaIzquierda.setLayout(new GridLayout(7, 1));
		panelAbecedarioIzquierda.setLayout(new GridLayout(1, 0));
		JPanel panelDerechaIzquierda = new JPanel();
		JPanel panelGeneralDerecha = new JPanel();
		panelGeneralDerecha.setLayout(new GridLayout(2, 1));
		panelArribaDerecha.setLayout(new GridLayout(1, 2));
		panelIzquierdaDerecha.setLayout(new GridLayout(7, 1));
		panelAbecedarioDerecha.setLayout(new GridLayout(1, 0));
		panelAbecedarioDerecha.add(crearTeclado(new BotonIzquierdaListener()));

		JLabel contadorErroresDerecha = new JLabel();
		JLabel palabraDerecha = new JLabel("PALABRA OCULTA:");
		contadorErroresDerecha.setHorizontalAlignment(SwingConstants.CENTER);
		erroresDerechaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		palabraOcultaDerecha.setHorizontalAlignment(SwingConstants.CENTER);
		palabraDerecha.setHorizontalAlignment(SwingConstants.CENTER);

		panelAbecedarioDerecha.setVisible(false);
		panelAbecedarioIzquierda.setVisible(true);
		
		panelArribaIzquierda.add(panelIzquierdaIzquierda, BorderLayout.WEST);
		panelArribaIzquierda.add(panelDerechaIzquierda, BorderLayout.EAST);

		panelGeneralIzquierda.add(panelArribaIzquierda, BorderLayout.NORTH);
		panelGeneralIzquierda.add(panelAbecedarioIzquierda, BorderLayout.SOUTH);

		panelIzquierdaDerecha.add(palabraDerecha);
		panelIzquierdaDerecha.add(palabraOcultaDerecha);
		panelIzquierdaDerecha.add(erroresDerechaLabel);
		panelIzquierdaDerecha.add(contadorErroresDerecha);
		
		panelDerechaDerecha.add(etiquetaAhorcado2);

		panelArribaDerecha.add(panelIzquierdaDerecha, BorderLayout.WEST);
		panelArribaDerecha.add(panelDerechaDerecha, BorderLayout.EAST);

		panelGeneralDerecha.add(panelArribaDerecha, BorderLayout.NORTH);
		panelGeneralDerecha.add(panelAbecedarioDerecha, BorderLayout.SOUTH);

		panelGeneral1vs1.add(panelGeneralDerecha, BorderLayout.EAST);
		panelGeneral1vs1.add(panelGeneralIzquierda, BorderLayout.WEST);

		setTitle("Modo 1 vs 1");
		setVisible(true);
	}
}