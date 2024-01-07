package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class VentanaHasPerdidoSubita extends VentanaHasPerdidoClasico{

	private void ReiniciarJuego() {
		VentanaModoMuerteSubita.palabraSeleccionada = VentanaModoMuerteSubita.SeleccionarPalabra();
		VentanaModoMuerteSubita.textoLabel = VentanaModoMuerteSubita.ocultarPalabra(VentanaModoMuerteSubita.palabraSeleccionada);
		VentanaModoMuerteSubita.letrasPalabra.clear();
		VentanaModoMuerteSubita.letrasPalabra.addAll(VentanaModoMuerteSubita.añadirLetras());
		VentanaModoMuerteSubita.palabraOculta.setText(VentanaModoMuerteSubita.textoLabel.toString());
		VentanaModoMuerteSubita.panelAbecedario.removeAll();
		VentanaModoMuerteSubita.adivinadasLabel.removeAll();
		VentanaModoMuerteSubita.panelArriba.removeAll();
		VentanaModoMuerteSubita.panelIzquierda.removeAll();
		VentanaModoMuerteSubita.panelDerecha.removeAll();
	}
	
	public VentanaHasPerdidoSubita() {
		ActionListener[] listeners = botonVolverJugar.getActionListeners();
		
		for (ActionListener actionListener : listeners) {
			botonVolverJugar.removeActionListener(actionListener);
		}
		
		botonVolverJugar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ReiniciarJuego();
					new VentanaModoMuerteSubita();
					dispose();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
	}
}
