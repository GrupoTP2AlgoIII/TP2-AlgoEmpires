package modelo.mapa;

import modelo.unidad.Posicionable;

public class Casillero {
	
	private Posicion posicion;
	private Posicionable objetoAlmacenado;
	
	public Casillero (Posicion posicion){
		this.posicion = posicion;
	}
	
	public Casillero (Posicion posicion, Posicionable posicionable) {
		
		this.posicion = posicion;
		this.objetoAlmacenado = posicionable;
	}
	
	public void agregarObjeto (Posicionable objeto) {
		
		this.objetoAlmacenado = objeto;
	}

}
