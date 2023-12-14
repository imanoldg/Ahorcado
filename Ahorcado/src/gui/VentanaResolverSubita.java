package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class VentanaResolverSubita extends VentanaResolverClasico{

	public VentanaResolverSubita() {
		ActionListener[] listeners = botonAceptar.getActionListeners();
		
		for (ActionListener actionListener : listeners) {
			botonAceptar.removeActionListener(actionListener);
		}
		
		botonAceptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (VentanaModoClasico.palabraSeleccionada.toUpperCase().equals(textoResolver.getText().toUpperCase())) {
					VentanaModoMuerteSubita.ReiniciarJuego();
					VentanaModoMuerteSubita.adivinadas++;
					VentanaModoMuerteSubita.adivinadasLabel.setText("Palabras adivinadas: " + VentanaModoMuerteSubita.adivinadas);
					dispose();
				} else {
					VentanaModoMuerteSubita ventanaModoMuerteSubita = null;
					try {
						ventanaModoMuerteSubita = new VentanaModoMuerteSubita();
						ventanaModoMuerteSubita.dispose();
						new VentanaHasPerdido();
						dispose();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				
			}
		});
		
	}
}
