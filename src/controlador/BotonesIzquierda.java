package controlador;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import modelo.juego.Juego;
import vista.ConstruccionDatos;

public class BotonesIzquierda extends VBox {
	
	public BotonesIzquierda(Juego juego, int x, int y) {
		
//	    this.setPadding(new Insets(15, 12, 15, 12));
//	    this.setSpacing(10);
//	    this.setStyle("-fx-background-color: BEIGE;"); //fondo
//		
//		Button botonCuartel = new Button("Construir Cuartel");
//		Button botonPlazaCentral = new Button("Construir Plaza Central");
//		
//		botonCuartel.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
//		botonPlazaCentral.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
//		
//		botonCuartel.setOnAction(e -> {
//			try {
//			Posicion posicion = ConstruccionDatos.pedirDatos("Coordenadas para construir cuartel");
//			//juego.agregarEdifcioDesdeHasta(new Cuartel(), posicion.getFila(), posicion.getColumna(), posicion.getFila()+1, posicion.getColumna()+1);
//			//juego.avanzarTurno(); //ESTE METODO FUNCIONA BIEN
//			}
//			catch (Exception excepcion) {
//				System.out.println("excepcion");
//			}
//		});
//		
//		
//		//botonPlazaCentral.setOnAction(value);
//		this.getChildren().addAll(botonCuartel, botonPlazaCentral);
//		this.setAlignment(Pos.CENTER);
		
		
        Label mensajesJuego = new Label("Mensajes del Juego:");
        mensajesJuego.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        
        VBox consola = new VBox();
        consola.setStyle("-fx-background-color: black;");
        consola.setPrefWidth(280);
        consola.setPrefHeight(200);
                
        ScrollPane scrollPane = new ScrollPane();
        
        // Set content for ScrollPane
        scrollPane.setContent(consola); 
        
        // Always show vertical scroll bar
        scrollPane.setVbarPolicy(ScrollBarPolicy.ALWAYS);    
        
        // Horizontal scroll bar is only displayed when needed
        scrollPane.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
        
        
		
		Label datosPosicionable = new Label("Datos posicionable actual:");
        datosPosicionable.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        
        
        HBox cajaVidaPosicionable = new HBox(10);
        
        Label vida = new Label("Vida:");
        vida.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10));
        
        int vidaPosicionable = juego.obtenerVidaPosicionableEn(x,y); // QUE RECIBA ESTE PAR (X,Y) POR PARAMETRO CUANDO SE HACE CLICK EN UN POSICIONABLE
        Label vidaDelPosicionable = new Label (Integer.toString(vidaPosicionable));       
        
        cajaVidaPosicionable.getChildren().addAll(vida, vidaDelPosicionable);
        
        
        HBox cajaPosicionPosicionable = new HBox(10);
        
        Label posicion = new Label("Posicion:");
        posicion.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10));
        
        int posicionX = x; //si viene por parametro
        Label posicionEnX = new Label (Integer.toString(posicionX) + ", ");
        int posicionY = y; //si viene por parametro
        Label posicionEnY = new Label (Integer.toString(posicionY));
               
        cajaPosicionPosicionable.getChildren().addAll(posicion, posicionEnX, posicionEnY);
		 
        
        
        Label simbolos = new Label("Simbolos mapa:");
        simbolos.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        
        GridPane tablaSimbolos = new GridPane();
        tablaSimbolos.setVgap(0);
        tablaSimbolos.setHgap(0);
        tablaSimbolos.setPadding(new Insets(10,10,10,10));
        tablaSimbolos.setGridLinesVisible(true);
        tablaSimbolos.setAlignment(Pos.CENTER_LEFT);
        tablaSimbolos.setMinWidth(280);
        
        
        //funciona (nodo,columna,fila)
        Text elemento00 = new Text ("Posicionable                     ");
        elemento00.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10));
        tablaSimbolos.add(elemento00, 0, 0);
        GridPane.setMargin(elemento00, new Insets(3));
        
        Text elemento01 = new Text ("Simbolo                          ");
        elemento01.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10));
        tablaSimbolos.add(elemento01, 1, 0);
        GridPane.setMargin(elemento01, new Insets(3));
        
        Text elemento10 = new Text ("Plaza Central                    ");
        elemento10.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10));
        tablaSimbolos.add(elemento10, 0, 1);
        GridPane.setMargin(elemento10, new Insets(3));
        
        Text elemento11 = new Text ("PC                               ");
        elemento11.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10));
        tablaSimbolos.add(elemento11, 1, 1);
        GridPane.setMargin(elemento11, new Insets(3));
        
        Text elemento20 = new Text ("Cuartel                          ");
        elemento20.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10));
        tablaSimbolos.add(elemento20, 0, 2);
        GridPane.setMargin(elemento20, new Insets(3));
        
        Text elemento21 = new Text ("CL                               ");
        elemento21.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10));
        tablaSimbolos.add(elemento21, 1, 2);
        GridPane.setMargin(elemento21, new Insets(3));
        
        Text elemento30 = new Text ("Castillo                         ");
        elemento30.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10));
        tablaSimbolos.add(elemento30, 0, 3);
        GridPane.setMargin(elemento30, new Insets(3));
        
        Text elemento31 = new Text ("CT                               ");
        elemento31.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10));
        tablaSimbolos.add(elemento31, 1, 3);
        GridPane.setMargin(elemento31, new Insets(3));
        
        Text elemento40 = new Text ("Aldeano                          ");
        elemento40.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10));
        tablaSimbolos.add(elemento40, 0, 4);
        GridPane.setMargin(elemento40, new Insets(3));
        
        Text elemento41 = new Text ("A                                ");
        elemento41.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10));
        tablaSimbolos.add(elemento41, 1, 4);
        GridPane.setMargin(elemento41, new Insets(3));
        
        Text elemento50 = new Text ("Espadachin                       ");
        elemento50.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10));
        tablaSimbolos.add(elemento50, 0, 5);
        GridPane.setMargin(elemento50, new Insets(3));
        
        Text elemento51 = new Text ("ES                               ");
        elemento51.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10));
        tablaSimbolos.add(elemento51, 1, 5);
        GridPane.setMargin(elemento51, new Insets(3));
        
        Text elemento60 = new Text ("Arquero                          ");
        elemento60.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10));
        tablaSimbolos.add(elemento60, 0, 6);
        GridPane.setMargin(elemento60, new Insets(3));
        
        Text elemento61 = new Text ("AR                               ");
        elemento61.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10));
        tablaSimbolos.add(elemento61, 1, 6);
        GridPane.setMargin(elemento61, new Insets(3));
        
        Text elemento70 = new Text ("Arma de Asedio                   ");
        elemento70.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10));
        tablaSimbolos.add(elemento70, 0, 7);
        GridPane.setMargin(elemento70, new Insets(3));
        
        Text elemento71 = new Text ("AA                               ");
        elemento71.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10));
        tablaSimbolos.add(elemento71, 1, 7);
        GridPane.setMargin(elemento71, new Insets(3));
        
        
        this.getChildren().addAll(mensajesJuego, scrollPane, datosPosicionable, cajaVidaPosicionable, cajaPosicionPosicionable, simbolos, tablaSimbolos);
        
	}

}
