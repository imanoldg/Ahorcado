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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import io.CargarPalabras;

public class Ventana1vs1 extends JFrame{
	
	private JButton botonSalirIzquierda = new JButton("  Volver al selector de modo  ");
	private JButton botonListoIzquierda = new JButton("  Listo  ");
	private JButton botonResolverIzquierda = new JButton("  Resolver  ");
	
	private JButton botonSalirDerecha = new JButton("  Volver al selector de modo  ");
	private JButton botonListoDerecha = new JButton("  Listo  ");
	private JButton botonResolverDerecha = new JButton("  Resolver  ");
	
	private static int contador = 0;
	
	public Ventana1vs1() throws FileNotFoundException {
		JPanel panelGeneral = new JPanel();
		panelGeneral.setLayout(new GridLayout(1,2));
		
		JPanel panelGeneralIzquierda = new JPanel();
		panelGeneralIzquierda.setLayout(new GridLayout(2,1));
		JPanel panelArribaIzquierda = new JPanel();
		panelArribaIzquierda.setLayout(new GridLayout(1,2));
		JPanel panelIzquierdaIzquierda = new JPanel();
		panelIzquierdaIzquierda.setLayout(new GridLayout(7,1));
		JPanel panelDerechaIzquierda = new JPanel();
		JPanel panelAbecedarioIzquierda = new JPanel();
		panelAbecedarioIzquierda.setLayout(new GridLayout(1,0));
		panelAbecedarioIzquierda.add(VentanaModoClasico.crearTeclado());
		
		JLabel contadorErroresIzquierda = new JLabel();
		JLabel erroresIzquierda = new JLabel("ERRORES:");
		JLabel palabraOcultaIzquierda = new JLabel(VentanaModoClasico.ocultarPalabra(2));
		JLabel palabraIzquierda = new JLabel("PALABRA OCULTA:");
		contadorErroresIzquierda.setHorizontalAlignment(SwingConstants.CENTER);
		erroresIzquierda.setHorizontalAlignment(SwingConstants.CENTER);
		palabraOcultaIzquierda.setHorizontalAlignment(SwingConstants.CENTER);
		palabraIzquierda.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panelGeneralDerecha = new JPanel();
		panelGeneralDerecha.setLayout(new GridLayout(2,1));
		JPanel panelArribaDerecha = new JPanel();
		panelArribaDerecha.setLayout(new GridLayout(1,2));
		JPanel panelIzquierdaDerecha = new JPanel();
		panelIzquierdaDerecha.setLayout(new GridLayout(7,1));
		JPanel panelDerechaDerecha = new JPanel();
		JPanel panelAbecedarioDerecha = new JPanel();
		panelAbecedarioDerecha.setLayout(new GridLayout(1,0));
		panelAbecedarioDerecha.add(VentanaModoClasico.crearTeclado());
		
		JLabel contadorErroresDerecha = new JLabel();
		JLabel erroresDerecha = new JLabel("ERRORES:");
		JLabel palabraOcultaDerecha = new JLabel(VentanaModoClasico.ocultarPalabra(2));
		JLabel palabraDerecha = new JLabel("PALABRA OCULTA:");
		contadorErroresDerecha.setHorizontalAlignment(SwingConstants.CENTER);
		erroresDerecha.setHorizontalAlignment(SwingConstants.CENTER);
		palabraOcultaDerecha.setHorizontalAlignment(SwingConstants.CENTER);
		palabraDerecha.setHorizontalAlignment(SwingConstants.CENTER);
		
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
				new VentanaInstrucciones1vs1();
				
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
					panelIzquierdaIzquierda.setBackground(color);
					panelIzquierdaDerecha.setBackground(color);
					panelDerechaDerecha.setBackground(color);
					panelDerechaIzquierda.setBackground(color);
				}
				
			}
		});
		
		botonSalirIzquierda.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaSelectorModo();
				dispose();
			}
		});
		
		botonSalirDerecha.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaSelectorModo();
				dispose();
			}
		});
		
		botonResolverIzquierda.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaResolver();
				
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
				
				if(contador % 2 == 0) {
					panelAbecedarioDerecha.setVisible(false);
					botonListoDerecha.setVisible(false);
					botonResolverDerecha.setVisible(false);
					botonSalirDerecha.setVisible(false);
					
					panelAbecedarioIzquierda.setVisible(true);
					botonListoIzquierda.setVisible(true);
					botonResolverIzquierda.setVisible(true);
					botonSalirIzquierda.setVisible(true);
				} else {
					panelAbecedarioIzquierda.setVisible(false);
					botonListoIzquierda.setVisible(false);
					botonResolverIzquierda.setVisible(false);
					botonSalirIzquierda.setVisible(false);
					
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
				
				if(contador % 2 == 0) {
					panelAbecedarioDerecha.setVisible(false);
					botonListoDerecha.setVisible(false);
					botonResolverDerecha.setVisible(false);
					botonSalirDerecha.setVisible(false);
					
					panelAbecedarioIzquierda.setVisible(true);
					botonListoIzquierda.setVisible(true);
					botonResolverIzquierda.setVisible(true);
					botonSalirIzquierda.setVisible(true);
				} else {
					panelAbecedarioIzquierda.setVisible(false);
					botonListoIzquierda.setVisible(false);
					botonResolverIzquierda.setVisible(false);
					botonSalirIzquierda.setVisible(false);
					
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
		botonResolverIzquierda.setVisible(true);
		botonSalirIzquierda.setVisible(true);
		
		panelIzquierdaIzquierda.add(botonListoIzquierda);
		panelIzquierdaIzquierda.add(botonSalirIzquierda);
		panelIzquierdaIzquierda.add(botonResolverIzquierda);
		panelIzquierdaIzquierda.add(palabraIzquierda);
		panelIzquierdaIzquierda.add(palabraOcultaIzquierda);
		panelIzquierdaIzquierda.add(erroresIzquierda);
		panelIzquierdaIzquierda.add(contadorErroresIzquierda);
		
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
		
		
		panelGeneral.add(panelGeneralDerecha, BorderLayout.EAST);
		panelGeneral.add(panelGeneralIzquierda, BorderLayout.WEST);
		
		
	
		
		
		
		this.add(panelGeneral, BorderLayout.CENTER);
		this.setJMenuBar(menu);
		
		this.setTitle("1 vs 1");
		this.setSize(1280, 720);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		
		
	
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		new Ventana1vs1();
	}
}