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
	    
		Label nombreLabel = new Label (nombreJ1);
		Label nombreLabel2 = new Label (nombreJ2);
		//Label oroLabel = new Label (juego.obtenerOroJugadorActual());
		//Label vidaCastilloLabel = new Label (juego.obtenerVidaCastilloJugadorActual());    
		
		
		Button botonPasarTurno = new Button("Pasar Turno");
		botonPasarTurno.setOnAction(e -> {
			try {
				juego.avanzarTurno();
				System.out.println("avanzar turno bien");
			}
			catch (Exception excepcion2) {
				System.out.println("error al avanzar turno");
			}
		});
		
        // Estilos a los nodos
		botonPasarTurno.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");         
	    nombreLabel.setStyle("-fx-font: normal bold 20px 'serif' "); 
	    nombreLabel2.setStyle("-fx-font: normal bold 20px 'serif' ");
	    
		this.getChildren().addAll(nombreLabel, botonPasarTurno, nombreLabel2);
		this.setAlignment(Pos.CENTER);
		
		//Faltaria obtener cada dato del jugador, como la vida de su castillo, su oro y los nombres( estos por constructor)
				
	}

}
