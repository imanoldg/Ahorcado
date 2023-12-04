package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
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

import io.CargarPalabras;

public class VentanaModoClasico extends JFrame{
	
	public static JPanel crearTeclado() {
		JPanel panelTeclado = new JPanel();
		panelTeclado.setLayout(new GridLayout(3,10));
		
		
		
		for (int i = 65; i < 91; i++) {
			if (i == 79) {
				JButton boton = new JButton ("Ñ");
				panelTeclado.add(boton);
			}
			char num = (char)i;
			
			JButton boton = new JButton (num + "");
			panelTeclado.add(boton);
			
			boton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						String palabra = ocultarPalabra();
						int errores = 0;
						for (int j = 0; j < palabra.length(); j++) {
							
							if(boton.getText().charAt(0) == palabra.charAt(j)) {
								palabra.replace(palabra.charAt(j), boton.getText().charAt(0));
								boton.setBackground(Color.GREEN);
								boton.setEnabled(false);
							} else {
								boton.setEnabled(false);
								boton.setBackground(Color.red);
								errores++;
							}
							
						}
						
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			});
			
		}
		
		return panelTeclado;
	}
	
	public static String ocultarPalabra() throws FileNotFoundException {
        List<String> listaPalabras = CargarPalabras.cargarPalabras("resources/data/palabras.csv") ;
        
        Random aleatorio = new Random();
		int numeroAleatorio = aleatorio.nextInt(listaPalabras.size());
		
		String palabra = listaPalabras.get(numeroAleatorio).toUpperCase();
		
		int longitud = palabra.length();
        StringBuilder cadenaOculta = new StringBuilder();

        for (int i = 0; i < longitud; i++) {
            cadenaOculta.append(" _ ");
        }

        return cadenaOculta.toString();
    }
	
	private JButton botonSalir = new JButton("  Volver al selector de modo  ");
	private JButton botonPalabraNueva = new JButton("  Palabra Nueva  ");
	private JButton botonResolver = new JButton("  Resolver  ");
	
	
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
		JLabel palabraOculta = new JLabel(ocultarPalabra());
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
	}
	
}
