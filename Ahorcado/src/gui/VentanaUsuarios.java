package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaUsuarios extends JFrame{
	
	private JLabel tituloJuego;
	private JTextField user; 
	private JTextField password;
	private JLabel textoUser;
	private JLabel textoPassword;
	private JButton singIn;
	private JButton singUp;
	
	
	public VentanaUsuarios(){
		
		JPanel panelSesion = new JPanel();
		panelSesion.setLayout(null);
		JPanel inUp = new JPanel();
		inUp.setLayout(new GridLayout(2,1));
		
		tituloJuego = new JLabel("EL AHORCADO");
        tituloJuego.setBounds(148, 20, 300, 30); 
        add(tituloJuego);

        textoUser = new JLabel("Usuario: ");
        textoUser.setBounds(90, 60, 200, 30); 
        panelSesion.add(textoUser);

        textoPassword = new JLabel("Contraseña: ");
        textoPassword.setBounds(68, 100, 200, 30); 
        panelSesion.add(textoPassword);

        user = new JTextField();
        user.setBounds(140, 65, 150, 20); 
        panelSesion.add(user);

        password = new JTextField();
        password.setBounds(140, 105, 150, 20); 
        panelSesion.add(password);
		
		singIn = new JButton("Inciar sesión");
		singUp = new JButton("Registrarse");
		inUp.add(singIn);
		inUp.add(singUp);
		
		
		add(panelSesion, BorderLayout.CENTER);
		add(inUp, BorderLayout.SOUTH);
		
		
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setBounds(0,0,400,500);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		new VentanaUsuarios();
		
	}

	
}