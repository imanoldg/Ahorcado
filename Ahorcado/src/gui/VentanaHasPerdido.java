package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaHasPerdido extends JFrame{

	public VentanaHasPerdido() {
		JPanel panelGeneral = new JPanel();
		panelGeneral.setLayout(new GridLayout(2,1));
		JPanel panelAbajo = new JPanel();
		
		ImageIcon imagen = new ImageIcon("");
		JLabel labelImagen = new JLabel(imagen);

		JButton botonSalir = new JButton("  Volver al selector de modo  ");
		JButton botonCerrar = new JButton("  Cerrar el juego  ");
		JButton botonVolverJugar = new JButton("  Volver a jugar  ");
		
		botonSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaSelectorModo();
				dispose();
				
			}
		});
		
		botonCerrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		
		botonVolverJugar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new VentanaModoClasico();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
				
			}
		});
		
		panelAbajo.add(botonVolverJugar);
		panelAbajo.add(botonSalir);
		panelAbajo.add(botonCerrar);

		
		panelGeneral.add(labelImagen, BorderLayout.NORTH);
		panelGeneral.add(panelAbajo, BorderLayout.SOUTH);

		
		this.add(panelGeneral, BorderLayout.CENTER);
		this.setTitle("Has Perdido");
		this.setSize(600,400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	}
	
	public static void main(String[] args) {
		new VentanaHasPerdido();
	}
}

