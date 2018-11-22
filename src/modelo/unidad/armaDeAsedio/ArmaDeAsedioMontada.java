package modelo.unidad.armaDeAsedio;

import modelo.ataque.ArmaDeAsedioDesmontadaNoPuedeAtacarError;
import modelo.ataque.AtacandoEnPosicionFueraDelAlcanceError;
import modelo.ataque.Ataque;
import modelo.mapa.Posicion;
import modelo.unidad.MovimientosPorTurnoExcedidosError;
import modelo.unidad.Posicionable;

public class ArmaDeAsedioMontada implements EstadoArmaDeAsedio {
	
	private int turnosMontar;
	
	public ArmaDeAsedioMontada (int turnosMontar) {
		
		this.turnosMontar = turnosMontar;
	}

	@Override
	public void atacar(Posicionable posicionable, Posicion posicion, int alcance, Ataque ataque) throws AtacandoEnPosicionFueraDelAlcanceError, ArmaDeAsedioDesmontadaNoPuedeAtacarError {
		
		if (this.turnosMontar > 0) {
			throw new ArmaDeAsedioDesmontadaNoPuedeAtacarError ();
		}
		if (!posicionable.estaEnRangoDePosicion (posicion, alcance, alcance)) {
			throw new AtacandoEnPosicionFueraDelAlcanceError ();
		}
		
		posicionable.atacado(ataque);
	}

	@Override
	public void avanzarTurno() {
		
		this.turnosMontar --;
		
	}
	
	public void desplazarHaciaLaDerecha(int cantidadDePosiciones, int cantidadDeMovimientos, int movimientosPermitidos, Posicion posicion) throws MovimientosPorTurnoExcedidosError, ArmaDeAsedioDesmontadaNoPuedeAtacarError, ArmaDeAsedioMontadaNoPuedeDesplazarseError {
		
		throw new ArmaDeAsedioMontadaNoPuedeDesplazarseError ();
		
	}

	public void desplazarHaciaLaIzquierda(int cantidadDePosiciones, int cantidadDeMovimientos, int movimientosPermitidos, Posicion posicion) throws MovimientosPorTurnoExcedidosError, ArmaDeAsedioDesmontadaNoPuedeAtacarError, ArmaDeAsedioMontadaNoPuedeDesplazarseError {
		
		throw new ArmaDeAsedioMontadaNoPuedeDesplazarseError ();
		
	}

	public void desplazarHaciaArriba(int cantidadDePosiciones, int cantidadDeMovimientos, int movimientosPermitidos, Posicion posicion) throws MovimientosPorTurnoExcedidosError, ArmaDeAsedioDesmontadaNoPuedeAtacarError, ArmaDeAsedioMontadaNoPuedeDesplazarseError {
		
		throw new ArmaDeAsedioMontadaNoPuedeDesplazarseError ();
		
	}

	public void desplazarHaciaAbajo(int cantidadDePosiciones, int cantidadDeMovimientos, int movimientosPermitidos, Posicion posicion) throws MovimientosPorTurnoExcedidosError, ArmaDeAsedioDesmontadaNoPuedeAtacarError, ArmaDeAsedioMontadaNoPuedeDesplazarseError {
		
		throw new ArmaDeAsedioMontadaNoPuedeDesplazarseError ();
		
	}

	public void desplazarHaciaLaDiagonalSuperiorDerecha(int cantidadDePosiciones, int cantidadDeMovimientos, int movimientosPermitidos, Posicion posicion) throws MovimientosPorTurnoExcedidosError, ArmaDeAsedioDesmontadaNoPuedeAtacarError, ArmaDeAsedioMontadaNoPuedeDesplazarseError {
		
		throw new ArmaDeAsedioMontadaNoPuedeDesplazarseError ();
		
	}

	public void desplazarHaciaLaDiagonalSuperiorIzquierda(int cantidadDePosiciones, int cantidadDeMovimientos, int movimientosPermitidos, Posicion posicion) throws MovimientosPorTurnoExcedidosError, ArmaDeAsedioDesmontadaNoPuedeAtacarError, ArmaDeAsedioMontadaNoPuedeDesplazarseError {
		
		throw new ArmaDeAsedioMontadaNoPuedeDesplazarseError ();
		
	}

	public void desplazarHaciaLaDiagonalInferiorDerecha(int cantidadDePosiciones, int cantidadDeMovimientos, int movimientosPermitidos, Posicion posicion) throws MovimientosPorTurnoExcedidosError, ArmaDeAsedioDesmontadaNoPuedeAtacarError, ArmaDeAsedioMontadaNoPuedeDesplazarseError {
		
		throw new ArmaDeAsedioMontadaNoPuedeDesplazarseError ();
		
	}

	public void desplazarHaciaLaDiagonalInferiorIzquierda(int cantidadDePosiciones, int cantidadDeMovimientos, int movimientosPermitidos, Posicion posicion) throws MovimientosPorTurnoExcedidosError, ArmaDeAsedioDesmontadaNoPuedeAtacarError, ArmaDeAsedioMontadaNoPuedeDesplazarseError {
		
		throw new ArmaDeAsedioMontadaNoPuedeDesplazarseError ();
	}

}
