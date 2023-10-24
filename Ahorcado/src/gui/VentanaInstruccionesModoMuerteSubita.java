package gui;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class VentanaInstruccionesModoMuerteSubita extends JFrame{
	
	public VentanaInstruccionesModoMuerteSubita() {
		JLabel instrucciones = new JLabel("<html><body>Jugadores: 1. <br> "
				+ "Objetivo: Descubrir el máximo número de palabras con el mínimo de fallos posibles. <br>"
				+ "<br>"
				+ "<br>"
				+ "Preparación: <br>"
				+ "-Al inicio el programa generará aleatoriamente una palabra y aparecerá con espacios vacios donde deberian ir los caracteres que la forman. <br>"
				+ "<br>"
				+ "<br>"
				+ "Jugar: <br>"
				+ "- El jugador puede: Pedir una letra / Adivinar la palabra. <br>"
				+ "-- Si la letra está, entonces el programa sustituye el espacio vacio por la letra en el lugar que ocupa en la palabra secreta. <br>"
				+ "-- Si la letra no está, entonces el programa dibujará una parte del muñeco y apuntará un fallo."
				+ "- Muñeco: El muñeco se dibuja en 6 partes (cabeza, torso, piernas y brazos), por lo que el jugador tiene 6 posibildades de fallar. <br>"
				+ "- Adivinar la Palabra: El jugador puede intentar adivinar la palabra secreta. <br>"
				+ "-- Si acierta la palabra, entonces el programa completa la solución y suma 1 punto a la puntuación del jugador. <br>"
				+ "-- Si no acierta la palabra, entonces el programa dibujará una parte del muñeco. <br>"
				+ "Fin de la partida: <br>"
				+ "- Se termina la partida cuando el muñeco este descubierto por completo<html><body>");
		
		instrucciones.setPreferredSize(new Dimension(800,600));
		instrucciones.setHorizontalAlignment(SwingConstants.CENTER);
		
		JMenuBar barraTitulo = new JMenuBar();
		JMenu titulo = new JMenu("INSTRUCCIONES MODO MUERTE SÚBITA");
		barraTitulo.add(titulo);
		
		this.add(instrucciones);
		this.setJMenuBar(barraTitulo);
		this.setTitle("Instrucciones del Modo Muerte Súbita");
		this.setSize(800, 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
	}
	public static void main(String[] args) {
		new VentanaInstruccionesModoMuerteSubita();
	}
}
