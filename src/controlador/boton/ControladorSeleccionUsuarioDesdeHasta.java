package controlador.boton;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.mapa.Posicion;
import vista.Boton;
import vista.ContenedorDatosPosicionable;
import vista.ContenedorPrincipal;

public class ControladorSeleccionUsuarioDesdeHasta {
    
	private Posicion desde;
	private Posicion hasta;
	private int ladoRango;
	private Boton botonClickeado;
	
	public ControladorSeleccionUsuarioDesdeHasta(Posicion desde,Posicion hasta,int ladoRango) {
		this.desde = desde;
		this.hasta = hasta;
		this.ladoRango = ladoRango;
		this.calcularPosicionClickeada();
		
	}
	
	private void calcularPosicionClickeada() {
		
		this.desde = ContenedorDatosPosicionable.getInstance().getPosicion();
		
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		
		Posicion posicionAux = new Posicion(this.desde.getFila()-this.ladoRango/2,this.desde.getColumna()-this.ladoRango/2);
		GridPane posicionesDeAccion = new GridPane();
		posicionesDeAccion.autosize();
		posicionesDeAccion.setPadding(new Insets(3, 3, 3,3)); 
		posicionesDeAccion.setVgap(3); 
		posicionesDeAccion.setHgap(3);       
		posicionesDeAccion.setAlignment(Pos.CENTER); 
		GridPane tablero = ContenedorPrincipal.getInstance().getTablero();
		for(int i=0;i<this.ladoRango;i++) {
			for(int j=0;j<this.ladoRango;j++) {		
				if(i==this.ladoRango/2 && j==this.ladoRango/2) {
				}else {
				    for (Node node : tablero.getChildren()) {
				        if (GridPane.getColumnIndex(node) == posicionAux.getColumna()+j-1  && GridPane.getRowIndex(node) == posicionAux.getFila()-1+i) {
				        	botonClickeado = new Boton((Boton)node);
				        }
				    }
						Boton posicion = new Boton(this.botonClickeado);
				        posicion.setCoordenadas(posicionAux.getFila()+i,posicionAux.getColumna()+j);
						posicion.setOnAction(e -> {
						this.hasta = posicion.getPosicion();
						stage.close();
						});	
						posicionesDeAccion.add(posicion, j, i);
				    }

				}
			}
		HBox contenedorPosiciones = new HBox();
		contenedorPosiciones.getChildren().add(posicionesDeAccion);
		contenedorPosiciones.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(contenedorPosiciones);
		
		stage.setScene(scene);
		stage.showAndWait();	
	}
	
	public Posicion getDesdeCalculada() {
		return this.desde;
	}
	
	public Posicion getHastaCalculada() {
		return this.hasta;
	}

}
