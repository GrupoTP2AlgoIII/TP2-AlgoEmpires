package modelo.vacio;

import modelo.edificio.Edificio;
import modelo.jugador.PosicionDesocupadaError;
import modelo.mapa.Posicion;
import modelo.unidad.Posicionable;
import modelo.unidad.Unidad;

public class Vacio extends Posicionable{

	public Vacio(int i, int j) {
		super(i, j);
	}
	
	public Vacio (Posicion posicion) {
		super (posicion);
	}
	
	public Vacio() {
		
	}
	
	public boolean estaEnRangoDePosicion (Posicion posicion, int alcanceEnFila, int alcanceEnColumna) {
		
		return false;
	}
	
	public void desplazarHasta (Posicion hasta) {
		
		throw new PosicionDesocupadaError ();
	}
	
	public void recibirPosicionable () {
		
	}
	
	public void recibirDanio (int danio) {
		
	}
	
	public void recibirDanioDe (Posicionable posicionable) {
		
	}
	
	public void recibirDanioDe (Unidad unidad) {
		
	}
	
	public void recibirDanioDe (Edificio edificio) {
		
	}
	
	public void atacar (Posicionable posicionable) {
		throw new PosicionDesocupadaError ();
	}
	
	public void atacar (Unidad unidad, Posicion posicionAtacado) {
		throw new PosicionDesocupadaError ();
	}
	
	public void atacar (Edificio edificio, Posicion posicionAtacado) {
		throw new PosicionDesocupadaError ();
	}

}
