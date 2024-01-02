package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class VentanaHasGanado1vs1 extends VentanaHasGanadoClasico {

	private void ReiniciarJuego() {
		Ventana1vs1.panelGeneral.removeAll();
		Ventana1vs1.panelAbecedarioDerecha.removeAll();
		Ventana1vs1.panelAbecedarioIzquierda.removeAll();
		Ventana1vs1.panelArribaDerecha.removeAll();
		Ventana1vs1.panelArribaIzquierda.removeAll();
		Ventana1vs1.panelIzquierdaDerecha.removeAll();
		Ventana1vs1.panelIzquierdaIzquierda.removeAll();
		Ventana1vs1.palabraSeleccionadaDerecha = Ventana1vs1.SeleccionarPalabra();
		Ventana1vs1.palabraSeleccionada = Ventana1vs1.SeleccionarPalabra();
		Ventana1vs1.textoLabelDerecha = Ventana1vs1.ocultarPalabra(Ventana1vs1.palabraSeleccionadaDerecha);
		Ventana1vs1.textoLabel = Ventana1vs1.ocultarPalabra(Ventana1vs1.palabraSeleccionada);
		Ventana1vs1.letrasPalabraDerecha.clear();
		Ventana1vs1.letrasPalabraDerecha.addAll(Ventana1vs1.añadirLetras());
		Ventana1vs1.letrasPalabra.clear();
		Ventana1vs1.letrasPalabra.addAll(Ventana1vs1.añadirLetras());
		Ventana1vs1.palabraOcultaDerecha.setText(Ventana1vs1.textoLabelDerecha.toString());
		Ventana1vs1.palabraOculta.setText(Ventana1vs1.textoLabel.toString());
	}

	public VentanaHasGanado1vs1() {
		ActionListener[] listeners = botonVolverJugar.getActionListeners();

		for (ActionListener actionListener : listeners) {
			botonVolverJugar.removeActionListener(actionListener);
		}

		botonVolverJugar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ReiniciarJuego();
					new Ventana1vs1();
					dispose();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
}
