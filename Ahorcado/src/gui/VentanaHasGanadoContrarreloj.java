package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.logging.Logger;

import io.LoggerReg;

public class VentanaHasGanadoContrarreloj extends VentanaHasGanadoClasico {

	private static Logger log = LoggerReg.ejecutarLogger();
	
	private void ReiniciarJuego() {
		VentanaModoContrarreloj.panelAbecedario.removeAll();
		VentanaModoContrarreloj.panelArriba.removeAll();
		VentanaModoContrarreloj.panelIzquierda.removeAll();
		VentanaModoContrarreloj.panelDerecha.removeAll();
		VentanaModoContrarreloj.palabraSeleccionada = VentanaModoContrarreloj.SeleccionarPalabra();
		VentanaModoContrarreloj.textoLabel = VentanaModoContrarreloj
				.ocultarPalabra(VentanaModoContrarreloj.palabraSeleccionada.getPalabra());
		VentanaModoContrarreloj.letrasPalabra.clear();
		VentanaModoContrarreloj.letrasPalabra.addAll(VentanaModoContrarreloj.añadirLetras());
		VentanaModoContrarreloj.palabraOculta.setText(VentanaModoContrarreloj.textoLabel.toString());
		VentanaModoContrarreloj.etiqueta.removeAll();
	}

	public VentanaHasGanadoContrarreloj() {
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
					
					log.info("Modo Contrarreloj reiniciado con exito");
					
				} catch (FileNotFoundException e1) {
					log.warning(String.format("Error reiniciando el Modo Contrarreloj: %s", e1.getMessage()));
				}
			}
		});
	}
}
