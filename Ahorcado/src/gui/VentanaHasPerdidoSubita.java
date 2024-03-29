package gui;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.logging.Logger;



import io.LoggerReg;

public class VentanaHasPerdidoSubita extends VentanaHasPerdidoClasico{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerReg.ejecutarLogger();
	
	//Metodo para reiniciar el Modo Muerte Subita
	private void ReiniciarJuego() {
		VentanaModoMuerteSubita.palabraSeleccionada = VentanaModoMuerteSubita.SeleccionarPalabra();
		VentanaModoMuerteSubita.textoLabel = VentanaModoMuerteSubita.ocultarPalabra(VentanaModoMuerteSubita.palabraSeleccionada.getPalabra());
		VentanaModoMuerteSubita.letrasPalabra.clear();
		VentanaModoMuerteSubita.letrasPalabra.addAll(VentanaModoMuerteSubita.añadirLetras());
		VentanaModoMuerteSubita.palabraOculta.setText(VentanaModoMuerteSubita.textoLabel.toString());
		VentanaModoMuerteSubita.panelAbecedario.removeAll();
		VentanaModoMuerteSubita.adivinadasLabel.removeAll();
		VentanaModoMuerteSubita.panelArriba.removeAll();
		VentanaModoMuerteSubita.panelIzquierda.removeAll();
		VentanaModoMuerteSubita.panelDerecha.removeAll();
	}
	
	//Inicializacion de la ventana
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
					Window[] windows = getWindows();

				    for (Window window : windows)
				    {
				        
				            window.dispose();
				        
				    }
				    
				    new VentanaModoMuerteSubita();
					
					log.info("Modo Muerte Subita reiniciado con exito");
					
				} catch (FileNotFoundException e1) {
					log.warning(String.format("Error intentando reiniciar el Modo Muerte Subita: %s", e1.getMessage()));
				}
			}
		});
		
	}
}
