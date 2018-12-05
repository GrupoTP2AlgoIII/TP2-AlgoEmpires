package controlador;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import modelo.juego.Juego;

public class BotonesArriba extends HBox {
	
	public BotonesArriba(Juego juego) {
		
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
		this.getChildren().add(botonPasarTurno);
		this.setAlignment(Pos.CENTER);
		
		//Faltaria obtener cada dato del jugador, como la vida de su castillo, su oro y los nombres( estos por constructor)
				
	}

}
