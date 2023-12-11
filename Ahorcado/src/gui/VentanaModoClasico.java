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

public class VentanaModoClasico extends JFrame{
	
	private JButton botonSalir = new JButton("  Volver al selector de modo  ");
	private JButton botonPalabraNueva = new JButton("  Palabra Nueva  ");
	private JButton botonResolver = new JButton("  Resolver  ");
	private static String palabraSeleccionada = SeleccionarPalabra();
	private static StringBuilder textoLabel = ocultarPalabra(palabraSeleccionada);
	private static List<Character> letrasPalabra = new ArrayList<>(añadirLetras());
	private static JLabel palabraOculta = new JLabel(textoLabel.toString());
	private static int errores = 5;
	
	public static String SeleccionarPalabra() {
        List<Palabra> listaPalabras = CargarPalabras.cargarPalabras("resources/data/palabras.csv") ;
        
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
	
	public JPanel crearTeclado() {
		JPanel panelTeclado = new JPanel();
		panelTeclado.setLayout(new GridLayout(3,10));
		
		
		
		for (int i = 65; i < 91; i++) {
			if (i == 79) {
				JButton boton = new JButton ("Ñ");
				panelTeclado.add(boton);
				boton.addActionListener(new BotonActionListener());
			}
			char num = (char)i;
			
			JButton boton = new JButton (num + "");
			panelTeclado.add(boton);
			
			boton.addActionListener(new BotonActionListener());
			
		}
		
		return panelTeclado;
	}
	
	public static boolean hasGanado() {
		return palabraOculta.getText().equals(palabraSeleccionada);
	}
	
	public static boolean hasPerdido() {
		return errores == 5;
	}
	
	private class BotonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton boton = (JButton) e.getSource();
			
			for (int j = 0; j < palabraSeleccionada.length(); j++) {
				
				if(boton.getText().charAt(0) == palabraSeleccionada.charAt(j) ) {
					textoLabel.replace(j, j + 1, boton.getText());
					palabraOculta.setText(textoLabel.toString());
					
					if (letrasPalabra.contains(boton.getText().charAt(0))) {
						boton.setBackground(Color.GREEN);
						boton.setEnabled(false);
					}
					
				} else if (palabraSeleccionada.charAt(j) != boton.getText().charAt(0) && boton.getBackground() != Color.GREEN){
					boton.setEnabled(false);
					boton.setBackground(Color.RED);
					errores++;
				}
				if (hasGanado()) {
					new VentanaHasGanadoClasico();
					
				}
				
				if (hasPerdido()) {
					new VentanaHasPerdido();
				}
			}
			
		}
		
	}
	
	
	public VentanaModoClasico() throws FileNotFoundException {		
		JPanel panelGeneral = new JPanel();
		panelGeneral.setLayout(new GridLayout(2,1));
		JPanel panelArriba = new JPanel();
		panelArriba.setLayout(new GridLayout(1,2));
		JPanel panelIzquierda = new JPanel();
		panelIzquierda.setLayout(new GridLayout(7,1));
		JPanel panelDerecha = new JPanel();
		JPanel panelAbecedario = new JPanel();
		panelAbecedario.setLayout(new GridLayout(1,1));
		panelAbecedario.add(crearTeclado());
		
		JLabel contadorErrores = new JLabel();
		JLabel errores = new JLabel("ERRORES:");
		JLabel palabra = new JLabel("PALABRA OCULTA:");
		contadorErrores.setHorizontalAlignment(SwingConstants.CENTER);
		errores.setHorizontalAlignment(SwingConstants.CENTER);
		palabraOculta.setHorizontalAlignment(SwingConstants.CENTER);
		palabra.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		
		//BARRA DE MENU
		JMenuBar menu = new JMenuBar();
		JMenu juego = new JMenu("Juego");
		
		JMenu opciones = new JMenu("Opciones");
		
		JMenuItem cerrarSesion = new JMenuItem("Cerrar Sesion");
		JMenuItem cambiarFondo = new JMenuItem("Cambiar fondo del Juego");
		JMenuItem ranking = new JMenu("Ranking");
		JMenuItem instrucciones = new JMenu("Instrucciones");
		
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
		
		botonSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaSelectorModo();
				dispose();
			}
		});
		
		botonResolver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaResolver();
				
			}
		});
		
		
		panelIzquierda.add(botonPalabraNueva);
		panelIzquierda.add(botonSalir);
		panelIzquierda.add(botonResolver);
		panelIzquierda.add(palabra);
		panelIzquierda.add(palabraOculta);
		panelIzquierda.add(errores);
		panelIzquierda.add(contadorErrores);
		
		
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
