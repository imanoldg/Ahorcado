package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
	
	private JButton botonSalir = new JButton("  Volver al selector de modo  ");
	private JButton botonPalabraNueva = new JButton("  Palabra Nueva  ");
	private JButton botonPalabraNueva2 = new JButton("  Palabra Nueva  ");
	
	private int contador;
	
	public Ventana1vs1() {
		JPanel panelGeneral = new JPanel();
		panelGeneral.setLayout(new GridLayout(1,2));
		JPanel panelIzquierda = new JPanel();
		JPanel panelAbajo = new JPanel();
		panelAbajo.setLocation(0,50);
		JPanel panelDerecha = new JPanel();
		
		panelIzquierda.add(botonA);
		panelIzquierda.add(botonB);
		panelIzquierda.add(botonC);
		panelIzquierda.add(botonD);
		panelIzquierda.add(botonE);
		panelIzquierda.add(botonF);
		panelIzquierda.add(botonG);
		panelIzquierda.add(botonH);
		panelIzquierda.add(botonI);
		panelIzquierda.add(botonJ);
		panelIzquierda.add(botonK);
		panelIzquierda.add(botonL);
		panelIzquierda.add(botonM);
		panelIzquierda.add(botonN);
		panelIzquierda.add(botonÑ);
		panelIzquierda.add(botonO);
		panelIzquierda.add(botonP);
		panelIzquierda.add(botonQ);
		panelIzquierda.add(botonR);
		panelIzquierda.add(botonS);
		panelIzquierda.add(botonT);
		panelIzquierda.add(botonU);
		panelIzquierda.add(botonV);
		panelIzquierda.add(botonW);
		panelIzquierda.add(botonX);
		panelIzquierda.add(botonY);
		panelIzquierda.add(botonZ);
		
		panelAbajo.add(panelIzquierda);
		
		panelDerecha.add(botonA2);
		panelDerecha.add(botonB2);
		panelDerecha.add(botonC2);
		panelDerecha.add(botonD2);
		panelDerecha.add(botonE2);
		panelDerecha.add(botonF2);
		panelDerecha.add(botonG2);
		panelDerecha.add(botonH2);
		panelDerecha.add(botonI2);
		panelDerecha.add(botonJ2);
		panelDerecha.add(botonK2);
		panelDerecha.add(botonL2);
		panelDerecha.add(botonM2);
		panelDerecha.add(botonN2);
		panelDerecha.add(botonÑ2);
		panelDerecha.add(botonO2);
		panelDerecha.add(botonP2);
		panelDerecha.add(botonQ2);
		panelDerecha.add(botonR2);
		panelDerecha.add(botonS2);
		panelDerecha.add(botonT2);
		panelDerecha.add(botonU2);
		panelDerecha.add(botonV2);
		panelDerecha.add(botonW2);
		panelDerecha.add(botonX2);
		panelDerecha.add(botonY2);
		panelDerecha.add(botonZ2);
		
		panelAbajo.add(panelDerecha);
		
		
		this.setTitle("1 vs 1");
		this.setSize(1280, 720);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setLayout(new GridLayout(1, 2));
		this.add(panelDerecha, BorderLayout.SOUTH);
		this.add(panelIzquierda, BorderLayout.SOUTH);
		this.add(panelAbajo);
	
	}
	
	public static void main(String[] args) {
		new Ventana1vs1();
	}
}
