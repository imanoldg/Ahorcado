package gui;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class VentanaInstruccionesModoContrarreloj extends JFrame{
	
	public VentanaInstruccionesModoContrarreloj() {
		JLabel instrucciones = new JLabel("<html><body>Jugadores: 1. <br> "
				+ "Objetivo: Descubrir el máximo número de palabras en el menor tiempo posible. <br>"
				+ "<br>"
				+ "<br>"
				+ "Preparación: <br>"
				+ "- Al inicio el programa generará aleatoriamente una palabra y aparecerá con espacios vacios donde deberian ir los caracteres que la forman. <br>"
				+ "- La cuenta atrás comenzará. <br>"
				+ "<br>"
				+ "Jugar: <br>"
				+ "- El jugador puede: Pedir una letra / Adivinar la palabra. <br>"
				+ "-- Si la letra está, entonces el programa sustituye el espacio vacio por la letra en el lugar que ocupa en la palabra secreta, sumará 5 segundos a la cuenta atrás y sumará 1 punto a la puntuación del jugador. <br>"
				+ "-- Si la letra no está, entonces el programa dibujará una parte del muñeco, apuntará un fallo y restará 5 segundos a la cuenta atrás <br>"
				+ "- Muñeco: El muñeco se dibuja en 6 partes (cabeza, torso, piernas y brazos), por lo que el jugador tiene 6 posibildades de fallar por cada palabra. <br>"
				+ "- Adivinar la Palabra: El jugador puede intentar adivinar la palabra secreta. <br>"
				+ "-- Si acierta la palabra, entonces el programa completa la solución y genera otra palabra aleatoriamente, resetea el muñeco y suma 5 puntos a la puntuación del jugador. <br>"
				+ "-- Si no acierta la palabra, entonces el programa dibujará una parte del muñeco y restara 10 segundos a la cuenta atrás. <br>"
				+ "Fin de la partida: <br>"
				+ "- El juego termina cuando la cuenta atrás llegue a 0, entonces se guardará la puntuación del jugador en la base de datos<html><body>");
		
		instrucciones.setPreferredSize(new Dimension(800,600));
		instrucciones.setHorizontalAlignment(SwingConstants.CENTER);
		
		JMenuBar barraTitulo = new JMenuBar();
		JMenu titulo = new JMenu("INSTRUCCIONES MODO CONTRARRELOJ");
		barraTitulo.add(titulo);
		
		
		this.add(instrucciones);
		this.setJMenuBar(barraTitulo);
		this.setTitle("Instrucciones del Modo Contrarreloj");
		this.setSize(800, 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
	}	
	public static void main(String[] args) {
		new VentanaInstruccionesModoContrarreloj();
	}
}
