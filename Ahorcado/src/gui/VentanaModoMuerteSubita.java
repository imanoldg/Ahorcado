package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
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
	private JButton botonA = new JButton("A");
	private JButton botonB = new JButton("B");
	private JButton botonC = new JButton("C");
	private JButton botonD = new JButton("D");
	private JButton botonE = new JButton("E");
	private JButton botonF = new JButton("F");
	private JButton botonG = new JButton("G");
	private JButton botonH = new JButton("H");
	private JButton botonI = new JButton("I");
	private JButton botonJ = new JButton("J");
	private JButton botonK = new JButton("K");
	private JButton botonL = new JButton("L");
	private JButton botonM = new JButton("M");
	private JButton botonN = new JButton("N");
	private JButton botonÑ = new JButton("Ñ");
	private JButton botonO = new JButton("O");
	private JButton botonP = new JButton("P");
	private JButton botonQ = new JButton("Q");
	private JButton botonR = new JButton("R");
	private JButton botonS = new JButton("S");
	private JButton botonT = new JButton("T");
	private JButton botonU = new JButton("U");
	private JButton botonV = new JButton("V");
	private JButton botonW = new JButton("W");
	private JButton botonX = new JButton("X");
	private JButton botonY = new JButton("Y");
	private JButton botonZ = new JButton("Z");
	
	private JButton botonSalir = new JButton("  Volver al selector de modo  ");
	private JButton botonPalabraNueva = new JButton("  Palabra Nueva  ");
	
	
	public VentanaModoMuerteSubita() {
		botonSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaSelectorModo();
				dispose();
			}
		});

		JPanel panelGeneral = new JPanel();
		panelGeneral.setLayout(new GridLayout(2,1));
		JPanel panelArriba = new JPanel();
		panelArriba.setLayout(new GridLayout(1,2));
		JPanel panelIzquierda = new JPanel();
		panelIzquierda.setLayout(new GridLayout(7,1));
		JPanel panelDerecha = new JPanel();
		JPanel panelAbecedario = new JPanel();
		panelAbecedario.setLayout(new GridLayout(3,10));
		
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
		
		panelAbecedario.add(botonA);
		panelAbecedario.add(botonB);
		panelAbecedario.add(botonC);
		panelAbecedario.add(botonD);
		panelAbecedario.add(botonE);
		panelAbecedario.add(botonF);
		panelAbecedario.add(botonG);
		panelAbecedario.add(botonH);
		panelAbecedario.add(botonI);
		panelAbecedario.add(botonJ);
		panelAbecedario.add(botonK);
		panelAbecedario.add(botonL);
		panelAbecedario.add(botonM);
		panelAbecedario.add(botonN);
		panelAbecedario.add(botonÑ);
		panelAbecedario.add(botonO);
		panelAbecedario.add(botonP);
		panelAbecedario.add(botonQ);
		panelAbecedario.add(botonR);
		panelAbecedario.add(botonS);
		panelAbecedario.add(botonT);
		panelAbecedario.add(botonU);
		panelAbecedario.add(botonV);
		panelAbecedario.add(botonW);
		panelAbecedario.add(botonX);
		panelAbecedario.add(botonY);
		panelAbecedario.add(botonZ);
		

		panelIzquierda.add(botonPalabraNueva);
		panelIzquierda.add(botonSalir);
		panelIzquierda.add(palabra);
		panelIzquierda.add(palabraOculta);
		panelIzquierda.add(errores);
		panelIzquierda.add(contadorErrores);
		panelIzquierda.add(adivinadas);
		
		
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
		this.setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		new VentanaModoMuerteSubita();
	}
}
