package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class VentanaUsuarios extends JFrame{
	
	private JLabel tituloJuego;
	private JTextField user; 
	private JPasswordField password;
	private JLabel textoUser;
	private JLabel textoPassword;
	private JButton singIn;
	private JButton singUp;
	
	
	public VentanaUsuarios(){
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setLayout(new GridLayout(1,1));
		JPanel panelSesion = new JPanel();
		panelSesion.setLayout(null);
		JPanel inUp = new JPanel();
		inUp.setLayout(new GridLayout(1,2));
		
		ImageIcon tituloImagen = new ImageIcon("resources/images/tituloAhorcadoFoto.png");
		ImageIcon minImagen = new ImageIcon(tituloImagen.getImage().getScaledInstance(300, 80, Image.SCALE_SMOOTH));
		JLabel labelTitulo = new JLabel(minImagen);
		panelTitulo.add(labelTitulo, BorderLayout.NORTH);

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
		
		singIn = new JButton("Inciar sesión");
		singUp = new JButton("Registrarse");
		inUp.add(singIn);
		inUp.add(singUp);
		
		singIn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaSelectorModo v = new VentanaSelectorModo();
				VentanaError vError = new VentanaError();
				String u1 = "simon";
				String c1 = "rodilla";
				String usuario = user.getText();
				String contra = password.getText();
				if((e.getSource() == singIn) && ((usuario.equals(u1)) && (contra.equals(c1)))) {
					dispose();
					v.setVisible(true);
				}else {
					vError.setVisible(true);
				}				
			}
		});
		
		singUp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == singUp) {
					dispose();
					VentanaRegistro reg = new VentanaRegistro();
					reg.setVisible(true);
				}
			}
		});
		
		add(panelTitulo, BorderLayout.NORTH);
		add(panelSesion, BorderLayout.CENTER);
		add(inUp, BorderLayout.SOUTH);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(0,0,400,500);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new VentanaUsuarios();
		
	}

	
}