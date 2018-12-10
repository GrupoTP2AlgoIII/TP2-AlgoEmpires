package controlador.boton;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.mapa.Posicion;
import vista.ContenedorDatosPosicionable;
import vista.ContenedorMensajesJuego;
import vista.ContenedorPrincipal;

public class ControladorMenuMontar implements EventHandler<ActionEvent> {

	private Posicion posicionActual;
	
	@Override
	public void handle(ActionEvent event) {
		this.posicionActual = ContenedorDatosPosicionable.getInstance().getPosicion();	
		try {
			ContenedorPrincipal.getInstance().getJuego().obtenerJugadorActual().montarArmaDeAsedio(this.posicionActual);;
			ContenedorPrincipal.getInstance().actualizarSinLimpiarConsola();
			ContenedorMensajesJuego.getInstance().agregarMensaje("Exito al montar arma de asedio");
		}catch (Exception e) {
			ContenedorMensajesJuego.getInstance().agregarMensaje("Error al montar arma de asedio ");
		}
	}

}


