package vista;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import modelo.mapa.Posicion;

public class ConstruccionDatos {
	
	private static Posicion posicion;
	
	public static Posicion pedirDatos(String titulo) {
		
		Stage stage = new Stage();
		stage.setTitle(titulo);
		stage.setMinWidth(400);
				
		Label xLabel = new Label ("Coordenada X");
		Label yLabel = new Label ("Coordenada Y");
		TextField xInput = new TextField();
		TextField yInput = new TextField();
		Button botonListo = new Button ("Listo");
				
		GridPane layout = new GridPane();
		
		layout.add(xLabel, 0, 0);
		layout.add(xInput, 1, 0);
		layout.add(yLabel, 0, 1);
		layout.add(yInput, 1, 1);
		layout.add(botonListo, 0, 2);
						
		botonListo.setOnAction(e -> {
			posicion = crearPosicion(xInput, yInput);
			stage.close();
			
		});		
		
		Scene scene = new Scene(layout);
		
		stage.setScene(scene);
		stage.show();
		
		return posicion;
						
	}
	
	private static Posicion crearPosicion(TextField xInput, TextField yInput) {
		try {
			int x = Integer.parseInt(xInput.getText());
			int y = Integer.parseInt(yInput.getText());
			System.out.println("Posicion valida");
			return (new Posicion(x,y));
		} catch (NumberFormatException e) {
			System.out.println("Posicion invalida, ingrese numeros!");
			return (new Posicion(-1, -1)); //porque el metodo tiene que retornar una Posicion
		}
		
	}
	
}
