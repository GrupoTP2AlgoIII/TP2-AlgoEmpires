package controlador.boton;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import vista.ContenedorPrincipal;

public class BotonOKEventHandler implements EventHandler<ActionEvent> {

    private TextField jugador1;
    private TextField jugador2;
    private Label etiqueta; 
    private Stage stage;

    public BotonOKEventHandler(Stage stage, TextField nombreJ1Ingresado, TextField nombreJ2Ingresado, Label etiquetaJ1, Label etiquetaJ2) {
    	super();
        this.jugador1 = nombreJ1Ingresado;
        this.jugador2 = nombreJ2Ingresado;
        this.etiqueta = new Label();
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
    	
        if (this.jugador1.getText().trim().equals("") || this.jugador2.getText().trim().equals("")) {

            this.etiqueta.setText("Debe ingresar un texto");
            this.etiqueta.setTextFill(Color.web("#FF0000"));
        }
       
        else {
        	ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(jugador1.getText(), jugador2.getText());
        	contenedorPrincipal.autosize();
        	HBox ventanaJuego = new HBox ();
        	ventanaJuego.autosize();
        	ventanaJuego.getChildren().add(contenedorPrincipal);
        	Scene scene = new Scene (ventanaJuego);
            stage.setResizable(false);
        	this.stage.setScene(scene);    	
        }		
    }
    		
    
}
