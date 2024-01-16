package gui;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import io.LoggerReg;

public class VentanaSelectorModo extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static Logger log = LoggerReg.ejecutarLogger();
	
	private JButton modoContrarreloj = new JButton("Modo Contrarreloj");
	private JButton modoMuerteSubita = new JButton("Modo Muerte Súbita");
	private JButton modo1vs1 = new JButton("Modo 1vs1");
	private JButton modoClasico = new JButton("Modo Clasico");
	
	//Metodo para reiniciar el Modo Clasico
	public static void ReiniciarClasico() {
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
	//Metodo para reiniciar el Modo Muerte Subita
	private void ReiniciarSubita() {
		VentanaModoMuerteSubita.palabraSeleccionada = VentanaModoMuerteSubita.SeleccionarPalabra();
		VentanaModoMuerteSubita.textoLabel = VentanaModoMuerteSubita.ocultarPalabra(VentanaModoMuerteSubita.palabraSeleccionada.getPalabra());
		VentanaModoMuerteSubita.letrasPalabra.clear();
		VentanaModoMuerteSubita.letrasPalabra.addAll(VentanaModoMuerteSubita.añadirLetras());
		VentanaModoMuerteSubita.palabraOculta.setText(VentanaModoMuerteSubita.textoLabel.toString());
		VentanaModoMuerteSubita.panelAbecedario.removeAll();
		VentanaModoMuerteSubita.adivinadasLabel.removeAll();
		VentanaModoMuerteSubita.panelArriba.removeAll();
		VentanaModoMuerteSubita.panelIzquierda.removeAll();
		VentanaModoMuerteSubita.panelDerecha.removeAll();
	}
	//Metodo para reiniciar el Modo Contrarreloj
	private void ReiniciarContrarreloj() {
		VentanaModoContrarreloj.panelAbecedario.removeAll();
		VentanaModoContrarreloj.panelArriba.removeAll();
		VentanaModoContrarreloj.panelIzquierda.removeAll();
		VentanaModoContrarreloj.panelDerecha.removeAll();
		VentanaModoContrarreloj.palabraSeleccionada = VentanaModoContrarreloj.SeleccionarPalabra();
		VentanaModoContrarreloj.textoLabel = VentanaModoContrarreloj.ocultarPalabra(VentanaModoContrarreloj.palabraSeleccionada.getPalabra());
		VentanaModoContrarreloj.letrasPalabra.clear();
		VentanaModoContrarreloj.letrasPalabra.addAll(VentanaModoContrarreloj.añadirLetras());
		VentanaModoContrarreloj.palabraOculta.setText(VentanaModoContrarreloj.textoLabel.toString());
		VentanaModoContrarreloj.etiqueta.removeAll();
	}
	//Metodo para reiniciar el Modo 1vs1
	private void Reiniciar1vs1(){
		Ventana1vs1.panelGeneral.removeAll();
		Ventana1vs1.panelAbecedarioDerecha.removeAll();
		Ventana1vs1.panelAbecedarioIzquierda.removeAll();
		Ventana1vs1.panelArribaDerecha.removeAll();
		Ventana1vs1.panelArribaIzquierda.removeAll();
		Ventana1vs1.panelIzquierdaDerecha.removeAll();
		Ventana1vs1.panelIzquierdaIzquierda.removeAll();
		Ventana1vs1.panelDerechaDerecha.removeAll();
		Ventana1vs1.panelDerechaIzquierda.removeAll();
		Ventana1vs1.palabraSeleccionadaDerecha = Ventana1vs1.SeleccionarPalabra();
		Ventana1vs1.palabraSeleccionada = Ventana1vs1.SeleccionarPalabra();
		Ventana1vs1.textoLabelDerecha = Ventana1vs1.ocultarPalabra(Ventana1vs1.palabraSeleccionadaDerecha.getPalabra());
		Ventana1vs1.textoLabel = Ventana1vs1.ocultarPalabra(Ventana1vs1.palabraSeleccionada.getPalabra());
		Ventana1vs1.letrasPalabraDerecha.clear();
		Ventana1vs1.letrasPalabraDerecha.addAll(Ventana1vs1.añadirLetras());
		Ventana1vs1.letrasPalabra.clear();
		Ventana1vs1.letrasPalabra.addAll(Ventana1vs1.añadirLetras());
		Ventana1vs1.palabraOcultaDerecha.setText(Ventana1vs1.textoLabelDerecha.toString());
		Ventana1vs1.palabraOculta.setText(Ventana1vs1.textoLabel.toString());
	}
	
	//Se inicializa la ventana
	public VentanaSelectorModo(){	
		//ACCIONES DE CADA BOTON (PARA ABIR EL RESTO DE VENATANAS)
		modoContrarreloj.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ReiniciarContrarreloj();
					new VentanaModoContrarreloj();
					dispose();
					
					log.info("Modo Contrarreloj reiniciado con exito");
					
				} catch (FileNotFoundException e1) {
					log.warning(String.format("Error intentando reiniciar el Modo Contrarreloj",e1.getMessage()));
				}
				
			}
		});
		
		modoMuerteSubita.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ReiniciarSubita();
					new VentanaModoMuerteSubita();
					dispose();
					
					log.info("Modo Muerte Subita reiniciado con exito");
					
				} catch (FileNotFoundException e1) {
					log.warning(String.format("Error intentando reiniciar el Modo Muerte Subita",e1.getMessage()));
				}
				
			}
		});
		
		modo1vs1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Reiniciar1vs1();
					new Ventana1vs1();
					dispose();
					
					log.info("Modo 1vs1 reiniciado con exito");
					
				} catch (FileNotFoundException e1) {
					log.warning(String.format("Error intentando reiniciar el Modo 1vs1",e1.getMessage()));
				}
				
			}
		});
		
		modoClasico.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ReiniciarClasico();
					new VentanaModoClasico();
					dispose();
					
					log.info("Modo Clasico reiniciado con exito");
					
				} catch (FileNotFoundException e1) {
					log.warning(String.format("Error intentando reiniciar el Modo Clasico",e1.getMessage()));
				}
				
				
			}
		});
		
		//DISEÑO DE LA VENTANA		
		JPanel panel= new JPanel(); 
		panel.setLayout(new GridLayout(4,1));
		
		panel.add(modoClasico);
		panel.add(modoContrarreloj);
		panel.add(modoMuerteSubita);
		panel.add(modo1vs1);
		
		
		this.add(panel);
		this.setTitle("Selector de Modo de Juego");
		this.setSize(800, 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
	}

}
