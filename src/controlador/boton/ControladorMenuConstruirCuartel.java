package controlador.boton;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorMenuConstruirCuartel implements EventHandler<ActionEvent> {
	
	@Override
	public void handle(ActionEvent event) {
		new ControladorCrearEdificio('C').crear();
	}

}
