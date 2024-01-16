package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import DataBase.MetodosBD;

public class VentanaBorrarUsuario extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton volverInicio;
	private JButton borrar;

	private JTextField user; 
	private JPasswordField password;
	private JLabel textoUser;
	private JLabel textoPassword;
	
	
	//Inicializacion de la ventana
	public VentanaBorrarUsuario() {
		
		
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
        
        
		
        borrar = new JButton("Eliminar");
		volverInicio = new JButton("Volver al inicio");
		panelVolverBorrar.add(borrar);
		panelVolverBorrar.add(volverInicio);
		
		MetodosBD metodos = new MetodosBD();
		
		borrar.addActionListener(new ActionListener() {
			
			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("deprecation")
				String busquedaUsuario =  metodos.registeredUser(user.getText(), password.getText());
				int i = metodos.borrarUsuario(busquedaUsuario);
				
				if (i > 0) {
					String usuarioBusqueda = metodos.buscarUsuario(user.getText());
					int usuarioBorrado = metodos.borrarUsuario(usuarioBusqueda);
					JOptionPane.showMessageDialog(VentanaBorrarUsuario.this, "usuario borrado");
				}else {
					JOptionPane.showMessageDialog(VentanaBorrarUsuario.this, "usuario o contraseña incorrectos");
				}
				
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
