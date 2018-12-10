package controlador.boton;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.mapa.Posicion;
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
		}catch (Exception e) {
			ContenedorMensajesJuego.getInstance().agregarMensaje("Error al reparar");
		}
		}

}
