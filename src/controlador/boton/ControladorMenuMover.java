package controlador.boton;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.jugador.PosicionNoPerteneceAJugadorException;
import modelo.jugador.PosicionNoPerteneceAPoblacionError;
import modelo.jugador.PosicionOcupadaError;
import modelo.mapa.Posicion;
import modelo.unidad.DesplazarAPosicionOcupadaError;
import modelo.unidad.MovimientosPorTurnoExcedidosError;
import modelo.unidad.PosicionFueraDelMapaError;
import modelo.unidad.aldeano.AldeanoOcupadoException;
import modelo.unidad.armaDeAsedio.ArmaDeAsedioDesmontandoseException;
import modelo.unidad.armaDeAsedio.ArmaDeAsedioMontadaException;
import modelo.unidad.armaDeAsedio.ArmaDeAsedioMontandoseException;
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
		}catch (ArmaDeAsedioDesmontandoseException e) {
			ContenedorMensajesJuego.getInstance().agregarMensaje("Error al mover,el arma de asedio se esta desmontando");
		}catch (PosicionNoPerteneceAPoblacionError e) {
			ContenedorMensajesJuego.getInstance().agregarMensaje("Error al mover,la unidad no pertence a jugador");
		}catch (PosicionNoPerteneceAJugadorException e) {
			ContenedorMensajesJuego.getInstance().agregarMensaje("Error al mover,la unidad no pertence a jugador");
		}catch (PosicionOcupadaError e) {
			ContenedorMensajesJuego.getInstance().agregarMensaje("Error al mover,posicion ocupada");
		}catch (DesplazarAPosicionOcupadaError e) {
			ContenedorMensajesJuego.getInstance().agregarMensaje("Error al mover,posicion ocupada");
		}catch (MovimientosPorTurnoExcedidosError e) {
			ContenedorMensajesJuego.getInstance().agregarMensaje("Error al mover,cantidad maxima de movimientos por turno es 1");
		}catch (PosicionFueraDelMapaError e) {
			ContenedorMensajesJuego.getInstance().agregarMensaje("Error al mover,posicion fuera del mapa");
		}catch (ArmaDeAsedioMontadaException e) {
			ContenedorMensajesJuego.getInstance().agregarMensaje("Error al mover,el arma de asedio esta montada");
		}catch (ArmaDeAsedioMontandoseException e) {
			ContenedorMensajesJuego.getInstance().agregarMensaje("Error al mover,el arma de asedio se esta montando");
		}catch (AldeanoOcupadoException e) {
			ContenedorMensajesJuego.getInstance().agregarMensaje("Error al mover,el aldeano esta ocupado");
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

