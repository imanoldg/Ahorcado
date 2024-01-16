package gui;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.SwingConstants;

public class VentanaInstrucciones1vs1 extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Inicializacion de la ventana de instrucciones del Modo 1vs1
	public VentanaInstrucciones1vs1() {
		JLabel instrucciones = new JLabel("<html><body>Jugadores: 2. <br> "
				+ 	"Objetivo: Descubrir la palabra. <br>"
				+ "<br>"
				+ "<br>"
				+ "Preparación: <br>"
				+ "-Al inicio el programa generará aleatoriamente una palabra para cada uno de los jugadores y aparecerá con espacios vacios donde deberian ir los caracteres que la forman. <br>"
				+ "<br>"
				+ "<br>"
				+ "Jugar: <br>"
				+ "- Los jugadores pueden: Pedir una letra <br>"
				+ "-- Si la letra está, entonces el programa sustituye el espacio vacio por la letra en el lugar que ocupa en la palabra secreta. <br>"
				+ "-- Si la letra no está, entonces el programa dibujará una parte del muñeco y apuntará un fallo. <br>"
				+ "-- Este modo de juego va por turnos, por lo que en el primer turno se mostrara la interfaz del jugador 1 y en el siguiente la del jugador 2, y asi sucesivamente hasta que termine la partida. <br>"
				+ "- Muñeco: El muñeco se dibuja en 6 partes (cabeza, torso, piernas y brazos), por lo que los jugadores tienen 6 posibildades de fallar. <br>"
				+ "Fin de la partida: <br>"
				+ "- GANA el jugador que antes descubra la palabra. <br>"
				+ "- PIERDE el jugador si se dibuja el muñeco completo en la horca o falla al intentar resolver la palabra<html><body>");
		
		instrucciones.setPreferredSize(new Dimension(800,600));
		instrucciones.setHorizontalAlignment(SwingConstants.CENTER);
		
		JMenuBar barraTitulo = new JMenuBar();
		JMenu titulo = new JMenu("INSTRUCCIONES MODO 1VS1");
		barraTitulo.add(titulo);
		
		this.add(instrucciones);
		this.setJMenuBar(barraTitulo);
		this.setTitle("Instrucciones del Modo 1vs1");
		this.setSize(800, 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
	}
	
}
