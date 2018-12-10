package vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import modelo.juego.Juego;

public class ContenedorDatosJugador extends VBox {
	
	private static ContenedorDatosJugador contenedorDatosJugador;
	private Text numeroOro;
	private Text numeroPoblacion;
	private Text numeroProduccionDeOro;
	private Button color;
	private String colorAux;
	private String colorComando;
	private Juego juego;
	
	public ContenedorDatosJugador(Juego juego) {
        
		ContenedorDatosJugador.contenedorDatosJugador = this;
		this.juego = juego;
		
        VBox right1 = new VBox(10);
        right1.setPadding(new Insets(3));
        
        Label datos = new Label("Datos jugador:");
        datos.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        
        VBox right2 = new VBox(10); 
        right2.setPadding(new Insets(3));
        
        HBox cajaOroJugador = new HBox(10);
        
        Label oro = new Label("Oro:");
        oro.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10));
        
        numeroOro = new Text("numero");
        numeroOro.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10));
        
        cajaOroJugador.getChildren().addAll(oro,numeroOro);
        
        HBox cajaProduccionOroJugador = new HBox(10);
        
        Label produccionOro = new Label("Produccion de oro:");
        produccionOro.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10));
        
        numeroProduccionDeOro = new Text("numero");
        numeroProduccionDeOro.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10));
        
        cajaProduccionOroJugador.getChildren().addAll(produccionOro,numeroProduccionDeOro);
        
        HBox cajaPoblacionJugador = new HBox(10);
        
        Label poblacion = new Label("Poblacion:");
        poblacion.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10));
        
        numeroPoblacion = new Text("numero");
        numeroPoblacion.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10));
        
        cajaPoblacionJugador.getChildren().addAll(poblacion,numeroPoblacion);
        
        HBox cajaColorJugador = new HBox(10);
        
        Label colorJugador = new Label("Color posicionables:");
        colorJugador.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10));
        
        color = new Button();
        colorAux = "purple";
        colorComando = "-fx-background-color: ";
        color.setStyle(colorComando+colorAux);

        
        cajaColorJugador.getChildren().addAll(colorJugador,color);
        
        
        right1.getChildren().add(datos);
        right1.setAlignment(Pos.TOP_CENTER);
        
        right2.getChildren().addAll(cajaOroJugador,cajaProduccionOroJugador,cajaPoblacionJugador,cajaColorJugador);
        right2.setAlignment(Pos.TOP_LEFT);
        
        this.getChildren().addAll(right1,right2);
	}
	
	  public static  ContenedorDatosJugador getInstance(){
	        if (contenedorDatosJugador == null){
	        	contenedorDatosJugador = new  ContenedorDatosJugador(new Juego("Error","Error"));
	        }
	        return contenedorDatosJugador;
	    }

	public void actualizar() {
		int numeroOro = this.juego.obtenerOroJugadorActual();
		this.numeroOro.setText(Integer.toString(numeroOro));
		
		int produccionOro = this.juego.obtenerProduccionOro();
		this.numeroProduccionDeOro.setText(Integer.toString(produccionOro));
		
		int numeroPoblacion = this.juego.obtenerCantidadPoblacionJugadorActual();
		this.numeroPoblacion.setText(Integer.toString(numeroPoblacion));
		
		colorAux = this.juego.obtenerColorJugadorActual();
		this.color.setStyle(colorComando+colorAux);
		
		
	}
}
