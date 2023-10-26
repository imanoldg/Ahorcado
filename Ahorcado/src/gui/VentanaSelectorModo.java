package gui;


import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
				new VentanaModoContrarreloj();
				dispose();
			}
		});
		
		modoMuerteSubita.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaModoMuerteSubita();
				dispose();
			}
		});
		
		modo1vs1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Ventana1vs1();
				dispose();
			}
		});
		
		modoClasico.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaModoClasico();
				dispose();
				
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
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new VentanaSelectorModo();
				
			}
		});
				
	}
}
