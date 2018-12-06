package vista;

import java.io.File;

import controlador.BotonesArriba;
import controlador.BotonesDerecha;
import controlador.BotonesIzquierda;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import modelo.juego.Juego;

public class VistaJuego extends BorderPane{
	
	private Juego juego;
	private BotonesIzquierda botonesIzquierda;
	private BotonesDerecha botonesDerecha;
	private BotonesArriba botonesArriba;
	private boolean sonidoOn = false;
	private MediaPlayer mediaPlayer;
		
	public VistaJuego(String nombreJugador1, String nombreJugador2) {
		
		this.juego = new Juego(nombreJugador1, nombreJugador2); //Empieza el juego
		this.botonesArriba = new BotonesArriba(this.juego, nombreJugador1, nombreJugador2);		
		this.setTop(this.botonesArriba);
		this.botonesIzquierda = new BotonesIzquierda(this.juego, 1, 1);
		this.setLeft(this.botonesIzquierda);
		this.botonesDerecha = new BotonesDerecha(this.juego);
		this.setRight((this.botonesDerecha));
		this.setBottom(this.crearPanelInferior(juego, nombreJugador1, nombreJugador2));
				
		Media sound = new Media(new File("C:\\\\Users\\\\Tomás-adm\\\\Desktop\\\\FIUBA\\\\Algoritmos III\\\\TP2\\\\TP\\\\sound\\Age-of-Empires-Ambient-Sounds.mp3").toURI().toString());
		this.mediaPlayer = new MediaPlayer(sound);
		this.mediaPlayer.setAutoPlay(true);
		

		
	}
	
	private HBox crearPanelInferior(Juego juego, String jugador1, String jugador2) {
		
		HBox panelInferior = new HBox();
		panelInferior.setPadding(new Insets(15, 12, 15, 12));
	    panelInferior.setSpacing(10);
	    panelInferior.setStyle("-fx-background-color: BEIGE;");  
		
		Button botonPasarTurno = new Button("Pasar Turno");
		botonPasarTurno.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
		botonPasarTurno.setOnAction(e -> {
			try {
				juego.avanzarTurno();
				//ACTUALIZAR LAS VISTAS
				this.actualizarVistas(juego, jugador1, jugador2); // Hay que ver si funciona
				System.out.println("avanzar turno bien");
			}
			catch (Exception excepcion2) {
				System.out.println("error al avanzar turno");
			}
		});
		
		Button botonSonido = new Button ("Sonido");
		botonSonido.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
		botonSonido.setOnAction(e -> this.activarODesactivarSonido());
		
		panelInferior.getChildren().addAll(botonPasarTurno, botonSonido);
		panelInferior.setAlignment(Pos.CENTER);
		
		return panelInferior;		
	}
	
	
	private void actualizarVistas(Juego juego, String nombreJugador1, String nombreJugador2){
	
		this.juego = juego;
		this.botonesArriba = new BotonesArriba(this.juego, nombreJugador1, nombreJugador2);		
		this.setTop(this.botonesArriba);
		this.botonesIzquierda = new BotonesIzquierda(this.juego, 1, 1);
		this.setLeft(this.botonesIzquierda);
		this.botonesDerecha = new BotonesDerecha(this.juego);
		this.setRight((this.botonesDerecha));
	}
	
	private void activarODesactivarSonido() {
				
		if (! this.sonidoOn) {
			this.mediaPlayer.play();
			this.sonidoOn = true;
		}
		else {
			this.mediaPlayer.pause();
			this.sonidoOn = false;
		}
		
	}


}
