package controlador.boton;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.juego.Juego;
import vista.ContenedorPrincipal;

public class ControladorAvanzarTurno implements EventHandler<ActionEvent> {

	private Juego juego;
	
	public ControladorAvanzarTurno(Juego juego) {
		this.juego = juego;
	}
	
	@Override
	public void handle(ActionEvent arg0) {
		this.juego.avanzarTurno();
		ContenedorPrincipal.getInstance().actualizar();
	}   

}
