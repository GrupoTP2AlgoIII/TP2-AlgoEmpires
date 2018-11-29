package modelo.vacio;

import modelo.ataque.Ataque;
import modelo.jugador.PosicionDesocupadaError;
import modelo.mapa.Posicion;
import modelo.unidad.Posicionable;

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
	public void atacado(Ataque ataque) {
		// TODO Auto-generated method stub
		
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

}
