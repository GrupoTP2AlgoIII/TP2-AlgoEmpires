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

	@Override
	public int avanzarTurno() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getVida() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public boolean estaOcupado() {
		return false;		
	}
	
	public boolean estaEnRangoDePosicion (Posicion posicion, int alcanceEnFila, int alcanceEnColumna) {
		
		return false;
	}
	
	public void desplazarHasta (Posicion hasta) {
		
		throw new PosicionDesocupadaError ();
	}
	
	public void recibirPosicionable () {
		
	}

	@Override
	public int descontarOro(int oro) {
		return oro;
	}


	@Override
	public int decrementarProduccion(int oro) {
		return oro;
	}

	@Override
	public int aumentarProduccionDeOro(int produccionDeOro) {
		return produccionDeOro;
	}
	
	public void recibirDanio (int danio) {
		throw new PosicionDesocupadaError ();
	}
	
	public void recibirDanioDe (Posicionable posicionable) {
		throw new PosicionDesocupadaError ();
	}
	
	public void recibirDanioDe (Unidad unidad) {
		throw new PosicionDesocupadaError ();
	}
	
	public void recibirDanioDe (Edificio edificio) {
		throw new PosicionDesocupadaError ();
	}
	
	public void atacar (Posicionable posicionable) {
		throw new PosicionDesocupadaError ();
	}
	
	public void atacar (Unidad unidad) {
		throw new PosicionDesocupadaError ();
	}
	
	public void atacar (Edificio edificio) {
		throw new PosicionDesocupadaError ();
	}

}
