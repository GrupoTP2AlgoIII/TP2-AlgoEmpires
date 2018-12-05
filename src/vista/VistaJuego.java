package vista;

import controlador.BotonesArriba;
import controlador.BotonesIzquierda;
import javafx.scene.layout.BorderPane;
import modelo.juego.Juego;

public class VistaJuego extends BorderPane{
	
	private Juego juego;
	private BotonesIzquierda botonesIzquierda;
	//private BotonesDerecha botonesDerecha;
	private BotonesArriba botonesArriba;
	//private BotonesAbajo botonesAbajo;
	
	public VistaJuego(String nombreJugador1, String nombreJugador2) {
		
		this.juego = new Juego(nombreJugador1, nombreJugador2);
		this.juego.iniciarJuego();
		this.botonesArriba = new BotonesArriba(this.juego, nombreJugador1, nombreJugador2);		
		this.setTop(this.botonesArriba);
		this.botonesIzquierda = new BotonesIzquierda(this.juego);
		this.setLeft(this.botonesIzquierda);
		
		
	}

}
