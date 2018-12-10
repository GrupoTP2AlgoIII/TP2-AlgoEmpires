package vista;

import javafx.event.ActionEvent;
import javafx.scene.control.MenuItem;

public class ItemsMenu extends MenuItem {
    
	public ItemsMenu (String texto, javafx.event.EventHandler<ActionEvent> controlador){
        setTexto(texto);
        setControlador(controlador);
    }  
    /*
    public void textoAlPasarMouse(String texto){
        setTooltip(new Tooltip(texto));
    }*/

    public void setTexto(String texto){
        setText(texto);
    }
    
    public void setControlador(javafx.event.EventHandler<ActionEvent> controlador) {
        setOnAction(controlador);
    }
}
