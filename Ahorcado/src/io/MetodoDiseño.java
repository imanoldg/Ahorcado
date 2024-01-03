package io;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class MetodoDiseño {
	
	private JTextField user; 
	private JPasswordField password;
	private JLabel textoUser;
	private JLabel textoPassword;
	
	public void metodoDiseño() {
		
		JPanel panelSesion = new JPanel();
		panelSesion.setLayout(null);
		
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
        
	}
	
}
