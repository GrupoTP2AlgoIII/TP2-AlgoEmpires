package modelo.unidad;

import modelo.ataque.ArmaDeAsedioDesmontadaNoPuedeAtacarError;
import modelo.ataque.Ataque;
import modelo.jugador.PlazaCentralCrearAldeanoException;
import modelo.mapa.Posicion;
import modelo.unidad.armaDeAsedio.ArmaDeAsedioMontadaNoPuedeDesplazarseError;

public abstract class Posicionable {
	
	protected Posicion posicion;
	
	public Posicionable () {
		
		this.posicion = new Posicion ();
	}
 
    public Posicionable (int fila, int columna) {
		this.posicion = new Posicion(fila, columna);
	}
	
	public void posicionarEnFilaColumna(int fila, int columna) {
		
		this.posicion.posicionarEnFilaColumna (fila, columna);
		
	}

	public void desplazarHaciaLaDerecha(int cantidadDePosiciones) throws MovimientosPorTurnoExcedidosError, ArmaDeAsedioDesmontadaNoPuedeAtacarError, ArmaDeAsedioMontadaNoPuedeDesplazarseError {
		
		this.posicion.desplazarHaciaLaDerecha (cantidadDePosiciones);
		
	}

	public Posicion getPosicion() {
		
		return this.posicion;
		
	}

	public void desplazarHaciaLaIzquierda(int cantidadDePosiciones) throws MovimientosPorTurnoExcedidosError, ArmaDeAsedioDesmontadaNoPuedeAtacarError, ArmaDeAsedioMontadaNoPuedeDesplazarseError {

		this.posicion.desplazarHaciaLaIzquierda (cantidadDePosiciones);
		
	}

	public void desplazarHaciaArriba(int cantidadDePosiciones) throws MovimientosPorTurnoExcedidosError, ArmaDeAsedioDesmontadaNoPuedeAtacarError, ArmaDeAsedioMontadaNoPuedeDesplazarseError {

		this.posicion.desplazarHaciaArriba (cantidadDePosiciones);
		
	}

	public void desplazarHaciaAbajo(int cantidadDePosiciones) throws MovimientosPorTurnoExcedidosError, ArmaDeAsedioDesmontadaNoPuedeAtacarError, ArmaDeAsedioMontadaNoPuedeDesplazarseError {

		this.posicion.desplazarHaciaAbajo (cantidadDePosiciones);
		
	}

	public void desplazarHaciaLaDiagonalSuperiorDerecha(int cantidadDePosiciones) throws MovimientosPorTurnoExcedidosError, ArmaDeAsedioDesmontadaNoPuedeAtacarError, ArmaDeAsedioMontadaNoPuedeDesplazarseError {
		
		this.posicion.desplazarHaciaLaDiagonalSuperiorDerecha (cantidadDePosiciones);
		
	}

	public void desplazarHaciaLaDiagonalSuperiorIzquierda(int cantidadDePosiciones) throws MovimientosPorTurnoExcedidosError, ArmaDeAsedioDesmontadaNoPuedeAtacarError, ArmaDeAsedioMontadaNoPuedeDesplazarseError {

		this.posicion.desplazarHaciaLaDiagonalSuperiorIzquierda (cantidadDePosiciones);
		
	}

	public void desplazarHaciaLaDiagonalInferiorDerecha(int cantidadDePosiciones) throws MovimientosPorTurnoExcedidosError, ArmaDeAsedioDesmontadaNoPuedeAtacarError, ArmaDeAsedioMontadaNoPuedeDesplazarseError {

		this.posicion.desplazarHaciaLaDiagonalInferiorDerecha (cantidadDePosiciones);
		
	}

	public void desplazarHaciaLaDiagonalInferiorIzquierda(int cantidadDePosiciones) throws MovimientosPorTurnoExcedidosError, ArmaDeAsedioDesmontadaNoPuedeAtacarError, ArmaDeAsedioMontadaNoPuedeDesplazarseError {

		this.posicion.desplazarHaciaLaDiagonalInferiorIzquierda (cantidadDePosiciones);
	}

	public abstract int avanzarTurno();

	public abstract int getVida();

	public abstract void atacado(Ataque ataque);
	
	public abstract boolean estaOcupado();
	
    public Unidad crearAldeano() {
    	throw new PlazaCentralCrearAldeanoException();
    }

	public abstract boolean estaEnRangoDePosicion (Posicion posicion, int alcanceEnFila, int alcanceEnColumna);

}
