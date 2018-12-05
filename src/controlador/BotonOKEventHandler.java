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
    private Label labelJ1;
    private Label labelJ2;
    
    private Stage stage;

    public BotonOKEventHandler(Stage stage, TextField nombreJ1Ingresado, TextField nombreJ2Ingresado, Label etiquetaJ1, Label etiquetaJ2) {
    	super();
        this.jugador1 = nombreJ1Ingresado;
        this.jugador2 = nombreJ2Ingresado;
        this.labelJ1 = etiquetaJ1;
        this.labelJ2 = etiquetaJ2;
        this.stage = stage;
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
        
    		VistaJuego vistaJuego = new VistaJuego(jugador1.getText(), jugador2.getText());
    		Scene scene = new Scene (vistaJuego, 1200, 600);
    		this.stage.setScene(scene);    	
    	    		
    }
    		
    
}
