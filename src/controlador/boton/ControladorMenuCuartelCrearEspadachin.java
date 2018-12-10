package controlador.boton;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorMenuCuartelCrearEspadachin implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent event) {
		new ControladorCrearUnidad('E').crear();	
	}

}
