package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class BotonOKEventHandler implements EventHandler<ActionEvent> {

    private TextField jugador1;
    private TextField jugador2;
    private Label labelJ1;
    private Label labelJ2;

    public BotonOKEventHandler(TextField nombreJ1Ingresado, TextField nombreJ2Ingresado, Label etiquetaJ1, Label etiquetaJ2) {
    	super();
        this.jugador1 = nombreJ1Ingresado;
        this.jugador2 = nombreJ2Ingresado;
        this.labelJ1 = etiquetaJ1;
        this.labelJ2 = etiquetaJ2;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        if (this.jugador1.getText().trim().equals("")) {

            this.labelJ1.setText("Debe ingresar un nombre");
            this.labelJ1.setTextFill(Color.web("#FF0000"));

        }
        
        else if (this.jugador2.getText().trim().equals("")) {
        	
            this.labelJ2.setText("Debe ingresar un nombre");
            this.labelJ2.setTextFill(Color.web("#FF0000"));       	
        	
        }
        
        else {
            this.labelJ1.setText(this.jugador1.getText());
            this.labelJ1.setTextFill(Color.web("#336600"));
            this.labelJ2.setText(this.jugador2.getText());
            this.labelJ2.setTextFill(Color.web("#336600"));
        }
    }
}
