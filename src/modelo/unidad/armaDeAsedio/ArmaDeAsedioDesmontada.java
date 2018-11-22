package modelo.unidad.armaDeAsedio;

import modelo.ataque.ArmaDeAsedioDesmontadaNoPuedeAtacarError;
import modelo.ataque.Ataque;
import modelo.mapa.Posicion;
import modelo.unidad.MovimientosPorTurnoExcedidosError;
import modelo.unidad.Posicionable;

public class ArmaDeAsedioDesmontada implements EstadoArmaDeAsedio {
	
	private int turnosDesmontada;
	
	public ArmaDeAsedioDesmontada (int cantidadDeTurnosParaDesmontar) {
		
		this.turnosDesmontada = cantidadDeTurnosParaDesmontar;
		
	}

	@Override
	public void atacar(Posicionable posicionable, Posicion posicion, int alcance, Ataque ataque) throws ArmaDeAsedioDesmontadaNoPuedeAtacarError {
		
		throw new ArmaDeAsedioDesmontadaNoPuedeAtacarError ();

	}

	@Override
	public void avanzarTurno() {
		
		this.turnosDesmontada --;
		
	}
		
	public void desplazarHaciaLaDerecha(int cantidadDePosiciones, int cantidadDeMovimientos, int movimientosPermitidos, Posicion posicion) throws MovimientosPorTurnoExcedidosError, ArmaDeAsedioDesmontadaNoPuedeAtacarError, ArmaDeAsedioMontadaNoPuedeDesplazarseError {
		
		if (this.turnosDesmontada > 0) {
			throw new ArmaDeAsedioMontadaNoPuedeDesplazarseError ();
		}
		if (cantidadDeMovimientos >= movimientosPermitidos) {
			
			throw new MovimientosPorTurnoExcedidosError ();
			
		}
		
		posicion.desplazarHaciaLaDerecha (cantidadDePosiciones);
		
	}

	public void desplazarHaciaLaIzquierda(int cantidadDePosiciones, int cantidadDeMovimientos, int movimientosPermitidos, Posicion posicion) throws MovimientosPorTurnoExcedidosError, ArmaDeAsedioDesmontadaNoPuedeAtacarError, ArmaDeAsedioMontadaNoPuedeDesplazarseError {
		
		if (this.turnosDesmontada > 0) {
			throw new ArmaDeAsedioMontadaNoPuedeDesplazarseError ();		}
		if (cantidadDeMovimientos >= movimientosPermitidos) {
			
			throw new MovimientosPorTurnoExcedidosError ();
			
		}

		posicion.desplazarHaciaLaIzquierda (cantidadDePosiciones);
		
	}

	public void desplazarHaciaArriba(int cantidadDePosiciones, int cantidadDeMovimientos, int movimientosPermitidos, Posicion posicion) throws MovimientosPorTurnoExcedidosError, ArmaDeAsedioDesmontadaNoPuedeAtacarError, ArmaDeAsedioMontadaNoPuedeDesplazarseError {
		
		if (this.turnosDesmontada > 0) {
			throw new ArmaDeAsedioMontadaNoPuedeDesplazarseError ();		}
		if (cantidadDeMovimientos >= movimientosPermitidos) {
			
			throw new MovimientosPorTurnoExcedidosError ();
			
		}
		
		cantidadDeMovimientos ++;
		posicion.desplazarHaciaArriba (cantidadDePosiciones);
		
	}

	public void desplazarHaciaAbajo(int cantidadDePosiciones, int cantidadDeMovimientos, int movimientosPermitidos, Posicion posicion) throws MovimientosPorTurnoExcedidosError, ArmaDeAsedioDesmontadaNoPuedeAtacarError, ArmaDeAsedioMontadaNoPuedeDesplazarseError {
		
		if (this.turnosDesmontada > 0) {
			throw new ArmaDeAsedioMontadaNoPuedeDesplazarseError ();		}
		if (cantidadDeMovimientos >= movimientosPermitidos) {
			
			throw new MovimientosPorTurnoExcedidosError ();
			
		}

		posicion.desplazarHaciaAbajo (cantidadDePosiciones);
		
	}

	public void desplazarHaciaLaDiagonalSuperiorDerecha(int cantidadDePosiciones, int cantidadDeMovimientos, int movimientosPermitidos, Posicion posicion) throws MovimientosPorTurnoExcedidosError, ArmaDeAsedioDesmontadaNoPuedeAtacarError, ArmaDeAsedioMontadaNoPuedeDesplazarseError {
		
		if (this.turnosDesmontada > 0) {
			throw new ArmaDeAsedioMontadaNoPuedeDesplazarseError ();		}
		if (cantidadDeMovimientos >= movimientosPermitidos) {
			
			throw new MovimientosPorTurnoExcedidosError ();
			
		}
		
		posicion.desplazarHaciaLaDiagonalSuperiorDerecha (cantidadDePosiciones);
		
	}

	public void desplazarHaciaLaDiagonalSuperiorIzquierda(int cantidadDePosiciones, int cantidadDeMovimientos, int movimientosPermitidos, Posicion posicion) throws MovimientosPorTurnoExcedidosError, ArmaDeAsedioDesmontadaNoPuedeAtacarError, ArmaDeAsedioMontadaNoPuedeDesplazarseError {
		
		if (this.turnosDesmontada > 0) {
			throw new ArmaDeAsedioMontadaNoPuedeDesplazarseError ();		}
		if (cantidadDeMovimientos >= movimientosPermitidos) {
			
			throw new MovimientosPorTurnoExcedidosError ();
			
		}
		
		posicion.desplazarHaciaLaDiagonalSuperiorIzquierda (cantidadDePosiciones);
		
	}

	public void desplazarHaciaLaDiagonalInferiorDerecha(int cantidadDePosiciones, int cantidadDeMovimientos, int movimientosPermitidos, Posicion posicion) throws MovimientosPorTurnoExcedidosError, ArmaDeAsedioDesmontadaNoPuedeAtacarError, ArmaDeAsedioMontadaNoPuedeDesplazarseError {
		
		if (this.turnosDesmontada > 0) {
			throw new ArmaDeAsedioMontadaNoPuedeDesplazarseError ();		}
		if (cantidadDeMovimientos >= movimientosPermitidos) {
			
			throw new MovimientosPorTurnoExcedidosError ();
			
		}

		posicion.desplazarHaciaLaDiagonalInferiorDerecha (cantidadDePosiciones);
		
	}

	public void desplazarHaciaLaDiagonalInferiorIzquierda(int cantidadDePosiciones, int cantidadDeMovimientos, int movimientosPermitidos, Posicion posicion) throws MovimientosPorTurnoExcedidosError, ArmaDeAsedioDesmontadaNoPuedeAtacarError, ArmaDeAsedioMontadaNoPuedeDesplazarseError {
		
		if (this.turnosDesmontada > 0) {
			throw new ArmaDeAsedioMontadaNoPuedeDesplazarseError ();		}
		if (cantidadDeMovimientos >= movimientosPermitidos) {
			
			throw new MovimientosPorTurnoExcedidosError ();
			
		}
		
		posicion.desplazarHaciaLaDiagonalInferiorIzquierda (cantidadDePosiciones);
	}

}
