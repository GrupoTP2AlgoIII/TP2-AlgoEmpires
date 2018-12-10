package controlador.boton;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.mapa.Posicion;
import vista.ContenedorDatosPosicionable;
import vista.ContenedorMensajesJuego;
import vista.ContenedorPrincipal;

public class ControladorMenuAtacar implements EventHandler<ActionEvent> {

	
	private Posicion posicionActual;
	private Posicion posicionAAtacar;
	
	@Override
	public void handle(ActionEvent event) {
		int ladoAreaAtaque = (ContenedorDatosPosicionable.getInstance().getNumeroRango()*2)+1;
		ControladorSeleccionUsuarioDesdeHasta controlador = new ControladorSeleccionUsuarioDesdeHasta(posicionActual,
				posicionAAtacar,ladoAreaAtaque);		
		this.posicionActual = controlador.getDesdeCalculada();
		this.posicionAAtacar = controlador.getHastaCalculada();
		
		try {
			ContenedorPrincipal.getInstance().getJuego().obtenerJugadorActual().atacar(posicionActual,posicionAAtacar);
			ContenedorPrincipal.getInstance().getJuego().actualizarJuego();
			ContenedorPrincipal.getInstance().actualizarSinLimpiarConsola();
			ContenedorMensajesJuego.getInstance().agregarMensaje("Ataque exitoso");
		}catch (Exception e) {
			ContenedorMensajesJuego.getInstance().agregarMensaje("Error al atacar");
		}
		}

}
