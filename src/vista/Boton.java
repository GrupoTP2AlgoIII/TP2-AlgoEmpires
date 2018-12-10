package vista;


import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import modelo.mapa.Posicion;

public class Boton extends Button {

	private int x;
	private int y;
	
    public Boton (String texto, javafx.event.EventHandler<ActionEvent> controlador){
    	setTexto(texto);
        setControlador(controlador);
    }
     
    /*
    public void textoAlPasarMouse(String texto){
        setTooltip(new Tooltip(texto));
    }*/


	public Boton(String texto) {
		setTexto(texto);
	}

	public Boton(Boton node) {
		setText(node.getText());
		setStyle(node.getStyle());
		setOnAction(node.getOnAction());
		this.setCoordenadas(node.getPosicion().getFila(), node.getPosicion().getColumna());
	}

	public void setTexto(String texto){
        setText(texto);
    }
    
    public void setControlador(javafx.event.EventHandler<ActionEvent> controlador) {
        setOnAction(controlador);
    }

	public void setEstilo(String string) {
		setStyle(string);
		
	}
	
	public void setCoordenadas(int x,int y) {
		this.x = x;
		this.y = y;
	}
	
	public Posicion getPosicion() {
		return new Posicion(this.x,this.y);
	}

}

