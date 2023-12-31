package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import domain.Palabra;
import io.CargarPalabras;

public class VentanaModoClasico extends JFrame {

	protected  ImageIcon Ahorcado_STAGE0 = new ImageIcon("resources/images/Hangman_Picture_STAGE0.png");
	protected  ImageIcon Ahorcado_STAGE1 = new ImageIcon("resources/images/Hangman_Picture_STAGE1.png");
	protected  ImageIcon Ahorcado_STAGE2 = new ImageIcon("resources/images/Hangman_Picture_STAGE2.png");
	protected  ImageIcon Ahorcado_STAGE3 = new ImageIcon("resources/images/Hangman_Picture_STAGE3.png");
	protected  ImageIcon Ahorcado_STAGE4 = new ImageIcon("resources/images/Hangman_Picture_STAGE4.png");
	protected  ImageIcon Ahorcado_STAGE5 = new ImageIcon("resources/images/Hangman_Picture_STAGE5.png");
	protected  ImageIcon Ahorcado_STAGE6 = new ImageIcon("resources/images/Hangman_Picture_STAGE6.png");

	protected  JLabel etiquetaAhorcado = new JLabel(Ahorcado_STAGE0);
	
	protected static int contadorErrores = 0;
	protected static JButton botonPalabraNueva = new JButton("  Palabra Nueva  ");
	protected static JButton botonResolver = new JButton("  Resolver  ");
	protected static String palabraSeleccionada = SeleccionarPalabra();
	protected static StringBuilder textoLabel = ocultarPalabra(palabraSeleccionada);
	protected static List<Character> letrasPalabra = new ArrayList<>(añadirLetras());
	protected static JLabel palabraOculta = new JLabel(textoLabel.toString());
	protected static JLabel errores = new JLabel("ERRORES: " + contadorErrores);
	protected static JLabel palabra = new JLabel("PALABRA OCULTA:");
	

	protected static JPanel panelGeneral = new JPanel();
	protected static JPanel panelArriba = new JPanel();
	protected static JPanel panelIzquierda = new JPanel();
	protected static JPanel panelAbecedario = new JPanel();
	protected static JPanel panelDerecha = new JPanel();

	protected static JMenuBar menu = new JMenuBar();
	protected static JMenu juego = new JMenu("Juego");

	protected static JMenu opciones = new JMenu("Opciones");

	protected static JMenuItem cerrarSesion = new JMenuItem("Cerrar Sesion");
	protected static JMenuItem cambiarFondo = new JMenuItem("Cambiar fondo del Juego");
	protected static JMenuItem ranking = new JMenu("Ranking");
	protected static JMenuItem instrucciones = new JMenu("Instrucciones");

	public static String SeleccionarPalabra() {
		List<Palabra> listaPalabras = CargarPalabras.cargarPalabras("resources/data/palabras.csv");

		Random aleatorio = new Random();
		int numeroAleatorio = aleatorio.nextInt(listaPalabras.size());

		String palabra = listaPalabras.get(numeroAleatorio).getPalabra().toUpperCase();

		return palabra;
	}

	public static List<Character> añadirLetras() {
		List<Character> lista = new ArrayList<>();

		for (int i = 0; i < palabraSeleccionada.length(); i++) {
			char letra = palabraSeleccionada.charAt(i);
			lista.add(letra);
		}

		return lista;
	}

	public static StringBuilder ocultarPalabra(String palabra) {
		int longitud = palabra.length();
		StringBuilder cadenaOculta = new StringBuilder("-".repeat(longitud));

		return cadenaOculta;
	}

	public static JPanel crearTeclado(ActionListener action) {
		JPanel panelTeclado = new JPanel();
		panelTeclado.setLayout(new GridLayout(3, 10));

		for (int i = 65; i < 91; i++) {
			if (i == 79) {
				JButton boton = new JButton("Ñ");
				panelTeclado.add(boton);
				boton.addActionListener(action);
			}
			char num = (char) i;

			JButton boton = new JButton(num + "");
			panelTeclado.add(boton);
			Color DefaultColor = boton.getBackground();

			boton.addActionListener(action);

			if (botonPalabraNueva.isSelected()) {
				boton.setBackground(DefaultColor);
			}

		}

		return panelTeclado;
	}

	public static boolean hasGanado() {
		if (palabraOculta.getText().equals(palabraSeleccionada)) {
			return true;
		}

		return false;
	}

	public static boolean hasPerdido() {
		if (contadorErrores == 6)
			return true;
		return false;
	}

	public class BotonActionListener implements ActionListener {

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
				new VentanaHasGanadoClasico();
				contadorErrores = 0;
				errores.setText("ERRORES: " + contadorErrores);
				dispose();

			}

			if (hasPerdido()) {
				new VentanaHasPerdidoClasico();
				contadorErrores = 0;
				errores.setText("ERRORES: " + contadorErrores);
				dispose();
			}

		}

	}

	protected VentanaModoClasico() throws FileNotFoundException {
		
		panelGeneral.setLayout(new GridLayout(2, 1));
		panelArriba.setLayout(new GridLayout(1, 2));
		panelIzquierda.setLayout(new GridLayout(7, 1));

		panelAbecedario.setLayout(new GridLayout(1, 1));
		panelAbecedario.add(crearTeclado(new BotonActionListener()));

		errores.setHorizontalAlignment(SwingConstants.CENTER);
		palabraOculta.setHorizontalAlignment(SwingConstants.CENTER);
		palabra.setHorizontalAlignment(SwingConstants.CENTER);

		// BARRA DE MENU

		juego.add(ranking);
		juego.add(instrucciones);
		opciones.add(cerrarSesion);
		opciones.add(cambiarFondo);

		menu.add(juego);
		menu.add(opciones);

		instrucciones.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				new VentanaInstruccionesModoClasico();

			}
		});

		cerrarSesion.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				new VentanaUsuarios();
				dispose();

			}
		});

		cambiarFondo.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				Color color = JColorChooser.showDialog(panelGeneral, "Paleta de colores", getForeground());

				if (color != null) {
					panelIzquierda.setBackground(color);
					panelDerecha.setBackground(color);
				}
			}
		});

		botonResolver.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaResolverClasico();
				dispose();

			}
		});

		botonPalabraNueva.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				palabraSeleccionada = SeleccionarPalabra();
				textoLabel = ocultarPalabra(palabraSeleccionada);
				letrasPalabra.clear();
				letrasPalabra.addAll(añadirLetras());
				palabraOculta.setText(textoLabel.toString());
				;
				panelAbecedario.removeAll();
				panelAbecedario.add(crearTeclado(new BotonActionListener()));
			}
		});

		panelIzquierda.add(botonPalabraNueva);
		panelIzquierda.add(botonResolver);
		panelIzquierda.add(palabra);
		panelIzquierda.add(palabraOculta);
		panelIzquierda.add(errores);
		
		
		panelDerecha.add(etiquetaAhorcado);
		panelArriba.add(panelIzquierda, BorderLayout.WEST);
		panelArriba.add(panelDerecha, BorderLayout.EAST);

		panelGeneral.add(panelArriba, BorderLayout.NORTH);
		panelGeneral.add(panelAbecedario, BorderLayout.SOUTH);

		this.add(panelGeneral, BorderLayout.CENTER);
		this.setJMenuBar(menu);
		this.setTitle("Modo Clásico");
		this.setSize(1000, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	}

	public static void main(String[] args) throws FileNotFoundException {
		new VentanaModoClasico();
		System.out.println(letrasPalabra);
	}

}
