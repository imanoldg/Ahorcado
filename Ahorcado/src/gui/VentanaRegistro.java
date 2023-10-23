package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class VentanaRegistro extends JFrame{
	
	private JLabel titulo;
	private JLabel user;
	private JLabel password;
	private JLabel repPassword;
	private JLabel error;
	private JTextField textoUser;
	private JPasswordField textoPassword1;
	private JPasswordField textoPassword2;
	private JButton botonRegistrar;
	
	public VentanaRegistro() {
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(null);
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(2,1));
		
		titulo = new JLabel("Registro de usuario");
		titulo.setBounds(130, 20, 300, 30);
		panel1.add(titulo);
		
		error = new JLabel("la contraseña no es igual");
		error.setVisible(false);
		panel2.add(error);
		
		
		// usuario
		
		user = new JLabel("Usuario: ");
		user.setBounds(90, 60, 200, 30);
		panel1.add(user);
		
		textoUser = new JTextField();
		textoUser.setBounds(141, 67, 150, 20);
		panel1.add(textoUser);
		
		// Contraseña
		
		password = new JLabel("Contraseña: ");
		password.setBounds(69, 100, 200, 30);
		panel1.add(password);
		
		repPassword = new JLabel("Repetir contraseña: ");
		repPassword.setBounds(26, 133, 200, 30);
		panel1.add(repPassword);
		
		textoPassword1 = new JPasswordField();
		textoPassword1.setBounds(141, 105, 150, 20); 
        panel1.add(textoPassword1);
        
        textoPassword2 = new JPasswordField();
        textoPassword2.setBounds(141, 138, 150, 20); 
        panel1.add(textoPassword2);
        
        if (password.equals(repPassword)) {
        	error.setVisible(true);
        }
        
        // Botón
        
        botonRegistrar = new JButton("Registrarse");
        panel2.add(botonRegistrar);
        
        
		// paneles y ventana
        
		add(panel1);
		add(panel2, BorderLayout.SOUTH);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Registro de usuario");
		this.setBounds(0,0,400,500);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new VentanaRegistro();
	}
}
