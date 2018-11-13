package modelo.unidad;

import modelo.mapa.Posicion;

public class Posicionable {
	
	protected Posicion posicion;
	
	public Posicionable () {
		
		this.posicion = new Posicion ();
	}
	
	public void posicionarEnFilaColumna(int fila, int columna) {
		
	}

	public void desplazarHaciaLaDerecha(int cantidadDePosiciones) throws MovimientosPorTurnoExcedidosError {
				
	}

	public Posicion getPosicion() {
		
		return this.posicion;
		
	}

	public void desplazarHaciaLaIzquierda(int cantidadDePosiciones) throws MovimientosPorTurnoExcedidosError {
		
		
	}

	public void desplazarHaciaArriba(int cantidadDePosiciones) throws MovimientosPorTurnoExcedidosError {
		
		
	}

	public void desplazarHaciaAbajo(int cantidadDePosiciones) throws MovimientosPorTurnoExcedidosError {
		
		
	}

	public void desplazarHaciaLaDiagonalSuperiorDerecha(int cantidadDePosiciones) throws MovimientosPorTurnoExcedidosError {
		
		
	}

	public void desplazarHaciaLaDiagonalSuperiorIzquierda(int cantidadDePosiciones) throws MovimientosPorTurnoExcedidosError {
		
		
	}

	public void desplazarHaciaLaDiagonalInferiorDerecha(int cantidadDePosiciones) throws MovimientosPorTurnoExcedidosError {
		
		
	}

	public void desplazarHaciaLaDiagonalInferiorIzquierda(int cantidadDePosiciones) throws MovimientosPorTurnoExcedidosError {
		
	}

}
