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

public class VentanaHasPerdidoClasico extends JFrame{

	public static JButton botonCerrar = new JButton("  Cerrar el juego  ");
	public static JButton botonVolverJugar = new JButton("  Volver a jugar  ");
	
	private void ReiniciarJuego() {
		VentanaModoClasico.panelAbecedario.removeAll();
		VentanaModoClasico.panelArriba.removeAll();
		VentanaModoClasico.panelIzquierda.removeAll();
		VentanaModoClasico.palabraSeleccionada = VentanaModoClasico.SeleccionarPalabra();
		VentanaModoClasico.textoLabel = VentanaModoClasico.ocultarPalabra(VentanaModoClasico.palabraSeleccionada);
		VentanaModoClasico.letrasPalabra.clear();
		VentanaModoClasico.letrasPalabra.addAll(VentanaModoClasico.añadirLetras());
		VentanaModoClasico.palabraOculta.setText(VentanaModoClasico.textoLabel.toString());;
	}
	
	public VentanaHasPerdidoClasico() {
		JPanel panelGeneral = new JPanel();
		panelGeneral.setLayout(new GridLayout(2,1));
		JPanel panelAbajo = new JPanel();
		
		ImageIcon imagen = new ImageIcon("");
		JLabel labelImagen = new JLabel(imagen);
		
		
		
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
					ReiniciarJuego();
					new VentanaModoClasico();
					dispose();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		
		panelAbajo.add(botonVolverJugar);
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
		new VentanaHasPerdidoClasico();
	}
}

