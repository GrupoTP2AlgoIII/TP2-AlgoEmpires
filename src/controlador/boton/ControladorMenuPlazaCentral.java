package controlador.boton;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class ControladorMenuPlazaCentral implements EventHandler<ActionEvent> {

	
	@Override
	public void handle(ActionEvent event) {	
		new ControladorCrearUnidad('O').crear();
	}

}
