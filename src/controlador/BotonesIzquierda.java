package controlador;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import modelo.edificio.cuartel.Cuartel;
import modelo.juego.Juego;
import modelo.mapa.Posicion;
import modelo.unidad.aldeano.Aldeano;
import vista.ConstruccionDatos;

public class BotonesIzquierda extends VBox {
	
	public BotonesIzquierda(Juego juego) {
		
	    this.setPadding(new Insets(15, 12, 15, 12));
	    this.setSpacing(10);
	    this.setStyle("-fx-background-color: BEIGE;"); //fondo
		
		Button botonCuartel = new Button("Construir Cuartel");
		Button botonPlazaCentral = new Button("Construir Plaza Central");
		
		botonCuartel.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
		botonPlazaCentral.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
		
		botonCuartel.setOnAction(e -> {
			try {
			Posicion posicion = ConstruccionDatos.pedirDatos("Coordenadas para construir cuartel");
			//juego.agregarEdifcioDesdeHasta(new Cuartel(), posicion.getFila(), posicion.getColumna(), posicion.getFila()+1, posicion.getColumna()+1);
			//juego.avanzarTurno(); //ESTE METODO FUNCIONA BIEN
			}
			catch (Exception excepcion) {
				System.out.println("excepcion");
			}
		});
		
		
		//botonPlazaCentral.setOnAction(value);
		this.getChildren().addAll(botonCuartel, botonPlazaCentral);
		this.setAlignment(Pos.CENTER);
				
	}

}
