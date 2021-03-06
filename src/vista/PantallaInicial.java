package vista;

import controlador.boton.BotonLimpiarEventHandler;
import controlador.boton.BotonOKEventHandler;
//import controlador.BotonOKEventHandler;
import controlador.boton.TextoEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PantallaInicial extends GridPane{
	
	// Referencia para hacer esto:
	// https://www.tutorialspoint.com/javafx/javafx_ui_controls.htm
	// Ejemplo de JavaFX de la catedra (botones)
	
	public PantallaInicial(Stage stage) {
		
		super();
		
		Image imagenFondo = new Image ("file:img/age-of-empires-definitive-edition-2.jpg");
		BackgroundImage fondo= new BackgroundImage(imagenFondo, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		this.setBackground(new Background(fondo));
			
		Label nombreLabel = new Label ("Jugador 1:");
		TextField nombreInput = new TextField();
		Label nombreLabel2 = new Label ("Jugador 2:");
		TextField nombreInput2 = new TextField();
        
        Button botonOK = new Button ("OK");
        Button botonLimpiar = new Button ("Limpiar nombres");
        
        this.setMinSize(1200, 600);
        this.setPadding(new Insets(10, 10, 10, 10));        
        //Seteo los espacios verticales y horizontales entre las columnas 
        this.setVgap(5); 
        this.setHgap(5);
        this.setAlignment(Pos.CENTER);
        
        this.add(nombreLabel, 0, 0);
        this.add(nombreInput, 1, 0);
        this.add(nombreLabel2, 0, 1);
        this.add(nombreInput2, 1, 1);
        this.add(botonOK, 0, 2);
        this.add(botonLimpiar, 1, 2);        
                               
        //Estilo a los nodos
        botonOK.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;"); 
        botonLimpiar.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");         
	    nombreLabel.setStyle("-fx-font: normal bold 20px 'serif' "); 
	    nombreLabel2.setStyle("-fx-font: normal bold 20px 'serif' ");  
	    //this.setStyle("-fx-background-color: BEIGE;"); //color del fondo
	             
	    BotonLimpiarEventHandler botonLimpiarEventHandler = new BotonLimpiarEventHandler(nombreInput, nombreInput2);
	    botonLimpiar.setOnAction(botonLimpiarEventHandler);
        
        BotonOKEventHandler botonOKEventHandler = new BotonOKEventHandler(stage, nombreInput, nombreInput2, nombreLabel, nombreLabel2);
        botonOK.setOnAction(botonOKEventHandler);

	    TextoEventHandler textoEventHandler = new TextoEventHandler(botonOK);
	    nombreInput.setOnKeyPressed(textoEventHandler);


	}

}
