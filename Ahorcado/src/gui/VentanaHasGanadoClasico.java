package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import io.LoggerReg;

public class VentanaHasGanadoClasico extends JFrame {
	
	private static Logger log = LoggerReg.ejecutarLogger();
	
	public static JButton botonCerrar = new JButton("  Cerrar el juego  ");
	public static JButton botonVolverJugar = new JButton("  Volver a jugar  ");
	
	protected ImageIcon imagenHasGanado = new ImageIcon("resources/images/HasGanado.png");
	protected JLabel labelImagen = new JLabel(imagenHasGanado);
	
	private void ReiniciarJuego() {
		VentanaModoClasico.panelAbecedario.removeAll();
		VentanaModoClasico.panelArriba.removeAll();
		VentanaModoClasico.panelIzquierda.removeAll();
		VentanaModoClasico.panelDerecha.removeAll();
		VentanaModoClasico.palabraSeleccionada = VentanaModoClasico.SeleccionarPalabra();
		VentanaModoClasico.textoLabel = VentanaModoClasico.ocultarPalabra(VentanaModoClasico.palabraSeleccionada.getPalabra());
		VentanaModoClasico.letrasPalabra.clear();
		VentanaModoClasico.letrasPalabra.addAll(VentanaModoClasico.añadirLetras());
		VentanaModoClasico.palabraOculta.setText(VentanaModoClasico.textoLabel.toString());
	}
	
	public VentanaHasGanadoClasico() {
		JPanel panelGeneral = new JPanel();
		panelGeneral.setLayout(new GridLayout(2,1));
		JPanel panelAbajo = new JPanel();
		
		
		botonCerrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		
		botonVolverJugar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ReiniciarJuego();
					new VentanaModoClasico();
					dispose();
					
					log.info("Modo Clasico reiniciado con exito");
					
				} catch (FileNotFoundException e1) {
					log.warning(String.format("Error reiniciando el Modo Clasico: %s", e1.getMessage()));
				}
			}
		});
		
		panelAbajo.add(botonVolverJugar);
		panelAbajo.add(botonCerrar);

		
		panelGeneral.add(labelImagen, BorderLayout.NORTH);
		panelGeneral.add(panelAbajo, BorderLayout.SOUTH);

		
		this.add(panelGeneral, BorderLayout.CENTER);
		this.setTitle("Has Ganado");
		this.pack();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	}
	public static void main(String[] args) {
		new VentanaHasGanadoClasico();
	}
}
