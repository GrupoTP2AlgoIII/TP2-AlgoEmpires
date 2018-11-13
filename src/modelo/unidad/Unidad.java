package modelo.unidad;

import modelo.mapa.Posicion;

public class Unidad extends Posicionable {
	
	private int cantidadDeMovimientos;
	private int movimientosPermitidos;
	
	public Unidad () {
		
		this.posicion = new Posicion ();
		this.cantidadDeMovimientos = 0;
		this.movimientosPermitidos = 1;
	}
	
	public void posicionarEnFilaColumna(int fila, int columna) {
		
		
		//agregar excepcion: si esa ocupada esa fila y columna entonces LugarOcupadoError ()
		this.posicion.posicionarEnFilaColumna (fila, columna);
		
	}

	public void desplazarHaciaLaDerecha(int cantidadDePosiciones) throws MovimientosPorTurnoExcedidosError {
		
		if (this.cantidadDeMovimientos >= this.movimientosPermitidos) {
			
			throw new MovimientosPorTurnoExcedidosError ();
			
		}
		
		this.posicion.desplazarHaciaLaDerecha (cantidadDePosiciones);
		
	}

	public Posicion getPosicion() {
		
		return this.posicion;
		
	}

	public void desplazarHaciaLaIzquierda(int cantidadDePosiciones) throws MovimientosPorTurnoExcedidosError {
		
		if (this.cantidadDeMovimientos >= this.movimientosPermitidos) {
			
			throw new MovimientosPorTurnoExcedidosError ();
			
		}

		this.posicion.desplazarHaciaLaIzquierda (cantidadDePosiciones);
		
	}

	public void desplazarHaciaArriba(int cantidadDePosiciones) throws MovimientosPorTurnoExcedidosError {
		
		if (this.cantidadDeMovimientos >= this.movimientosPermitidos) {
			
			throw new MovimientosPorTurnoExcedidosError ();
			
		}
		
		this.cantidadDeMovimientos ++;
		this.posicion.desplazarHaciaArriba (cantidadDePosiciones);
		
	}

	public void desplazarHaciaAbajo(int cantidadDePosiciones) throws MovimientosPorTurnoExcedidosError {
		
		if (this.cantidadDeMovimientos >= this.movimientosPermitidos) {
			
			throw new MovimientosPorTurnoExcedidosError ();
			
		}

		this.posicion.desplazarHaciaAbajo (cantidadDePosiciones);
		
	}

	public void desplazarHaciaLaDiagonalSuperiorDerecha(int cantidadDePosiciones) throws MovimientosPorTurnoExcedidosError {
		
		if (this.cantidadDeMovimientos >= this.movimientosPermitidos) {
			
			throw new MovimientosPorTurnoExcedidosError ();
			
		}
		
		this.posicion.desplazarHaciaLaDiagonalSuperiorDerecha (cantidadDePosiciones);
		
	}

	public void desplazarHaciaLaDiagonalSuperiorIzquierda(int cantidadDePosiciones) throws MovimientosPorTurnoExcedidosError {
		
		if (this.cantidadDeMovimientos >= this.movimientosPermitidos) {
			
			throw new MovimientosPorTurnoExcedidosError ();
			
		}
		
		this.posicion.desplazarHaciaLaDiagonalSuperiorIzquierda (cantidadDePosiciones);
		
	}

	public void desplazarHaciaLaDiagonalInferiorDerecha(int cantidadDePosiciones) throws MovimientosPorTurnoExcedidosError {
		
		if (this.cantidadDeMovimientos >= this.movimientosPermitidos) {
			
			throw new MovimientosPorTurnoExcedidosError ();
			
		}

		this.posicion.desplazarHaciaLaDiagonalInferiorDerecha (cantidadDePosiciones);
		
	}

	public void desplazarHaciaLaDiagonalInferiorIzquierda(int cantidadDePosiciones) throws MovimientosPorTurnoExcedidosError {
		
		if (this.cantidadDeMovimientos >= this.movimientosPermitidos) {
			
			throw new MovimientosPorTurnoExcedidosError ();
			
		}
		
		this.posicion.desplazarHaciaLaDiagonalInferiorIzquierda (cantidadDePosiciones);
	}
	
	

}
