package controlador;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import modelo.juego.Juego;

public class BotonesArriba extends HBox {
	
	public BotonesArriba(Juego juego, String nombreJ1, String nombreJ2) {
		
	    this.setPadding(new Insets(15, 12, 15, 12));
	    this.setSpacing(10);
	    this.setStyle("-fx-background-color: BEIGE;"); //fondo
	    
		Label jugadorLabel = new Label ("Jugador actual: ");
	    Label nombreLabel = new Label (nombreJ1);
		//Label vidaCastilloLabel = new Label (juego.obtenerVidaCastilloJugadorActual());    	
		

		
        // Estilos a los nodos   
	    nombreLabel.setStyle("-fx-font: normal bold 20px 'serif' ");
	    jugadorLabel.setStyle("-fx-font: normal bold 20px 'serif' ");
	    //nombreLabel2.setStyle("-fx-font: normal bold 20px 'serif' ");
	    
		this.getChildren().addAll(jugadorLabel, nombreLabel);
		this.setAlignment(Pos.CENTER);
		
		//Faltaria obtener cada dato del jugador, como la vida de su castillo, su oro y los nombres( estos por constructor)
				
	}

}
