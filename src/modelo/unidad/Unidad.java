package modelo.unidad;

import modelo.ataque.ArmaDeAsedioDesmontadaNoPuedeAtacarError;
import modelo.ataque.AtacandoEnPosicionFueraDelAlcanceError;
import modelo.ataque.Ataque;
import modelo.mapa.Posicion;
import modelo.unidad.aldeano.AldeanoNoPuedeAtacarError;
import modelo.unidad.armaDeAsedio.ArmaDeAsedioMontadaNoPuedeDesplazarseError;

public abstract class Unidad extends Posicionable {
	
	protected int cantidadDeMovimientos;
	protected int movimientosPermitidos;
	protected int vida;
	protected int costo;
	protected Ataque ataque;
	protected int alcance;
	
	public Unidad () {
		
		this.cantidadDeMovimientos = 0;
		this.movimientosPermitidos = 1;
	}


	// Agrego este constructor
	public Unidad(int x, int y) {
		super (x, y);
	}
	
	public abstract void atacar (Posicionable posicionable) throws AtacandoEnPosicionFueraDelAlcanceError, AldeanoNoPuedeAtacarError, ArmaDeAsedioDesmontadaNoPuedeAtacarError;
	
	/*
     * devuelve si el posicionable se encuentra dentro de la cuadricula formada por el alcanceEnFila y alcanceEnColumna
     * a partri de la posicion.
     */

	public boolean estaEnRangoDePosicion (Posicion posicion, int alcanceEnFila, int alcanceEnColumna) {
		
		return this.posicion.perteneceALaCuadricula(posicion, alcanceEnFila, alcanceEnColumna);
	}
	
	public void atacado(Ataque ataque) {
		this.vida -= ataque.getAtaqueUnidad();
		
	}

	public int getVida() {
		return this.vida;
	}
	
	public int avanzarTurno() {
		return 0;
	}
	
//esta bien redefinir los metodos heredados?
	
	public void desplazarHaciaLaDerecha(int cantidadDePosiciones) throws MovimientosPorTurnoExcedidosError, ArmaDeAsedioDesmontadaNoPuedeAtacarError, ArmaDeAsedioMontadaNoPuedeDesplazarseError {
		
		if (this.cantidadDeMovimientos >= this.movimientosPermitidos) {
			
			throw new MovimientosPorTurnoExcedidosError ();
			
		}
		
		this.posicion.desplazarHaciaLaDerecha (cantidadDePosiciones);
		
	}

	public void desplazarHaciaLaIzquierda(int cantidadDePosiciones) throws MovimientosPorTurnoExcedidosError, ArmaDeAsedioDesmontadaNoPuedeAtacarError, ArmaDeAsedioMontadaNoPuedeDesplazarseError {
		
		if (this.cantidadDeMovimientos >= this.movimientosPermitidos) {
			
			throw new MovimientosPorTurnoExcedidosError ();
			
		}

		this.posicion.desplazarHaciaLaIzquierda (cantidadDePosiciones);
		
	}

	public void desplazarHaciaArriba(int cantidadDePosiciones) throws MovimientosPorTurnoExcedidosError, ArmaDeAsedioDesmontadaNoPuedeAtacarError, ArmaDeAsedioMontadaNoPuedeDesplazarseError {
		
		if (this.cantidadDeMovimientos >= this.movimientosPermitidos) {
			
			throw new MovimientosPorTurnoExcedidosError ();
			
		}
		
		this.cantidadDeMovimientos ++;
		this.posicion.desplazarHaciaArriba (cantidadDePosiciones);
		
	}

	public void desplazarHaciaAbajo(int cantidadDePosiciones) throws MovimientosPorTurnoExcedidosError, ArmaDeAsedioDesmontadaNoPuedeAtacarError, ArmaDeAsedioMontadaNoPuedeDesplazarseError {
		
		if (this.cantidadDeMovimientos >= this.movimientosPermitidos) {
			
			throw new MovimientosPorTurnoExcedidosError ();
			
		}

		this.posicion.desplazarHaciaAbajo (cantidadDePosiciones);
		
	}

	public void desplazarHaciaLaDiagonalSuperiorDerecha(int cantidadDePosiciones) throws MovimientosPorTurnoExcedidosError, ArmaDeAsedioDesmontadaNoPuedeAtacarError, ArmaDeAsedioMontadaNoPuedeDesplazarseError {
		
		if (this.cantidadDeMovimientos >= this.movimientosPermitidos) {
			
			throw new MovimientosPorTurnoExcedidosError ();
			
		}
		
		this.posicion.desplazarHaciaLaDiagonalSuperiorDerecha (cantidadDePosiciones);
		
	}

	public void desplazarHaciaLaDiagonalSuperiorIzquierda(int cantidadDePosiciones) throws MovimientosPorTurnoExcedidosError, ArmaDeAsedioDesmontadaNoPuedeAtacarError, ArmaDeAsedioMontadaNoPuedeDesplazarseError{
		
		if (this.cantidadDeMovimientos >= this.movimientosPermitidos) {
			
			throw new MovimientosPorTurnoExcedidosError ();
			
		}
		
		this.posicion.desplazarHaciaLaDiagonalSuperiorIzquierda (cantidadDePosiciones);
		
	}

	public void desplazarHaciaLaDiagonalInferiorDerecha(int cantidadDePosiciones) throws MovimientosPorTurnoExcedidosError, ArmaDeAsedioDesmontadaNoPuedeAtacarError, ArmaDeAsedioMontadaNoPuedeDesplazarseError {
		
		if (this.cantidadDeMovimientos >= this.movimientosPermitidos) {
			
			throw new MovimientosPorTurnoExcedidosError ();
			
		}

		this.posicion.desplazarHaciaLaDiagonalInferiorDerecha (cantidadDePosiciones);
		
	}

	public void desplazarHaciaLaDiagonalInferiorIzquierda(int cantidadDePosiciones) throws MovimientosPorTurnoExcedidosError, ArmaDeAsedioDesmontadaNoPuedeAtacarError, ArmaDeAsedioMontadaNoPuedeDesplazarseError {
		
		if (this.cantidadDeMovimientos >= this.movimientosPermitidos) {
			
			throw new MovimientosPorTurnoExcedidosError ();
			
		}
		
		this.posicion.desplazarHaciaLaDiagonalInferiorIzquierda (cantidadDePosiciones);
	}
	
	@Override
	public boolean estaOcupado() {
		return true;		
	}




}
