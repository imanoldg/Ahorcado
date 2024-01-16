package gui;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.logging.Logger;



import io.LoggerReg;

public class VentanaHasPerdido1vs1 extends VentanaHasPerdidoClasico{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerReg.ejecutarLogger();
	
	//Metodo para reiniciar el Modo 1vs1
	private void ReiniciarJuego() {
		Ventana1vs1.panelGeneral.removeAll();
		Ventana1vs1.panelAbecedarioDerecha.removeAll();
		Ventana1vs1.panelAbecedarioIzquierda.removeAll();
		Ventana1vs1.panelArribaDerecha.removeAll();
		Ventana1vs1.panelArribaIzquierda.removeAll();
		Ventana1vs1.panelIzquierdaDerecha.removeAll();
		Ventana1vs1.panelIzquierdaIzquierda.removeAll();
		Ventana1vs1.panelDerechaDerecha.removeAll();
		Ventana1vs1.panelDerechaIzquierda.removeAll();
		Ventana1vs1.palabraSeleccionadaDerecha = Ventana1vs1.SeleccionarPalabra();
		Ventana1vs1.palabraSeleccionada = Ventana1vs1.SeleccionarPalabra();
		Ventana1vs1.textoLabelDerecha = Ventana1vs1.ocultarPalabra(Ventana1vs1.palabraSeleccionadaDerecha.getPalabra());
		Ventana1vs1.textoLabel = Ventana1vs1.ocultarPalabra(Ventana1vs1.palabraSeleccionada.getPalabra());
		Ventana1vs1.letrasPalabraDerecha.clear();
		Ventana1vs1.letrasPalabraDerecha.addAll(Ventana1vs1.añadirLetras());
		Ventana1vs1.letrasPalabra.clear();
		Ventana1vs1.letrasPalabra.addAll(Ventana1vs1.añadirLetras());
		Ventana1vs1.palabraOcultaDerecha.setText(Ventana1vs1.textoLabelDerecha.toString());
		Ventana1vs1.palabraOculta.setText(Ventana1vs1.textoLabel.toString());
	}

	//Inicializacion de la ventana
	public VentanaHasPerdido1vs1() {
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
				    
				    new Ventana1vs1();
					
					log.info("Modo 1vs1 reiniciado con exito");
					
				} catch (FileNotFoundException e1) {
					log.warning(String.format("Error intenando reiniciar el Modo 1vs1: %s", e1.getMessage()));
				}
			}
		});
	}
}
