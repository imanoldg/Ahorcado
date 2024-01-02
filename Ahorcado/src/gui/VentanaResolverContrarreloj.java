package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaResolverContrarreloj extends VentanaResolverClasico {

	public VentanaResolverContrarreloj() {
		ActionListener[] listeners = botonAceptar.getActionListeners();

		for (ActionListener actionListener : listeners) {
			botonAceptar.removeActionListener(actionListener);
		}

		botonAceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (VentanaModoClasico.palabraSeleccionada.toUpperCase()
						.equals(textoResolver.getText().toUpperCase())) {
					new VentanaHasGanadoContrarreloj();
					dispose();
				} else {
					new VentanaHasPerdidoContrarreloj();
				}

			}
		});
	}

}
