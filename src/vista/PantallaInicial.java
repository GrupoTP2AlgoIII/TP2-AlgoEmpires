package vista;

import controlador.BotonLimpiarEventHandler;
import controlador.BotonOKEventHandler;
import controlador.TextoEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class PantallaInicial extends GridPane{
	
	// Referencia para hacer esto:
	// https://www.tutorialspoint.com/javafx/javafx_ui_controls.htm
	// Ejemplo de JavaFX de la catedra (botones)
	
	public PantallaInicial() {
		
		super();
		
		Text nombreTextoJ1 = new Text("Jugador1:"); 
        TextField nombreJ1TextField = new TextField();
        Label nombreIngresado1 = new Label();
        nombreIngresado1.setText(nombreJ1TextField.getText());
                
        Text nombreTextoJ2 = new Text("Jugador2");
        TextField nombreJ2TextField = new TextField();
        Label nombreIngresado2 = new Label();
        nombreIngresado2.setText(nombreJ2TextField.getText());
        
        Button botonOK = new Button ("OK");
        Button botonLimpiar = new Button ("Limpiar nombres");
        
        this.setMinSize(1200, 600);
        this.setPadding(new Insets(10, 10, 10, 10));        
        //Seteo los espacios verticales y horizontales entre las columnas 
        this.setVgap(5); 
        this.setHgap(5);
        this.setAlignment(Pos.CENTER);
        
        this.add(nombreTextoJ1, 0, 0);
        this.add(nombreJ1TextField, 1, 0);
        this.add(nombreTextoJ2, 0, 1);
        this.add(nombreJ2TextField, 1, 1);
        this.add(botonOK, 0, 2);
        this.add(botonLimpiar, 1, 2);
        
        //Estilo a los nodos
        botonOK.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;"); 
        botonLimpiar.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;"); 
         
        nombreTextoJ1.setStyle("-fx-font: normal bold 20px 'serif' "); 
        nombreTextoJ2.setStyle("-fx-font: normal bold 20px 'serif' ");  
        this.setStyle("-fx-background-color: BEIGE;");
        
        BotonLimpiarEventHandler botonLimpiarEventHandler = new BotonLimpiarEventHandler(nombreJ1TextField, nombreJ2TextField);
        botonLimpiar.setOnAction(botonLimpiarEventHandler);
        
        BotonOKEventHandler botonOKEventHandler = new BotonOKEventHandler(nombreJ1TextField, nombreJ2TextField, nombreIngresado1, nombreIngresado2);
        botonOK.setOnAction(botonOKEventHandler);
        
        TextoEventHandler textoEventHandler = new TextoEventHandler(botonOK);
        nombreJ1TextField.setOnKeyPressed(textoEventHandler);

	}

}
