package vista;

import java.io.File;

import controlador.boton.ControladorAvanzarTurno;
import controlador.boton.ControladorPosicionable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import modelo.juego.Juego;
import modelo.mapa.Posicion;
import modelo.unidad.Posicionable;

public class ContenedorPrincipal extends BorderPane {
	
	private Juego juego;
	private Posicionable posicionableActual;
	private GridPane tablero;
	private static ContenedorPrincipal controladorPrincipal;
	private static String nombreDelJugador1;
	private static String nombreDelJugador2;
	private boolean sonidoOn = false;
	private MediaPlayer mediaPlayer;
	
	public ContenedorPrincipal(String nombreJugador1, String nombreJugador2) {
		ContenedorPrincipal.controladorPrincipal = this;
        this.juego = new Juego(nombreJugador1, nombreJugador2);
        ContenedorPrincipal.nombreDelJugador1 = nombreJugador1;
        ContenedorPrincipal.nombreDelJugador2 = nombreJugador2;
		this.setSuperior();
        this.setCentro();
        this.setInferior();
        this.setIzquierda();
        this.setDerecha();
        this.actualizar();
        
		Media sound = new Media(new File("sound/Age-of-Empires-Ambient-Sounds.mp3").toURI().toString());
		this.mediaPlayer = new MediaPlayer(sound);
		this.mediaPlayer.setAutoPlay(true);
    }

	private void setCentro() { 
        
        tablero = new GridPane();    
        tablero.autosize();
        tablero.setPadding(new Insets(3, 3, 3,3)); 
        tablero.setVgap(3); 
        tablero.setHgap(3);       
        tablero.setAlignment(Pos.CENTER); 
        Menues menues = new Menues();  
       
        for(int i=0;i<this.juego.obtenerMapa().getFilas();i++) {
        	for(int j=0;j<this.juego.obtenerMapa().getColumnas();j++) {
                posicionableActual = juego.obtener(i+1, j+1);
                Boton casillero = new Boton("***", new ControladorPosicionable(posicionableActual,new Posicion(i+1,j+1)));
        		casillero.setEstilo("-fx-background-color: "+posicionableActual.obtenerColor());
        		casillero.setTexto(posicionableActual.obtenerSimbolo());
        		casillero.setContextMenu(menues.crearMenu(posicionableActual.obtenerSimbolo()));         		
           		tablero.add(casillero,j,i);
        		this.setCenter(tablero);
        	}
        }	
	}

	private void setDerecha() {
        
        VBox cajaDerecha = new VBox(10);
        cajaDerecha.autosize();
        cajaDerecha.setPadding(new Insets(3));
        cajaDerecha.getChildren().addAll(new ContenedorDatosJugador(juego));             
        this.setRight(cajaDerecha);		
	}

	private void setIzquierda() {
	                   
        VBox cajaIzquierda = new VBox(10);
        cajaIzquierda.autosize();
        cajaIzquierda.setPadding(new Insets(3));   
        cajaIzquierda.getChildren().addAll(new ContenedorDatosPosicionable(),new ContenedorMensajesJuego(),new ContenedorTablaSimbolos());         
        this.setLeft(cajaIzquierda);
		
	}

	private void setInferior() {
        HBox inferior = new HBox(10);
        inferior.autosize();
        inferior.setPadding(new Insets(10));        
        Boton avanzarTurno = new Boton("AvanzarTurno", new ControladorAvanzarTurno(juego));
        avanzarTurno.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
		Button botonSonido = new Button ("Sonido");
		botonSonido.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
		botonSonido.setOnAction(e -> this.activarODesactivarSonido());
        inferior.getChildren().addAll(avanzarTurno,botonSonido);
        inferior.setAlignment(Pos.CENTER);
        
        this.setBottom(inferior); 
		
	}

	private void setSuperior() {
		HBox superior = new HBox(10);
		superior.autosize();
		superior.setPadding(new Insets(10));
		superior.setAlignment(Pos.CENTER);
		superior.getChildren().add(new ContenedorJugadorActual(juego));
        this.setTop(superior); 		
	}
	
	public Juego getJuego() {
		return this.juego;
	}
	
	public void actualizar() {
		ContenedorMensajesJuego.getInstance().limpiarConsola();
		ContenedorJugadorActual.getInstance().actualizar();
		ContenedorDatosJugador.getInstance().actualizar();
		this.setCentro();
	
	}
	
	public void actualizarSinLimpiarConsola() {
		ContenedorJugadorActual.getInstance().actualizar();
		ContenedorDatosJugador.getInstance().actualizar();
		this.setCentro();
	}
	
	  public static  ContenedorPrincipal getInstance(){
	        if (controladorPrincipal == null){
	        	controladorPrincipal = new ContenedorPrincipal(nombreDelJugador1, nombreDelJugador2);
	        }
	        return controladorPrincipal;
	    }

	public GridPane getTablero() {
		return this.tablero;
	}
	
	public Posicionable getPosicionableActual() {
		return this.posicionableActual;
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

	public void finJuego(String string) {
		Stage ventana = new Stage();
		VBox contenedorVentana = new VBox(10);
		contenedorVentana.setPadding(new Insets(10));
		Text texto = new Text("El ganador del juego es: "+string);
		texto.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
		texto.setFill(Color.BLUE);
		Button botonFin = new Button();
		botonFin.setText("FIN");
		botonFin.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				ventana.close();
			}		
		});
		contenedorVentana.setAlignment(Pos.CENTER);
		contenedorVentana.getChildren().addAll(texto,botonFin);
		Scene scene = new Scene(contenedorVentana);
		scene.setFill(Color.BLACK);
		ventana.setScene(scene);
        ventana.showAndWait();	
	}


}
