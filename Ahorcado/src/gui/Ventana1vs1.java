package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Ventana1vs1 extends JFrame{
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
	
	private JButton botonA2 = new JButton("A");
	private JButton botonB2 = new JButton("B");
	private JButton botonC2 = new JButton("C");
	private JButton botonD2 = new JButton("D");
	private JButton botonE2 = new JButton("E");
	private JButton botonF2 = new JButton("F");
	private JButton botonG2 = new JButton("G");
	private JButton botonH2 = new JButton("H");
	private JButton botonI2 = new JButton("I");
	private JButton botonJ2 = new JButton("J");
	private JButton botonK2 = new JButton("K");
	private JButton botonL2 = new JButton("L");
	private JButton botonM2 = new JButton("M");
	private JButton botonN2 = new JButton("N");
	private JButton botonÑ2 = new JButton("Ñ");
	private JButton botonO2 = new JButton("O");
	private JButton botonP2 = new JButton("P");
	private JButton botonQ2 = new JButton("Q");
	private JButton botonR2 = new JButton("R");
	private JButton botonS2 = new JButton("S");
	private JButton botonT2 = new JButton("T");
	private JButton botonU2 = new JButton("U");
	private JButton botonV2 = new JButton("V");
	private JButton botonW2 = new JButton("W");
	private JButton botonX2 = new JButton("X");
	private JButton botonY2 = new JButton("Y");
	private JButton botonZ2 = new JButton("Z");
	
	private JButton botonSalirIzquierda = new JButton("  Volver al selector de modo  ");
	private JButton botonPalabraNuevaIzquierda = new JButton("  Palabra Nueva  ");
	private JButton botonResolverIzquierda = new JButton("  Resolver  ");
	
	private JButton botonSalirDerecha = new JButton("  Volver al selector de modo  ");
	private JButton botonPalabraNuevaDerecha = new JButton("  Palabra Nueva  ");
	private JButton botonResolverDerecha = new JButton("  Resolver  ");
	
	private int contador;
	
	public Ventana1vs1() {
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
		panelAbecedarioIzquierda.setLayout(new GridLayout(3,10));
		
		JLabel contadorErroresIzquierda = new JLabel();
		JLabel erroresIzquierda = new JLabel("ERRORES:");
		JLabel palabraOcultaIzquierda = new JLabel("_ _ _ _ _");
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
		panelAbecedarioDerecha.setLayout(new GridLayout(3,10));
		
		JLabel contadorErroresDerecha = new JLabel();
		JLabel erroresDerecha = new JLabel("ERRORES:");
		JLabel palabraOcultaDerecha = new JLabel("_ _ _ _ _");
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
		
		
		panelAbecedarioIzquierda.add(botonA);
		panelAbecedarioIzquierda.add(botonB);
		panelAbecedarioIzquierda.add(botonC);
		panelAbecedarioIzquierda.add(botonD);
		panelAbecedarioIzquierda.add(botonE);
		panelAbecedarioIzquierda.add(botonF);
		panelAbecedarioIzquierda.add(botonG);
		panelAbecedarioIzquierda.add(botonH);
		panelAbecedarioIzquierda.add(botonI);
		panelAbecedarioIzquierda.add(botonJ);
		panelAbecedarioIzquierda.add(botonK);
		panelAbecedarioIzquierda.add(botonL);
		panelAbecedarioIzquierda.add(botonM);
		panelAbecedarioIzquierda.add(botonN);
		panelAbecedarioIzquierda.add(botonÑ);
		panelAbecedarioIzquierda.add(botonO);
		panelAbecedarioIzquierda.add(botonP);
		panelAbecedarioIzquierda.add(botonQ);
		panelAbecedarioIzquierda.add(botonR);
		panelAbecedarioIzquierda.add(botonS);
		panelAbecedarioIzquierda.add(botonT);
		panelAbecedarioIzquierda.add(botonU);
		panelAbecedarioIzquierda.add(botonV);
		panelAbecedarioIzquierda.add(botonW);
		panelAbecedarioIzquierda.add(botonX);
		panelAbecedarioIzquierda.add(botonY);
		panelAbecedarioIzquierda.add(botonZ);
		
		
		panelAbecedarioDerecha.add(botonA2);
		panelAbecedarioDerecha.add(botonB2);
		panelAbecedarioDerecha.add(botonC2);
		panelAbecedarioDerecha.add(botonD2);
		panelAbecedarioDerecha.add(botonE2);
		panelAbecedarioDerecha.add(botonF2);
		panelAbecedarioDerecha.add(botonG2);
		panelAbecedarioDerecha.add(botonH2);
		panelAbecedarioDerecha.add(botonI2);
		panelAbecedarioDerecha.add(botonJ2);
		panelAbecedarioDerecha.add(botonK2);
		panelAbecedarioDerecha.add(botonL2);
		panelAbecedarioDerecha.add(botonM2);
		panelAbecedarioDerecha.add(botonN2);
		panelAbecedarioDerecha.add(botonÑ2);
		panelAbecedarioDerecha.add(botonO2);
		panelAbecedarioDerecha.add(botonP2);
		panelAbecedarioDerecha.add(botonQ2);
		panelAbecedarioDerecha.add(botonR2);
		panelAbecedarioDerecha.add(botonS2);
		panelAbecedarioDerecha.add(botonT2);
		panelAbecedarioDerecha.add(botonU2);
		panelAbecedarioDerecha.add(botonV2);
		panelAbecedarioDerecha.add(botonW2);
		panelAbecedarioDerecha.add(botonX2);
		panelAbecedarioDerecha.add(botonY2);
		panelAbecedarioDerecha.add(botonZ2);
		
		panelIzquierdaIzquierda.add(botonPalabraNuevaIzquierda);
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
		
		panelIzquierdaDerecha.add(botonPalabraNuevaDerecha);
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
	
	public static void main(String[] args) {
		new Ventana1vs1();
	}
}