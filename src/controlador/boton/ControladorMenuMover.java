package controlador.boton;




import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ControladorMenuMover implements EventHandler<ActionEvent> {

	
	@Override
	public void handle(ActionEvent event) {
		
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		
		VBox contenedorStage = new VBox();
		contenedorStage.setAlignment(Pos.CENTER);
		
		HBox contenedorTexto = new HBox ();
		contenedorTexto.setAlignment(Pos.CENTER);
		Text texto = new Text();
		texto.setText("Use las teclas W,A,S,D para moverse, para salir modo movimiento apriete cualquier tecla");
		texto.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
		contenedorTexto.getChildren().add(texto);
		
		HBox contenedorBoton = new HBox ();
		contenedorBoton.setAlignment(Pos.CENTER);
		Button boton = new Button();
		boton.setText("OK");
		boton.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
		
		boton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				stage.close();					
				ControladorTeclasMover controlador = new ControladorTeclasMover();
				while (!controlador.apretoEnter()) {
					controlador.calcular();
				}
			}
								
		});
		contenedorBoton.getChildren().add(boton);
		contenedorStage.getChildren().addAll(contenedorTexto,contenedorBoton);
		Scene scene = new Scene(contenedorStage);	
		stage.setScene(scene);
		stage.showAndWait();
				 
}
	


	}

