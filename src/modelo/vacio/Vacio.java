package modelo.vacio;

import modelo.ataque.Ataque;
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
		// No pasa nada
	}
	
	public boolean estaEnRangoDePosicion (Posicion posicion, int alcanceEnFila, int alcanceEnColumna) {
		
		return false;
	}
	
	public void desplazarHasta (Posicion hasta) {
		
		throw new PosicionDesocupadaError ();
	}
	
	public void recibirPosicionable () {
		// No pasa nada
	}
	
	public void recibirDanio (int danio) {
		throw new PosicionableVacioNoPuedeSerAtacadoException();	
	}
	
	public void recibirDanioDe (Posicionable posicionable) {
		throw new PosicionableVacioNoPuedeSerAtacadoException();	
	}
	
	public void recibirDanioDe (Unidad unidad) {
		throw new PosicionableVacioNoPuedeSerAtacadoException();	
	}
	
	public void recibirDanioDe (Edificio edificio) {
		throw new PosicionableVacioNoPuedeSerAtacadoException();	
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
	
	public void atacar (Vacio vacio, Posicion posicionAtacado) {
		
	}
	public void atacar (Posicionable posicionable, Posicion posicionAtacado) {
		
	}
	
	//VISTA
	@Override
	protected Ataque getAtaque() {
		return new Ataque (0,0,0);
	}

	@Override
	public String obtenerColor() {
		return (new String("green"));
	}
	
	@Override
	public String obtenerSimbolo() {
		return "***";
	}
	
	

}
