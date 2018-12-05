package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import vista.VistaJuego;

public class BotonOKEventHandler implements EventHandler<ActionEvent> {

    private TextField jugador1;
    private TextField jugador2;
    private Label etiqueta;
//    private Label labelJ1;
//    private Label labelJ2;
    
    private Stage stage;

    public BotonOKEventHandler(Stage stage, TextField nombreJ1Ingresado, TextField nombreJ2Ingresado, Label etiquetaJ1, Label etiquetaJ2) {
    	super();
        this.jugador1 = nombreJ1Ingresado;
        this.jugador2 = nombreJ2Ingresado;
        this.etiqueta = new Label();
//        this.labelJ1 = etiquetaJ1;
//        this.labelJ2 = etiquetaJ2;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
    	
    	// Este if no funciona
        if (this.jugador1.getText().trim().equals("") || this.jugador2.getText().trim().equals("")) {

            this.etiqueta.setText("Debe ingresar un texto");
            this.etiqueta.setTextFill(Color.web("#FF0000"));
        }
       
		VistaJuego vistaJuego = new VistaJuego(jugador1.getText(), jugador2.getText());
		Scene scene = new Scene (vistaJuego, 1200, 600);
		this.stage.setScene(scene);    	
	    		
    }
    		
    
}
