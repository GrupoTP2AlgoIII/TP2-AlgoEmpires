package controlador.boton;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.jugador.PosicionNoPerteneceAJugadorException;
import modelo.jugador.PosicionNoPerteneceAPoblacionError;
import modelo.mapa.Posicion;
import vista.ContenedorDatosPosicionable;
import vista.ContenedorMensajesJuego;
import vista.ContenedorPrincipal;

public class ControladorMenuDesmontar implements EventHandler<ActionEvent> {

	private Posicion posicionActual;
	
	@Override
	public void handle(ActionEvent event) {
		this.posicionActual = ContenedorDatosPosicionable.getInstance().getPosicion();	
		try {
			ContenedorPrincipal.getInstance().getJuego().obtenerJugadorActual().desmontarArmaDeAsedio(this.posicionActual);
			ContenedorPrincipal.getInstance().actualizarSinLimpiarConsola();
			ContenedorMensajesJuego.getInstance().agregarMensaje("Exito al desmontar arma de asedio");
		}catch (PosicionNoPerteneceAJugadorException e) {
			ContenedorMensajesJuego.getInstance().agregarMensaje("Error al desmontar arma de asedio,la unidad no pertence al jugador ");
		}catch (PosicionNoPerteneceAPoblacionError e) {
			ContenedorMensajesJuego.getInstance().agregarMensaje("Error al desmontar arma de asedio,la unidad no pertence al jugador ");
		}catch (Exception e) {
			ContenedorMensajesJuego.getInstance().agregarMensaje("Error al desmontar arma de asedio ");
		}
	}

}
