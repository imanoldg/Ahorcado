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

	private static int errores = 5;

	private static String palabraSeleccionadaDerecha = SeleccionarPalabra();
	private static StringBuilder textoLabelDerecha = ocultarPalabra(palabraSeleccionadaDerecha);
	private static List<Character> letrasPalabraDerecha = new ArrayList<>(añadirLetras());
	private static JLabel palabraOcultaDerecha = new JLabel(textoLabelDerecha.toString());

	private JButton botonListoIzquierda = new JButton("  Listo  ");

	private JButton botonSalirDerecha = new JButton("  Volver al selector de modo  ");
	private JButton botonListoDerecha = new JButton("  Listo  ");
	private JButton botonResolverDerecha = new JButton("  Resolver  ");

	private static int contador = 0;

	public Ventana1vs1() throws FileNotFoundException {
		super();

		JPanel panelGeneral1vs1 = panelGeneral;
		panelGeneral1vs1.setLayout(new GridLayout(1, 2));

		JPanel panelGeneralIzquierda = new JPanel();
		panelGeneralIzquierda.setLayout(new GridLayout(2, 1));
		JPanel panelArribaIzquierda = panelArriba;
		panelArribaIzquierda.setLayout(new GridLayout(1, 2));
		JPanel panelIzquierdaIzquierda = panelIzquierda;
		panelIzquierdaIzquierda.setLayout(new GridLayout(7, 1));
		JPanel panelAbecedarioIzquierda = panelAbecedario;
		panelAbecedarioIzquierda.setLayout(new GridLayout(1, 0));
		JPanel panelDerechaIzquierda = new JPanel();

		JPanel panelGeneralDerecha = new JPanel();
		panelGeneralDerecha.setLayout(new GridLayout(2, 1));
		JPanel panelArribaDerecha = new JPanel();
		panelArribaDerecha.setLayout(new GridLayout(1, 2));
		JPanel panelIzquierdaDerecha = new JPanel();
		panelIzquierdaDerecha.setLayout(new GridLayout(7, 1));
		JPanel panelDerechaDerecha = new JPanel();
		JPanel panelAbecedarioDerecha = new JPanel();
		panelAbecedarioDerecha.setLayout(new GridLayout(1, 0));
		panelAbecedarioDerecha.add(crearTeclado());

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
				} else {
					panelAbecedarioIzquierda.setVisible(false);
					botonListoIzquierda.setVisible(false);

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
				} else {
					panelAbecedarioIzquierda.setVisible(false);
					botonListoIzquierda.setVisible(false);

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
		
		panelIzquierdaIzquierda.add(botonListoIzquierda);
		
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
	}

	public static void main(String[] args) throws FileNotFoundException {
		new Ventana1vs1();
	}
}