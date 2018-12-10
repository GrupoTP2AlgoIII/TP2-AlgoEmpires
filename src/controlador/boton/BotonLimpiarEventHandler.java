package controlador.boton;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

public class BotonLimpiarEventHandler implements EventHandler<ActionEvent> {

    private TextField nombreJugador1;
    private TextField nombreJugador2;

    public BotonLimpiarEventHandler(TextField nombreJ1, TextField nombreJ2) {
        this.nombreJugador1 = nombreJ1;
        this.nombreJugador2 = nombreJ2;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        this.nombreJugador1.setText("");
        this.nombreJugador2.setText("");
        this.nombreJugador1.requestFocus();
        this.nombreJugador2.requestFocus();
    }
}
