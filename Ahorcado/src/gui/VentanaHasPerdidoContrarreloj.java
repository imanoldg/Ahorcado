package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class VentanaHasPerdidoContrarreloj extends VentanaHasPerdidoClasico{

	private void ReiniciarJuego() {
		VentanaModoContrarreloj.panelAbecedario.removeAll();
		VentanaModoContrarreloj.panelArriba.removeAll();
		VentanaModoContrarreloj.panelIzquierda.removeAll();
		VentanaModoContrarreloj.palabraSeleccionada = VentanaModoContrarreloj.SeleccionarPalabra();
		VentanaModoContrarreloj.textoLabel = VentanaModoContrarreloj
				.ocultarPalabra(VentanaModoContrarreloj.palabraSeleccionada);
		VentanaModoContrarreloj.letrasPalabra.clear();
		VentanaModoContrarreloj.letrasPalabra.addAll(VentanaModoContrarreloj.añadirLetras());
		VentanaModoContrarreloj.palabraOculta.setText(VentanaModoContrarreloj.textoLabel.toString());
		VentanaModoContrarreloj.etiqueta.removeAll();
	}

	public VentanaHasPerdidoContrarreloj() {
		ActionListener[] listeners = botonVolverJugar.getActionListeners();

		for (ActionListener actionListener : listeners) {
			botonVolverJugar.removeActionListener(actionListener);
		}

		botonVolverJugar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ReiniciarJuego();
					new VentanaModoContrarreloj();
					dispose();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
	
}
