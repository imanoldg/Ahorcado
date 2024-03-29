package gui;

import java.awt.FlowLayout;
import java.awt.Image;
import javax.swing.*;

public class VentanaError extends JFrame {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel mensajeError;
    
    //Inicializacion de la ventana
	public VentanaError() {
        
        JPanel panelPrincipal = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        ImageIcon imagenError = new ImageIcon("resources/images/error.png");
        ImageIcon minImagen = new ImageIcon(imagenError.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        JLabel labelError = new JLabel(minImagen);
        labelError.setHorizontalAlignment(SwingConstants.CENTER);
        
        mensajeError = new JLabel("Error, usuario o contraseña incorrectos");
        mensajeError.setHorizontalAlignment(SwingConstants.CENTER);
        
        panelPrincipal.add(labelError);
        panelPrincipal.add(mensajeError);
        
        add(panelPrincipal);
        
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setTitle("Error");
        this.setBounds(0, 0, 400, 100);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }
    
    
}
