package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Window;
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
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static Logger log = LoggerReg.ejecutarLogger();
	
	public static JButton botonCerrar = new JButton("  Cerrar el juego  ");
	public static JButton botonVolverJugar = new JButton("  Volver a jugar  ");
	
	protected ImageIcon imagenHasGanado = new ImageIcon("resources/images/HasGanado.png");
	protected JLabel labelImagen = new JLabel(imagenHasGanado);
	
	//Metodo para reiniciar el Modo Clasico
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
	
	//Inicializacion de la ventana
	public VentanaHasGanadoClasico() {
		JPanel panelGeneral = new JPanel();
		panelGeneral.setLayout(new GridLayout(2,1));
		JPanel panelAbajo = new JPanel();
		
		
		botonCerrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Window[] windows = getWindows();

			    for (Window window : windows)
			    {
			        
			            window.dispose();
			        
			    }
			    
			}
		});
		
		botonVolverJugar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ReiniciarJuego();
					Window[] windows = getWindows();

				    for (Window window : windows)
				    {
		
				            window.dispose();
				        
				    }
				    
				    new VentanaModoClasico();
					
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
}
