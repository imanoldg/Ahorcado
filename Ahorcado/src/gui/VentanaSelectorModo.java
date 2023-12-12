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

public class VentanaSelectorModo extends JFrame{
	private JButton modoContrarreloj = new JButton("Modo Contrarreloj");
	private JButton modoMuerteSubita = new JButton("Modo Muerte Súbita");
	private JButton modo1vs1 = new JButton("Modo 1vs1");
	private JButton modoClasico = new JButton("Modo Clasico");
	
	public VentanaSelectorModo(){	
		//ACCIONES DE CADA BOTON (PARA ABIR EL RESTO DE VENATANAS)
		modoContrarreloj.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new VentanaModoContrarreloj();
					VentanaModoClasico.ReiniciarJuego();
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
					new VentanaModoMuerteSubita();
					VentanaModoClasico.ReiniciarJuego();
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
					VentanaModoClasico.ReiniciarJuego();
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
					new VentanaModoClasico();
					VentanaModoClasico.ReiniciarJuego();
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
