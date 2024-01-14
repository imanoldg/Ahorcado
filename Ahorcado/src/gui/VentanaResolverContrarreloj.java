package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import domain.Palabra.Dificultad;

public class VentanaResolverContrarreloj extends VentanaResolverClasico {

	public VentanaResolverContrarreloj() {
		ActionListener[] listeners = botonAceptar.getActionListeners();

		for (ActionListener actionListener : listeners) {
			botonAceptar.removeActionListener(actionListener);
		}

		botonAceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (VentanaModoContrarreloj.palabraSeleccionada.getPalabra().toUpperCase()
						.equals(textoResolver.getText().toUpperCase())) {
					new VentanaHasGanadoContrarreloj();
					
					if (VentanaModoContrarreloj.palabraSeleccionada.getDificultad().equals(Dificultad.DIFICIL)) {
						VentanaModoContrarreloj.puntuacionContrarreloj = VentanaModoContrarreloj.puntuacionContrarreloj + 50 + 
								VentanaModoContrarreloj.palabraSeleccionada.getPalabra().length();
						VentanaModoContrarreloj.usuarioJugando.setPuntuacionClasico(VentanaModoContrarreloj.puntuacionContrarreloj);
					} else {
						VentanaModoContrarreloj.puntuacionContrarreloj = VentanaModoContrarreloj.puntuacionContrarreloj + 25 + 
								VentanaModoContrarreloj. palabraSeleccionada.getPalabra().length();
						VentanaModoContrarreloj.usuarioJugando.setPuntuacionClasico(VentanaModoContrarreloj.puntuacionContrarreloj);
					}
					
					dispose();
				} else {
					new VentanaHasPerdidoContrarreloj();
				}

			}
		});
	}

}
