package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class VentanaGestionUsuario extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton borrarUsuario;
	private JButton cambiarUsuario;
	
	public VentanaGestionUsuario(){
		
		JPanel panelBotones = new JPanel();
		panelBotones.setLayout(new GridLayout(1,2));
	
		
		borrarUsuario = new JButton("Borrar usuario");
		cambiarUsuario = new JButton("cambiar usuario");
		panelBotones.add(borrarUsuario);
		panelBotones.add(cambiarUsuario);
		
		borrarUsuario.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaBorrarUsuario delete = new VentanaBorrarUsuario();
				delete.setVisible(true);
				dispose();
				
			}
		});
		
		cambiarUsuario.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaCambiarUsuario change = new VentanaCambiarUsuario();
				change.setVisible(true);
				dispose();
				
			}
		});
		
		add(panelBotones, BorderLayout.CENTER);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(0,0,400,100);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
