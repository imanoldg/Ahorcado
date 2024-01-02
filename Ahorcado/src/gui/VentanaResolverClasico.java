package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaResolverClasico extends JFrame{
	public static JTextField textoResolver = new JTextField(25);
	public static JButton botonAceptar = new JButton("Aceptar");
	public static String palabra;
	private JLabel labelResolver = new JLabel("Introduce la palabra: ");
	
	
	public VentanaResolverClasico() {
		JPanel panel = new JPanel();
		
		panel.add(labelResolver);
		panel.add(textoResolver);
		panel.add(botonAceptar);
		
		botonAceptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (VentanaModoClasico.palabraSeleccionada.toUpperCase().equals(textoResolver.getText().toUpperCase())) {
					new VentanaHasGanadoClasico();
					dispose();
				} else {
					new VentanaHasPerdidoClasico();
				}
				
			}
		});
		

		this.add(panel);
		this.setTitle("Resolver Palabra");
		this.setSize(400, 100);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
	}
	
	
	
}
