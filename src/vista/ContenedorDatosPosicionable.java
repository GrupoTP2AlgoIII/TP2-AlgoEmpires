package vista;


import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import modelo.mapa.Posicion;
import modelo.unidad.Posicionable;

public class ContenedorDatosPosicionable extends VBox {
	
	private static ContenedorDatosPosicionable contenedor;
	private Posicion posicionPosicionable;
	private Text numeroVida;
	private Text numeroPosicion;
	private Text numeroRango;
	private Text numeroUnidadAtaque;
	private Text numeroEdificioAtaque;
	
	
	public ContenedorDatosPosicionable() {
		ContenedorDatosPosicionable.contenedor = this;
		this.setSpacing(10);
		
	    Label datosPosicionable = new Label("Datos posicionable actual:");
	    datosPosicionable.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
	    	    
	    HBox cajaVidaPosicionable = new HBox(10);
	    
	    Label vida = new Label("Vida:");
	    vida.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10));
	    
	    numeroVida = new Text("numero");
	    numeroVida.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10));
	    
	    cajaVidaPosicionable.getChildren().addAll(vida,numeroVida);
	    
	    HBox cajaPosicionPosicionable = new HBox(10);
	    
	    Label posicion = new Label("Posicion:");
	    posicion.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10));
	    
	    numeroPosicion = new Text("(x,y)");
	    numeroPosicion.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10));
	    
	    cajaPosicionPosicionable.getChildren().addAll(posicion,numeroPosicion);
	    
	    HBox cajaRangoPosicionable = new HBox(10);
	    
	    Label rango = new Label("Rango ataque:");
	    rango.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10));
	    
	    numeroRango = new Text("numero");
	    numeroRango.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10));
	    
	    cajaRangoPosicionable.getChildren().addAll(rango,numeroRango);
	    
	    HBox cajaAtaqueUnidadPosicionable = new HBox(10);
	    
	    Label ataqueUnidad = new Label("Danio ataque unidad:");
	    ataqueUnidad.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10));
	    
	    
	    numeroUnidadAtaque = new Text("numero");
	    numeroUnidadAtaque.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10));
	    
	    cajaAtaqueUnidadPosicionable.getChildren().addAll(ataqueUnidad,numeroUnidadAtaque);
	    
	    HBox cajaAtaqueEdificioPosicionable = new HBox(10);
	    
	    Label ataqueEdificio = new Label("Danio ataque edificio:");
	    ataqueEdificio.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10));
	    
	    numeroEdificioAtaque = new Text("numero");
	    numeroEdificioAtaque.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10));
	    
	    cajaAtaqueEdificioPosicionable.getChildren().addAll(ataqueEdificio,numeroEdificioAtaque);
	    
        this.getChildren().addAll(datosPosicionable,cajaVidaPosicionable,cajaPosicionPosicionable,
        		cajaRangoPosicionable,cajaAtaqueUnidadPosicionable,cajaAtaqueEdificioPosicionable);
        this.setAlignment(Pos.TOP_LEFT); 
	}

	  public static  ContenedorDatosPosicionable getInstance(){
	        if (contenedor == null){
	        	contenedor = new  ContenedorDatosPosicionable();
	        }
	        return contenedor;
	    }

	public void actualizar(Posicionable posicionable,Posicion posicion) {
		String numeroVida = Integer.toString(posicionable.getVida());
		this.numeroVida.setText(numeroVida);
		
		//Posicion posicion = posicionable.getPosicion();
		String numeroPosicion = new String ("("+posicion.getFila()+","+posicion.getColumna()+")");
		this.numeroPosicion.setText(numeroPosicion);
		
		
		String numeroRango = Integer.toString(posicionable.getRango());
		this.numeroRango.setText(numeroRango);
		
		String numeroUnidadAtaque = Integer.toString(posicionable.getAtaqueUnidad());
		this.numeroUnidadAtaque.setText(numeroUnidadAtaque);
		

		String numeroEdificioAtaque = Integer.toString(posicionable.getAtaqueEdificio());
		this.numeroEdificioAtaque.setText(numeroEdificioAtaque);
		
		this.posicionPosicionable = posicionable.getPosicion();
			
		
	}

	public Posicion getPosicion() {
		return this.posicionPosicionable;
	}
	
	public int getNumeroRango() {
		String rango = this.numeroRango.getText();
		return (Integer.valueOf(rango));
	}

	  
	  
    

}
