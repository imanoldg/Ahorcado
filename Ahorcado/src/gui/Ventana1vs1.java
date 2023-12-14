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
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import io.CargarPalabras;

public class Ventana1vs1 extends VentanaModoClasico {

	public static int erroresDerecha = 0;

	public static JPanel panelArribaIzquierda = panelArriba;
	public static JPanel panelIzquierdaIzquierda = panelIzquierda;
	public static JPanel panelAbecedarioIzquierda = panelAbecedario;
	
	public static String palabraSeleccionadaDerecha = SeleccionarPalabra();
	public static StringBuilder textoLabelDerecha = ocultarPalabra(palabraSeleccionadaDerecha);
	public static List<Character> letrasPalabraDerecha = new ArrayList<>(añadirLetras());
	public static JLabel palabraOcultaDerecha = new JLabel(textoLabelDerecha.toString());
	public static JPanel panelArribaDerecha = new JPanel();
	public static JPanel panelIzquierdaDerecha = new JPanel();
	public static JPanel panelDerechaDerecha = new JPanel();
	public static JPanel panelAbecedarioDerecha = new JPanel();

	public JButton botonListoIzquierda = botonPalabraNueva;

	public JButton botonSalirDerecha = new JButton("  Volver al selector de modo  ");
	public JButton botonListoDerecha = new JButton("  Listo  ");
	public JButton botonResolverDerecha = new JButton("  Resolver  ");

	public static int contador = 0;

	class BotonIzquierdaListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JButton boton = (JButton) e.getSource();

			for (int j = 0; j < palabraSeleccionadaDerecha.length(); j++) {

				if (boton.getText().charAt(0) == palabraSeleccionadaDerecha.charAt(j)) {
					textoLabelDerecha.replace(j, j + 1, boton.getText());
					palabraOcultaDerecha.setText(textoLabelDerecha.toString());

					if (letrasPalabraDerecha.contains(boton.getText().charAt(0))) {
						boton.setBackground(Color.GREEN);
						boton.setEnabled(false);
					}

				} else if (palabraSeleccionadaDerecha.charAt(j) != boton.getText().charAt(0)
						&& boton.getBackground() != Color.GREEN) {
					boton.setEnabled(false);
					boton.setBackground(Color.RED);
				}

			}
			
			if (boton.getBackground() == Color.RED) {
				erroresDerecha++;
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

	public Ventana1vs1() throws FileNotFoundException {
		super();

		// Para hacer esto he tenido ayuda de este articulo del foro:
		// https://stackoverflow.com/questions/64526090/remove-an-actionlistener-from-jbutton
		ActionListener[] listenersPalabraNueva = botonPalabraNueva.getActionListeners();

		for (ActionListener listener : listenersPalabraNueva) {
			botonPalabraNueva.removeActionListener(listener);
		}

		botonListoIzquierda.setText("Listo");

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
		JLabel erroresDerecha = new JLabel("ERRORES:");
		JLabel palabraDerecha = new JLabel("PALABRA OCULTA:");
		contadorErroresDerecha.setHorizontalAlignment(SwingConstants.CENTER);
		erroresDerecha.setHorizontalAlignment(SwingConstants.CENTER);
		palabraOcultaDerecha.setHorizontalAlignment(SwingConstants.CENTER);
		palabraDerecha.setHorizontalAlignment(SwingConstants.CENTER);

		botonSalirDerecha.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaSelectorModo();
				dispose();
			}
		});

		botonResolverDerecha.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaResolver();

			}
		});

		botonListoIzquierda.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				contador++;

				if (contador % 2 == 0) {
					panelAbecedarioDerecha.setVisible(false);
					botonListoDerecha.setVisible(false);
					botonResolverDerecha.setVisible(false);
					botonSalirDerecha.setVisible(false);

					panelAbecedarioIzquierda.setVisible(true);
					botonListoIzquierda.setVisible(true);
					botonResolver.setVisible(true);
					botonSalir.setVisible(true);
				} else {
					panelAbecedarioIzquierda.setVisible(false);
					botonListoIzquierda.setVisible(false);
					botonResolver.setVisible(false);
					botonSalir.setVisible(false);

					panelAbecedarioDerecha.setVisible(true);
					botonListoDerecha.setVisible(true);
					botonResolverDerecha.setVisible(true);
					botonSalirDerecha.setVisible(true);
				}

			}
		});

		botonListoDerecha.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				contador++;

				if (contador % 2 == 0) {
					panelAbecedarioDerecha.setVisible(false);
					botonListoDerecha.setVisible(false);
					botonResolverDerecha.setVisible(false);
					botonSalirDerecha.setVisible(false);

					panelAbecedarioIzquierda.setVisible(true);
					botonListoIzquierda.setVisible(true);
					botonResolver.setVisible(true);
					botonSalir.setVisible(true);
				} else {
					panelAbecedarioIzquierda.setVisible(false);
					botonListoIzquierda.setVisible(false);
					botonResolver.setVisible(false);
					botonSalir.setVisible(false);

					panelAbecedarioDerecha.setVisible(true);
					botonListoDerecha.setVisible(true);
					botonResolverDerecha.setVisible(true);
					botonSalirDerecha.setVisible(true);
				}

			}
		});

		panelAbecedarioDerecha.setVisible(false);
		botonListoDerecha.setVisible(false);
		botonResolverDerecha.setVisible(false);
		botonSalirDerecha.setVisible(false);

		panelAbecedarioIzquierda.setVisible(true);
		botonListoIzquierda.setVisible(true);

		panelArribaIzquierda.add(panelIzquierdaIzquierda, BorderLayout.WEST);
		panelArribaIzquierda.add(panelDerechaIzquierda, BorderLayout.EAST);

		panelGeneralIzquierda.add(panelArribaIzquierda, BorderLayout.NORTH);
		panelGeneralIzquierda.add(panelAbecedarioIzquierda, BorderLayout.SOUTH);

		panelIzquierdaDerecha.add(botonListoDerecha);
		panelIzquierdaDerecha.add(botonSalirDerecha);
		panelIzquierdaDerecha.add(botonResolverDerecha);
		panelIzquierdaDerecha.add(palabraDerecha);
		panelIzquierdaDerecha.add(palabraOcultaDerecha);
		panelIzquierdaDerecha.add(erroresDerecha);
		panelIzquierdaDerecha.add(contadorErroresDerecha);

		panelArribaDerecha.add(panelIzquierdaDerecha, BorderLayout.WEST);
		panelArribaDerecha.add(panelDerechaDerecha, BorderLayout.EAST);

		panelGeneralDerecha.add(panelArribaDerecha, BorderLayout.NORTH);
		panelGeneralDerecha.add(panelAbecedarioDerecha, BorderLayout.SOUTH);

		panelGeneral1vs1.add(panelGeneralDerecha, BorderLayout.EAST);
		panelGeneral1vs1.add(panelGeneralIzquierda, BorderLayout.WEST);

		setTitle("Modo 1 vs 1");
		setVisible(true);
	}

	public static void main(String[] args) throws FileNotFoundException {
		new Ventana1vs1();
	}
}