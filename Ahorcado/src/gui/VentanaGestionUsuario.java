package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaGestionUsuario extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton borrarUsuario;
	
	//Inicializacion de la ventana
	public VentanaGestionUsuario(){
		
		JPanel panelBotones = new JPanel();
		panelBotones.setLayout(new GridLayout(1,1));
	
		
		borrarUsuario = new JButton("Borrar usuario");
		panelBotones.add(borrarUsuario);
		
		borrarUsuario.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Window[] windows = getWindows();

			    for (Window window : windows)
			    {
			       
			            window.dispose();
			        
			    }
				
			    new VentanaBorrarUsuario();
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
