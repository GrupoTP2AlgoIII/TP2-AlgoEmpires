package controlador;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import modelo.juego.Juego;

public class BotonesDerecha extends VBox {
	
	public BotonesDerecha (Juego juego) {
		
	    this.setPadding(new Insets(15, 12, 15, 12));
	    this.setSpacing(10);
	    this.setStyle("-fx-background-color: BEIGE;"); //fondo    
	
	
		Label datos = new Label("Datos jugador:");
		datos.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
				  
		
		HBox cajaOroJugador = new HBox(10);
	      
	    Label oro = new Label("Oro:");
	    oro.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10));
	      
	    int cantidadOro = juego.obtenerOroJugadorActual();
	    Label cantidadDeOro = new Label (Integer.toString(cantidadOro));
	      
	    cajaOroJugador.getChildren().addAll(oro, cantidadDeOro);
	      
	      
	    HBox cajaPoblacionJugador = new HBox(10);
        
        Label poblacion = new Label("Poblacion:");
        poblacion.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10));
        
        int cantidadPoblacion = juego.obtenerCantidadPoblacionJugadorActual();
        Label cantidadDePoblacion = new Label (Integer.toString(cantidadPoblacion));
        
        cajaPoblacionJugador.getChildren().addAll(poblacion, cantidadDePoblacion);
        
        
        
        HBox cajaColorJugador = new HBox(10);
        
        Label colorJugador = new Label("Color posicionables:");
        colorJugador.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10));
        
        Rectangle color = new Rectangle();
        color.setFill(Color.RED);
        color.setWidth(10);
        color.setHeight(10);
        
        cajaColorJugador.getChildren().addAll(colorJugador,color);
        
        
        this.getChildren().addAll(datos, cajaOroJugador, cajaPoblacionJugador, cajaColorJugador);  
			
	}

}
