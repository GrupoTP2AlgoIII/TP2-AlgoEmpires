package controlador.boton;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class TextoEventHandler implements EventHandler<KeyEvent> {

    private Button botonOK;

    public TextoEventHandler(Button botonOK) {
        this.botonOK = botonOK;
    }

    @Override
    public void handle(KeyEvent event) {

        if (event.getCode() == KeyCode.ENTER) {
            Event.fireEvent(botonOK, new ActionEvent());
        }
    }
}
