package vista;


import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class ContenedorMensajesJuego extends VBox {
	private VBox consola;
	private static ContenedorMensajesJuego contenedor;
	
	public ContenedorMensajesJuego() {
		
		
		 Label titulo = new Label("Mensajes del Juego:");
		 titulo.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
	     
	     consola = new VBox();
	     Label prueba = new Label("Mensajes del Juego:");
	     consola.getChildren().add(prueba);
	     consola.setStyle("-fx-background-color: black;");
	     consola.setPrefWidth(280);
	     consola.setPrefHeight(200);
	             
	     ScrollPane scroll = new ScrollPane();
	     scroll.setContent(consola);
	     scroll.setVbarPolicy(ScrollBarPolicy.ALWAYS);
	     scroll.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
	     
	     this.getChildren().addAll(titulo,scroll);
	     contenedor = this;
	     
	}
	
	public void limpiarConsola() {
		consola.getChildren().clear();
		
	}
	
	public void agregarMensaje(String mensaje) {      
		Text text = new Text(mensaje);
        text.setFont(Font.font("Verdana", 12));
        text.setFill(Color.GREEN);
		consola.getChildren().add(text);		
	}
	
	  public static  ContenedorMensajesJuego getInstance(){
	        if (contenedor == null){
	        	contenedor = new ContenedorMensajesJuego();
	        }
	        return contenedor;
	    }
	
	
	

}
