package modelo.unidad;

import modelo.edificio.Edificio;

public abstract class Unidad extends Posicionable {
	
	private int cantidadDeMovimientos;
	private int movimientosPermitidos;
	protected int vida;
	protected int costo;
	
	public Unidad () {
		
		this.cantidadDeMovimientos = 0;
		this.movimientosPermitidos = 1;
	}


	// Agrego este constructor
	public Unidad(int x, int y) {
		super (x, y);
	}


	public abstract int avanzarTurno();
	public void atacar(Posicionable posicionable) {
		this.atacar(posicionable);
		
	}


	
//esta bien redefinir los metodos heredados?
	
	public void desplazarHaciaLaDerecha(int cantidadDePosiciones) throws MovimientosPorTurnoExcedidosError {
		
		if (this.cantidadDeMovimientos >= this.movimientosPermitidos) {
			
			throw new MovimientosPorTurnoExcedidosError ();
			
		}
		
		this.posicion.desplazarHaciaLaDerecha (cantidadDePosiciones);
		
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
