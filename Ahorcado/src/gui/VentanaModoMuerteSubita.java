package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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

public class VentanaModoMuerteSubita extends JFrame{
	
	private JButton botonSalir = new JButton("  Volver al selector de modo  ");
	private JButton botonPalabraNueva = new JButton("  Palabra Nueva  ");
	private JButton botonResolver = new JButton("  Resolver  ");
	
	
	public VentanaModoMuerteSubita() {
		JPanel panelGeneral = new JPanel();
		panelGeneral.setLayout(new GridLayout(2,1));
		JPanel panelArriba = new JPanel();
		panelArriba.setLayout(new GridLayout(1,2));
		JPanel panelIzquierda = new JPanel();
		panelIzquierda.setLayout(new GridLayout(8,1));
		JPanel panelDerecha = new JPanel();
		JPanel panelAbecedario = new JPanel();
		panelAbecedario.setLayout(new GridLayout(1,1));
	
		
		JLabel contadorErrores = new JLabel();
		JLabel errores = new JLabel("ERRORES:");
		JLabel palabraOculta = new JLabel("_ _ _ _ _");
		JLabel palabra = new JLabel("PALABRA OCULTA:");
		contadorErrores.setHorizontalAlignment(SwingConstants.CENTER);
		errores.setHorizontalAlignment(SwingConstants.CENTER);
		palabraOculta.setHorizontalAlignment(SwingConstants.CENTER);
		palabra.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel adivinadas = new JLabel("Palabras adivinadas: 0");
		adivinadas.setHorizontalAlignment(SwingConstants.CENTER);//esta linea la he sacado buscando en la API como poner un texto centrado en una JLabel 
		  //(https://docs.oracle.com/en/java/javase/17/docs/api/java.desktop/javax/swing/JLabel.html#setHorizontalAlignment(int))
		
		
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
				new VentanaInstruccionesModoMuerteSubita();
				
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
		panelIzquierda.add(adivinadas);
		
		
		panelArriba.add(panelIzquierda, BorderLayout.WEST);
		panelArriba.add(panelDerecha, BorderLayout.EAST);
		
		panelAbecedario.add(VentanaModoClasico.crearTeclado());
		
		panelGeneral.add(panelArriba, BorderLayout.NORTH);
		panelGeneral.add(panelAbecedario, BorderLayout.SOUTH);

		this.add(panelGeneral, BorderLayout.CENTER);
		this.setJMenuBar(menu);
		this.setTitle("Modo Muerte Súbita");
		this.setSize(1000, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		new VentanaModoMuerteSubita();
	}
	
}
