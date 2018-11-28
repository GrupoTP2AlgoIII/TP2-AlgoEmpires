package modelo.vacio;

import modelo.ataque.Ataque;
import modelo.jugador.PosicionDesocupadaError;
import modelo.mapa.Posicion;
import modelo.unidad.Posicionable;
import modelo.unidad.Unidad;
import modelo.unidad.CrearUnidadException;

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
		return 0;
	}

	@Override
	public int getVida() {
		return 0;
	}

	@Override
	public void atacado(Ataque ataque) {	
	}
	
	@Override
	public boolean estaOcupado() {
		return false;		
	}
	
	public boolean estaEnRangoDePosicion (Posicion posicion, int alcanceEnFila, int alcanceEnColumna) {	
		return false;
	}

	@Override
	public Unidad crearUnidad(char tipo) {
		throw new CrearUnidadException();
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
	

	public void desplazarHasta (Posicion hasta) {
		
		throw new PosicionDesocupadaError ();
	}
	
	public void recibirPosicionable () {
		
	}

}
