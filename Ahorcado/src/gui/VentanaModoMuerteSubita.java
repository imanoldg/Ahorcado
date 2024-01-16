package gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class VentanaModoMuerteSubita extends VentanaModoClasico {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static int adivinadas = 0;
	public static JLabel adivinadasLabel = new JLabel("Palabras adivinadas: " + adivinadas);
	
	private int puntuacionSubita = 0;

	//Metodo para reiniciar le Modo Muerte Subita
	public void ReiniciarJuego() {
		palabraSeleccionada = SeleccionarPalabra();
		textoLabel = ocultarPalabra(palabraSeleccionada.getPalabra());
		letrasPalabra.clear();
		letrasPalabra.addAll(añadirLetras());
		palabraOculta.setText(textoLabel.toString());;
		panelAbecedario.removeAll();
		panelAbecedario.add(crearTeclado(new BotonSubitaListener()));
	}
	
	//Action Listener de los botones del teclado
	public class BotonSubitaListener implements ActionListener {

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
				ReiniciarJuego();
				adivinadas++;
				adivinadasLabel.setText("Palabras adivinadas: " + adivinadas);
				
				puntuacionSubita++;
				
			}
			
			if (hasPerdido()) {
				new VentanaHasPerdidoSubita();
				contadorErrores = 0;
				errores.setText("ERRORES: " + contadorErrores);
				adivinadas = 0;
				adivinadasLabel.setText("Palabras adivinadas: " + adivinadas);
				
				if(puntuacionSubita > usuarioJugando.getPuntuacionSubita()) {
					usuarioJugando.setPuntuacionSubita(puntuacionSubita);
					metodos.actualizarPuntuacion(usuarioJugando);
				}
				
				dispose();
			}
			
			
		}

	}

	//Inicializacion de la ventana
	public VentanaModoMuerteSubita() throws FileNotFoundException {
		
		adivinadasLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panelIzquierda.setLayout(new GridLayout(8, 1));

		panelAbecedario.removeAll();
		panelAbecedario.add(crearTeclado(new BotonSubitaListener()));

		System.out.println(letrasPalabra);
		panelIzquierda.add(adivinadasLabel);

		setVisible(true);
		setTitle("Modo Muerte Súbita");

		ActionListener[] listeners = botonResolver.getActionListeners();
		
		for (ActionListener actionListener : listeners) {
			botonResolver.removeActionListener(actionListener);
		}
		
		MouseListener[] mouseListenersInstrucciones = instrucciones.getMouseListeners();
		MouseListener[] mouseListenersRanking = ranking.getMouseListeners();
		
		for (MouseListener mouseListener : mouseListenersInstrucciones) {
			instrucciones.removeMouseListener(mouseListener);
		}
		
		for (MouseListener mouseListener : mouseListenersRanking) {
			ranking.removeMouseListener(mouseListener);
		}
		
		instrucciones.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				new VentanaInstruccionesModoMuerteSubita();
				
			}
		});
		
		ranking.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				new VentanaRankingSubita();
				
			}
		});
	}

}
