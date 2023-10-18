package Ahorcado;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaModoClasico extends JFrame{
	JButton botonA = new JButton("A");
	JButton botonB = new JButton("B");
	JButton botonC = new JButton("C");
	JButton botonD = new JButton("D");
	JButton botonE = new JButton("E");
	JButton botonF = new JButton("F");
	JButton botonG = new JButton("G");
	JButton botonH = new JButton("H");
	JButton botonI = new JButton("I");
	JButton botonJ = new JButton("J");
	JButton botonK = new JButton("K");
	JButton botonL = new JButton("L");
	JButton botonM = new JButton("M");
	JButton botonN = new JButton("N");
	JButton botonÑ = new JButton("Ñ");
	JButton botonO = new JButton("O");
	JButton botonP = new JButton("P");
	JButton botonQ = new JButton("Q");
	JButton botonR = new JButton("R");
	JButton botonS = new JButton("S");
	JButton botonT = new JButton("T");
	JButton botonU = new JButton("U");
	JButton botonV = new JButton("V");
	JButton botonW = new JButton("W");
	JButton botonX = new JButton("X");
	JButton botonY = new JButton("Y");
	JButton botonZ = new JButton("Z");
	
	JButton botonSalir = new JButton();
	JButton botonPalabraNueva = new JButton();
	JButton botonInstrucciones = new JButton();
	
	public VentanaModoClasico() {
		JPanel panelAbajo = new JPanel();
		panelAbajo.setLayout(new BorderLayout());
		JPanel panelArriba = new JPanel();
		panelArriba.setLayout(new BorderLayout());
		JPanel panelBotones = new JPanel();
		panelBotones.setLayout(new BorderLayout());
		
		panelBotones.add(botonA);
		panelBotones.add(botonB);
		panelBotones.add(botonC);
		panelBotones.add(botonD);
		panelBotones.add(botonE);
		panelBotones.add(botonF);
		panelBotones.add(botonG);
		panelBotones.add(botonH);
		panelBotones.add(botonI);
		panelBotones.add(botonJ);
		panelBotones.add(botonK);
		panelBotones.add(botonL);
		panelBotones.add(botonM);
		panelBotones.add(botonN);
		panelBotones.add(botonÑ);
		panelBotones.add(botonO);
		panelBotones.add(botonP);
		panelBotones.add(botonQ);
		panelBotones.add(botonR);
		panelBotones.add(botonS);
		panelBotones.add(botonT);
		panelBotones.add(botonU);
		panelBotones.add(botonV);
		panelBotones.add(botonW);
		panelBotones.add(botonX);
		panelBotones.add(botonY);
		panelBotones.add(botonZ);
		
		panelAbajo.add(panelBotones);
		
		this.add(panelAbajo, BorderLayout.SOUTH);
		
		this.setTitle("Modo Clásico");
		this.setSize(800, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new VentanaModoClasico();
	}
	
}
