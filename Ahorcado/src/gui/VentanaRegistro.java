package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import DataBase.MetodosBD;

public class VentanaRegistro extends JFrame{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel titulo;
	private JLabel user;
	private JLabel password;
	private JTextField textoUser;
	private JPasswordField textoPassword1;
	private JButton botonRegistrar;
	private JButton returnSingIn;
	
	MetodosBD metodos = new MetodosBD();
	
	//Se inicializa la ventana
	public VentanaRegistro() {
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setLayout(new GridLayout(1,1));
		JPanel panel1 = new JPanel();
		panel1.setLayout(null);
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(1,2));
		
		titulo = new JLabel("Registro de usuario");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		panelTitulo.add(titulo);
		
		//error = new JLabel("la contraseña no es igual");
		//error.setVisible(false);
		//panel2.add(error);
		
		
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
		
		/*
		repPassword = new JLabel("Repetir contraseña: ");
		repPassword.setBounds(26, 133, 200, 30);
		panel1.add(repPassword);
		*/
		
		textoPassword1 = new JPasswordField();
		textoPassword1.setBounds(141, 105, 150, 20); 
        panel1.add(textoPassword1);
        
        /*
        textoPassword2 = new JPasswordField();
        textoPassword2.setBounds(141, 138, 150, 20); 
        panel1.add(textoPassword2);
        */
        
        /*
        if (password.equals(repPassword)) {
        	error.setVisible(true);
        }
        */
 
        // Botón
        
        MetodosBD metodos = new MetodosBD();
        botonRegistrar = new JButton("Registrarse");
        botonRegistrar.addActionListener(new ActionListener() {
        
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				@SuppressWarnings("deprecation")
				int i = metodos.guardar(MetodosBD.generarNuevoCod(MetodosBD.generarCod()), textoUser.getText(), textoPassword1.getText(), 0, 0, 0);
				
				if (i > 0) {
					JOptionPane.showMessageDialog(VentanaRegistro.this, "se ha guardado correctamente");
				}else {
					JOptionPane.showMessageDialog(VentanaRegistro.this, "no se ha podido guardar o el usuario ya existe");
				}
			}
		});
        panel2.add(botonRegistrar);
        
        returnSingIn = new JButton("Volver");
        returnSingIn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == returnSingIn) {
					Window[] windows = getWindows();

				    for (Window window : windows)
				    {
				        
				            window.dispose();
				        
				    }
				    
				    new VentanaUsuarios();
				}
			}
		});
        panel2.add(returnSingIn);
        
        
		// paneles y ventana
        
        add(panelTitulo, BorderLayout.NORTH);
		add(panel1, BorderLayout.CENTER);
		add(panel2, BorderLayout.SOUTH);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Registro de usuario");
		this.setBounds(0,0,400,500);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	
}
