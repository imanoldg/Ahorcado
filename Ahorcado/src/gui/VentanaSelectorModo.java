package gui;


import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import gui.VentanaModoMuerteSubita.BotonSubitaListener;

public class VentanaSelectorModo extends JFrame{
	private JButton modoContrarreloj = new JButton("Modo Contrarreloj");
	private JButton modoMuerteSubita = new JButton("Modo Muerte Súbita");
	private JButton modo1vs1 = new JButton("Modo 1vs1");
	private JButton modoClasico = new JButton("Modo Clasico");
	
	private void ReiniciarClasico() {
		VentanaModoClasico.panelAbecedario.removeAll();
		VentanaModoClasico.panelArriba.removeAll();
		VentanaModoClasico.panelIzquierda.removeAll();
		VentanaModoClasico.palabraSeleccionada = VentanaModoClasico.SeleccionarPalabra();
		VentanaModoClasico.textoLabel = VentanaModoClasico.ocultarPalabra(VentanaModoClasico.palabraSeleccionada);
		VentanaModoClasico.letrasPalabra.clear();
		VentanaModoClasico.letrasPalabra.addAll(VentanaModoClasico.añadirLetras());
		VentanaModoClasico.palabraOculta.setText(VentanaModoClasico.textoLabel.toString());;
	}
	
	private void ReiniciarSubita() {
		VentanaModoMuerteSubita.palabraSeleccionada = VentanaModoMuerteSubita.SeleccionarPalabra();
		VentanaModoMuerteSubita.textoLabel = VentanaModoMuerteSubita.ocultarPalabra(VentanaModoMuerteSubita.palabraSeleccionada);
		VentanaModoMuerteSubita.letrasPalabra.clear();
		VentanaModoMuerteSubita.letrasPalabra.addAll(VentanaModoMuerteSubita.añadirLetras());
		VentanaModoMuerteSubita.palabraOculta.setText(VentanaModoMuerteSubita.textoLabel.toString());;
		VentanaModoMuerteSubita.panelAbecedario.removeAll();
		VentanaModoMuerteSubita.adivinadasLabel.removeAll();
	}
	
	public VentanaSelectorModo(){	
		//ACCIONES DE CADA BOTON (PARA ABIR EL RESTO DE VENATANAS)
		modoContrarreloj.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new VentanaModoContrarreloj();
					dispose();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
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
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
				}
				
			}
		});
		
		modo1vs1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new Ventana1vs1();
					dispose();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
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
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
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
