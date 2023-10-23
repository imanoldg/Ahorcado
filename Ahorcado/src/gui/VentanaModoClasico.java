package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

import domain.Usuario;

public class VentanaModoClasico extends JFrame{
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
	private JButton botonInstrucciones = new JButton("  Instrucciones  ");
	
	private JList<Usuario> listaTop = new JList<Usuario>();
	
	public VentanaModoClasico() {
		JPanel panelGeneral = new JPanel();
		panelGeneral.setLayout(new GridLayout(2,1));
		JPanel panelArriba = new JPanel();
		panelArriba.setLayout(new GridLayout(1,2));
		JPanel panelIzquierda = new JPanel();
		panelIzquierda.setLayout(new GridLayout(2,1));
		JPanel panelDerecha = new JPanel();
		JPanel panelLista = new JPanel();
		panelLista.setLayout(new GridLayout(1,1));
		JPanel panelOpciones = new JPanel();
		panelOpciones.setLayout(new GridLayout(4,1));
		JPanel panelAbecedario = new JPanel();
		panelAbecedario.setLayout(new GridLayout(3,10));
		
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
		
		panelLista.add(listaTop);
		panelOpciones.add(botonInstrucciones);
		panelOpciones.add(botonPalabraNueva);
		panelOpciones.add(botonSalir);
		
		panelIzquierda.add(panelLista, BorderLayout.NORTH);
		panelIzquierda.add(panelOpciones, BorderLayout.SOUTH);
		
		panelArriba.add(panelIzquierda, BorderLayout.WEST);
		panelArriba.add(panelDerecha, BorderLayout.EAST);
		
		
		
		panelGeneral.add(panelArriba, BorderLayout.NORTH);
		panelGeneral.add(panelAbecedario, BorderLayout.SOUTH);

		this.add(panelGeneral, BorderLayout.CENTER);
		
		this.setTitle("Modo Clásico");
		this.setSize(1000, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	}
	
	public static void main(String[] args) {
		new VentanaModoClasico();
	}
	
}
