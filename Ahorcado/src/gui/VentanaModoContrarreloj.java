package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import domain.Palabra.Dificultad;

public class VentanaModoContrarreloj extends VentanaModoClasico {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int contador;
	private Thread hilo;
	private boolean ejecutarHilo;
	
	public static int puntuacionContrarreloj = usuarioJugando.getPuntuacionContrarreloj();

	public static JLabel etiqueta = new JLabel();

	//ActionListener de los botones del teclado
	public class BotonContrarrelojListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton boton = (JButton) e.getSource();

			for (int j = 0; j < palabraSeleccionada.length(); j++) {

				if (boton.getText().charAt(0) == palabraSeleccionada.getPalabra().charAt(j)) {
					textoLabel.replace(j, j + 1, boton.getText());
					palabraOculta.setText(textoLabel.toString());

					if (letrasPalabra.contains(boton.getText().charAt(0))) {
						boton.setBackground(Color.GREEN);
						boton.setEnabled(false);
						contador = contador + 5;
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
				contador = contador - 5;
				
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
				new VentanaHasGanadoContrarreloj();
				contadorErrores = 0 ;
				errores.setText("ERRORES: " + contadorErrores);
				ejecutarHilo = false;
				contador = 60;
				
				if (palabraSeleccionada.getDificultad().equals(Dificultad.DIFICIL)) {
					puntuacionContrarreloj = puntuacionContrarreloj + 50 + palabraSeleccionada.getPalabra().length();
					usuarioJugando.setPuntuacionContrarreloj(puntuacionContrarreloj);
				} else {
					puntuacionContrarreloj = puntuacionContrarreloj + 25 + palabraSeleccionada.getPalabra().length();
					usuarioJugando.setPuntuacionContrarreloj(puntuacionContrarreloj);
				}
				
				dispose();
			}

			if (hasPerdido()) {
				new VentanaHasPerdidoContrarreloj();
				contadorErrores = 0;
				errores.setText("ERRORES: " + contadorErrores);
				ejecutarHilo = false;
				contador = 60;
				dispose();
			}

		}

	}

	//Inicializacion de la ventana
	public VentanaModoContrarreloj() throws FileNotFoundException {

		System.out.println(letrasPalabra);
		
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
						new VentanaHasPerdidoContrarreloj();
						dispose();
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

		MouseListener[] mouseListenersInstrucciones = instrucciones.getMouseListeners();
		MouseListener[] mouseListenersRanking = ranking.getMouseListeners();
		ActionListener[] listeners = botonResolver.getActionListeners();

		for (MouseListener mouseListener : mouseListenersInstrucciones) {
			instrucciones.removeMouseListener(mouseListener);
		}
		
		for (MouseListener mouseListener : mouseListenersRanking) {
			ranking.removeMouseListener(mouseListener);
		}

		for (ActionListener actionListener : listeners) {
			botonResolver.removeActionListener(actionListener);
		}

		instrucciones.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				new VentanaInstruccionesModoContrarreloj();

			}
		});
		
		ranking.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				new VentanaRankingContrarreloj();

			}
		});

		botonResolver.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaResolverContrarreloj();
				ejecutarHilo = false;
				contador = 60;
				dispose();

			}
		});

		panelIzquierda.add(etiqueta);
		setTitle("Modo Contrarreloj");
		setVisible(true);
	}

}
