package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class VentanaCambiarUsuario extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton volverInicio;
	private JButton cambiar;
	
	private JTextField user; 
	private JPasswordField password;
	private JLabel textoUser;
	private JLabel textoPassword;
	
	//Inicializacion de la ventana
	public VentanaCambiarUsuario() {
		
		JPanel panelSesion = new JPanel();
		panelSesion.setLayout(null);
		JPanel panelVolverBorrar = new JPanel();
		panelVolverBorrar.setLayout(new GridLayout(1,2));
		
		textoUser = new JLabel("Usuario: ");
        textoUser.setBounds(90, 60, 200, 30); 
        panelSesion.add(textoUser);

        textoPassword = new JLabel("Contraseña: ");
        textoPassword.setBounds(68, 100, 200, 30); 
        panelSesion.add(textoPassword);

        user = new JTextField();
        user.setBounds(142, 65, 150, 20); 
        panelSesion.add(user);

        password = new JPasswordField();
        password.setBounds(142, 105, 150, 20); 
        panelSesion.add(password);
        
        
		
        cambiar = new JButton("cambiar");
		volverInicio = new JButton("Volver al inicio");
		panelVolverBorrar.add(cambiar);
		panelVolverBorrar.add(volverInicio);
		
		
		cambiar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		volverInicio.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaUsuarios user = new VentanaUsuarios();
				user.setVisible(true);
				dispose();
			}
		});
		
		
		add(panelSesion, BorderLayout.CENTER);
		add(panelVolverBorrar, BorderLayout.SOUTH);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(0,0,400,500);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
}
