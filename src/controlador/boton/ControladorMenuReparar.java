package controlador.boton;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.jugador.PosicionDesocupadaError;
import modelo.jugador.PosicionNoPerteneceAJugadorException;
import modelo.jugador.PosicionNoPerteneceAPoblacionError;
import modelo.mapa.Posicion;
import modelo.unidad.aldeano.AldeanoOcupadoException;
import modelo.vacio.PosicionableVacioNoPuedeSerAtacadoException;
import vista.ContenedorMensajesJuego;
import vista.ContenedorPrincipal;

public class ControladorMenuReparar implements EventHandler<ActionEvent> {

	private Posicion posicionActual;
	private Posicion posicionAReparar;
	
	@Override
	public void handle(ActionEvent event) {
		int ladoAreaAtaque = 3;
		ControladorSeleccionUsuarioDesdeHasta controlador = new ControladorSeleccionUsuarioDesdeHasta(posicionActual,
				posicionAReparar,ladoAreaAtaque);		
		this.posicionActual = controlador.getDesdeCalculada();
		this.posicionAReparar = controlador.getHastaCalculada();
		
		try {
			ContenedorPrincipal.getInstance().getJuego().obtenerJugadorActual().reparar(posicionActual,posicionAReparar);
			ContenedorPrincipal.getInstance().getJuego().actualizarJuego();
			ContenedorPrincipal.getInstance().actualizarSinLimpiarConsola();
			ContenedorMensajesJuego.getInstance().agregarMensaje("Reparacion exitosa,reparando..");
		}catch (PosicionableVacioNoPuedeSerAtacadoException e) {
			ContenedorMensajesJuego.getInstance().agregarMensaje("Error al reparar,la posicion esta vacia");
		}catch (PosicionNoPerteneceAPoblacionError e) {
			ContenedorMensajesJuego.getInstance().agregarMensaje("Error al reparar,la unidad no pertence al jugador");
		}catch (PosicionNoPerteneceAJugadorException e) {
			ContenedorMensajesJuego.getInstance().agregarMensaje("Error al reparar,la unidad no pertence al jugador");
		}catch (AldeanoOcupadoException e) {
			ContenedorMensajesJuego.getInstance().agregarMensaje("Error al reparar,el aldeano esta ocupado");
		}catch (PosicionDesocupadaError e) {
			ContenedorMensajesJuego.getInstance().agregarMensaje("Error al reparar,posicion vacia");
		}catch (Exception e) {
			ContenedorMensajesJuego.getInstance().agregarMensaje("Error al reparar");
		}
		}

}
