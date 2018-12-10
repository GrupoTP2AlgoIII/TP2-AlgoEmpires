package controlador.boton;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.mapa.Posicion;
import modelo.unidad.Posicionable;
import vista.ContenedorDatosPosicionable;

public class ControladorPosicionable implements EventHandler<ActionEvent> {

	private Posicionable posicionable;
	private Posicion posicion;
	
	public ControladorPosicionable(Posicionable posicionable,Posicion posicion) {
		this.posicionable = posicionable;
		this.posicion = posicion;
	}
	
	@Override
	public void handle(ActionEvent arg0) {
		ContenedorDatosPosicionable.getInstance().actualizar(posicionable,posicion);

	}

}
