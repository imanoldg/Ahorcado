package Ahorcado;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class VentanaSelectorModo extends JFrame{
	JButton modoContrarreloj = new JButton("Modo Contrarreloj");
	JButton modoMuerteSubita = new JButton("Modo Muerte Subita");
	JButton modo1vs1 = new JButton("Modo 1vs1");
	JButton modoClasico = new JButton("Modo Clasico");
	
	public VentanaSelectorModo(){	
		//ACCIONES DE CADA BOTON (PARA ABIR EL RESTO DE VENATANAS)
		modoContrarreloj.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		modoMuerteSubita.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		modo1vs1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		modoClasico.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		//DISEÑO DE LA VENTAN
		JPanel panel= new JPanel(); 
		panel.setLayout(new GridLayout(4,1));
		
		panel.add(modoContrarreloj);
		panel.add(modoMuerteSubita);
		panel.add(modo1vs1);
		panel.add(modoClasico);
		
		this.add(panel);
		this.setTitle("Selector de Modo");
		this.setSize(400, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new VentanaSelectorModo();
				
			}
		});
				
	}
}
