package controlador.boton;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.mapa.Posicion;
import vista.ContenedorDatosPosicionable;
import vista.ContenedorMensajesJuego;
import vista.ContenedorPrincipal;

public class ControladorMenuMover implements EventHandler<ActionEvent> {

	private Posicion posicionActual;
	private Posicion posicionAMover;
	
	@Override
	public void handle(ActionEvent event) {
		posicionActual = ContenedorDatosPosicionable.getInstance().getPosicion();
		int ladoAreaAtaque = 3;
		ControladorSeleccionUsuarioDesdeHasta controlador = new ControladorSeleccionUsuarioDesdeHasta(posicionActual,
				posicionAMover,ladoAreaAtaque);		
		this.posicionActual = controlador.getDesdeCalculada();
		this.posicionAMover = controlador.getHastaCalculada();
		
		try {
			ContenedorPrincipal.getInstance().getJuego().obtenerJugadorActual().posicionarDesdeEnHasta(posicionActual,posicionAMover);
			ContenedorPrincipal.getInstance().actualizarSinLimpiarConsola();
			ContenedorMensajesJuego.getInstance().agregarMensaje("Movimiento exitoso");
		}catch (Exception e) {
			ContenedorMensajesJuego.getInstance().agregarMensaje("Error al mover");
		}
		
		//VERSION DE MOVER USANDO TECLAS W,A,S,D
		/*
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
		stage.showAndWait();*/
				 
}
	


	}

