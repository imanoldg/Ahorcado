package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaResolver extends JFrame{
	private JTextField textoResolver = new JTextField(15);
	private JLabel labelResolver = new JLabel("Introduce la palabra: ");
	
	public VentanaResolver() {
		JPanel panel = new JPanel();
		
		panel.add(labelResolver);
		panel.add(textoResolver);

		this.add(panel);
		this.setTitle("Resolver Palabra");
		this.setSize(400, 100);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
	}
	
	
	
	public static void main(String[] args) {
		new VentanaResolver();
	}
}
