package controlador.boton;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorMenuConstruirPlazaCentral implements EventHandler<ActionEvent> {


	@Override
	public void handle(ActionEvent event) {
		new ControladorCrearEdificio('P').crear();	
	}
}
