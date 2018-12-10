package controlador.boton;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import modelo.mapa.Posicion;
import vista.ContenedorDatosPosicionable;
import vista.ContenedorMensajesJuego;
import vista.ContenedorPrincipal;

public class ControladorTeclasMover {

	private Stage ventana;
	private Posicion posicionActual;
	private Posicion posicionAMover;
	private boolean fin = false;

	public ControladorTeclasMover () {
		posicionActual = ContenedorDatosPosicionable.getInstance().getPosicion();
	}
	public void calcular() {
		
		ventana = new Stage();
		ventana.initStyle(StageStyle.TRANSPARENT);
		ventana.setOpacity(0);
        final Scene scene = new Scene(new HBox());
        scene.setFill(null);
        ventana.addEventFilter(KeyEvent.KEY_PRESSED,new EventHandler<KeyEvent>() {											
			
		@Override
		public void handle(KeyEvent tecla) {
						
			switch (tecla.getCode()) {
					case A:
						posicionAMover = new Posicion (posicionActual.getFila(),posicionActual.getColumna()-1);
						actualizarMover();
						posicionActual = new Posicion (posicionAMover);
						ventana.close();
						break;
					
					case D:
						posicionAMover = new Posicion (posicionActual.getFila(),posicionActual.getColumna()+1);
						actualizarMover();
						posicionActual = new Posicion (posicionAMover);
						ventana.close();
						break;
					
					case W:
						posicionAMover = new Posicion (posicionActual.getFila()-1,posicionActual.getColumna());
						actualizarMover();
						posicionActual = new Posicion (posicionAMover);
						ventana.close();
						break;
					
					case S:
						posicionAMover = new Posicion (posicionActual.getFila()+1,posicionActual.getColumna());
						actualizarMover();
						posicionActual = new Posicion (posicionAMover);
						ventana.close();
						break;							
					
					default:
						ventana.close();
						fin = true;
						return;					
					}
			}
			
		});
        ventana.setScene(scene);
        ventana.showAndWait();
	}
	
	private void actualizarMover() {
		try {
			ContenedorPrincipal.getInstance().getJuego().obtenerJugadorActual().posicionarDesdeEnHasta(posicionActual,posicionAMover);
			ContenedorPrincipal.getInstance().actualizarSinLimpiarConsola();
			ContenedorMensajesJuego.getInstance().agregarMensaje("Movimiento exitoso");
		}catch (Exception e) {
			ContenedorMensajesJuego.getInstance().agregarMensaje("Error al mover");
			ventana.close();
			fin = true;
		}
	}
	
	public boolean apretoEnter() {
		return this.fin;
	}
}
