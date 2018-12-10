package vista;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import modelo.juego.Juego;

public class ContenedorJugadorActual extends HBox{
	
	private static ContenedorJugadorActual contenedorJugador;
	private Text nombre;
	private Juego juego;
	
	public ContenedorJugadorActual(Juego juego) {
	    this.setSpacing(10);
	    ContenedorJugadorActual.contenedorJugador = this;
	    this.juego = juego;
		    
		Label jugador= new Label("Jugador actual:");
	    jugador.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
	    
	    nombre= new Text("nombreDelJugador");
	    nombre.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
	    
	    this.getChildren().addAll(jugador,nombre);
	    this.setAlignment(Pos.CENTER);
	    this.actualizar();
	}
	
	  public static  ContenedorJugadorActual getInstance(){
	        if (contenedorJugador == null){
	        	contenedorJugador = new  ContenedorJugadorActual(new Juego("Error","Error"));
	        }
	        return contenedorJugador;
	    }

	public void actualizar() {
		String nombreJugador = this.juego.obtenerNombreJugadorActual();
		this.nombre.setText(nombreJugador);	
		
	}
	  


}
