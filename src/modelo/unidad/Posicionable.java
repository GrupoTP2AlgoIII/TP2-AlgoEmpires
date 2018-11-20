package modelo.unidad;

import modelo.mapa.Posicion;

public abstract class Posicionable {
	
	protected Posicion posicion;
	
	public Posicionable () {
		
		this.posicion = new Posicion ();
	}

    // Agrego este constructor    
    public Posicionable (int fila, int columna) {
		this.posicion = new Posicion(fila, columna);
	}
	
	public void posicionarEnFilaColumna(int fila, int columna) {
		
		this.posicion.posicionarEnFilaColumna (fila, columna);
		
	}

	public void desplazarHaciaLaDerecha(int cantidadDePosiciones) throws MovimientosPorTurnoExcedidosError {
		
		this.posicion.desplazarHaciaLaDerecha (cantidadDePosiciones);
		
	}

	public Posicion getPosicion() {
		
		return this.posicion;
		
	}

	public void desplazarHaciaLaIzquierda(int cantidadDePosiciones) throws MovimientosPorTurnoExcedidosError {

		this.posicion.desplazarHaciaLaIzquierda (cantidadDePosiciones);
		
	}

	public void desplazarHaciaArriba(int cantidadDePosiciones) throws MovimientosPorTurnoExcedidosError {

		this.posicion.desplazarHaciaArriba (cantidadDePosiciones);
		
	}

	public void desplazarHaciaAbajo(int cantidadDePosiciones) throws MovimientosPorTurnoExcedidosError {

		this.posicion.desplazarHaciaAbajo (cantidadDePosiciones);
		
	}

	public void desplazarHaciaLaDiagonalSuperiorDerecha(int cantidadDePosiciones) throws MovimientosPorTurnoExcedidosError {
		
		this.posicion.desplazarHaciaLaDiagonalSuperiorDerecha (cantidadDePosiciones);
		
	}

	public void desplazarHaciaLaDiagonalSuperiorIzquierda(int cantidadDePosiciones) throws MovimientosPorTurnoExcedidosError {

		this.posicion.desplazarHaciaLaDiagonalSuperiorIzquierda (cantidadDePosiciones);
		
	}

	public void desplazarHaciaLaDiagonalInferiorDerecha(int cantidadDePosiciones) throws MovimientosPorTurnoExcedidosError {

		this.posicion.desplazarHaciaLaDiagonalInferiorDerecha (cantidadDePosiciones);
		
	}

	public void desplazarHaciaLaDiagonalInferiorIzquierda(int cantidadDePosiciones) throws MovimientosPorTurnoExcedidosError {

		this.posicion.desplazarHaciaLaDiagonalInferiorIzquierda (cantidadDePosiciones);
	}

	public abstract int avanzarTurno();

	public abstract int getVida();

	public abstract void restarVida(int vidaARestar);

}
