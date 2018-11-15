package modelo.juego;

import modelo.jugador.Jugador;
import modelo.jugador.PosicionDesocupadaError;
import modelo.jugador.PosicionOcupadaError;
import modelo.mapa.Mapa;
import modelo.unidad.MovimientosPorTurnoExcedidosError;
import modelo.unidad.PosicionFueraDelMapaError;
import modelo.unidad.Unidad;
import modelo.edificio.TamanioIncorrectoError;

public class Juego {
	
	private Mapa mapa;
	private Jugador jugadorActual;
	
	public Juego () {
		
		this.mapa = new Mapa ();
        this.mapa.iniciarMapaVacio();
		this.jugadorActual = new Jugador (mapa);
	}

	public void agregarUnidadEnFilaColumna(Unidad unidad, int fila, int columna) throws PosicionFueraDelMapaError, PosicionOcupadaError {
		
		this.mapa.posicionarEnFilaColumna(unidad, fila, columna);
		this.jugadorActual.agregarPosicionableEnFilaColumna (unidad, fila, columna);
		
	}

	public void desplazarFilaColumnaHaciaArriba(int fila, int columna, int cantidadDePosiciones) throws MovimientosPorTurnoExcedidosError, PosicionOcupadaError, PosicionDesocupadaError {
		
		
		this.jugadorActual.desplazarFilaColumnaHaciaArriba (fila, columna, cantidadDePosiciones);
		
	}

	public void iniciarJuego() throws PosicionFueraDelMapaError, PosicionOcupadaError, TamanioIncorrectoError {
		
		//this.mapa.iniciarMapaVacio();
		this.jugadorActual.iniciarUnidades();
		//this.jugadorActual.iniciarEdificios();

		
	}
	
	public void desplazarFilaColumnaHaciaAbajo(int fila, int columna, int cantidadDePosiciones) throws MovimientosPorTurnoExcedidosError, PosicionOcupadaError, PosicionDesocupadaError {
		
		
		this.jugadorActual.desplazarFilaColumnaHaciaAbajo(fila, columna, cantidadDePosiciones);
		
	}

	public void desplazarFilaColumnaHaciaLaDerecha(int fila, int columna, int cantidadDePosiciones) throws MovimientosPorTurnoExcedidosError, PosicionOcupadaError, PosicionDesocupadaError {
	
	
		this.jugadorActual.desplazarFilaColumnaHaciaLaDerecha (fila, columna, cantidadDePosiciones);
	
	}

	public void desplazarFilaColumnaHaciaLaIzquierda(int fila, int columna, int cantidadDePosiciones) throws MovimientosPorTurnoExcedidosError, PosicionOcupadaError, PosicionDesocupadaError {
	
	
		this.jugadorActual.desplazarFilaColumnaHaciaLaIzquierda (fila, columna, cantidadDePosiciones);
	
	}

	public void desplazarFilaColumnaHaciaLaDiagonalSuperiorDerecha(int fila, int columna, int cantidadDePosiciones) throws MovimientosPorTurnoExcedidosError, PosicionOcupadaError, PosicionDesocupadaError {
	
	
		this.jugadorActual.desplazarFilaColumnaHaciaLaDiagonalSuperiorDerecha (fila, columna, cantidadDePosiciones);
	
	}

	public void desplazarFilaColumnaHaciaLaDiagonalSuperiorIzquierda(int fila, int columna, int cantidadDePosiciones) throws MovimientosPorTurnoExcedidosError, PosicionOcupadaError, PosicionDesocupadaError {
	
	
		this.jugadorActual.desplazarFilaColumnaHaciaLaDiagonalSuperiorIzquierda(fila, columna, cantidadDePosiciones);
	
	}

	public void desplazarFilaColumnaHaciaLaDiagionalInferiorDerecha(int fila, int columna, int cantidadDePosiciones) throws MovimientosPorTurnoExcedidosError, PosicionOcupadaError, PosicionDesocupadaError {
	
	
		this.jugadorActual.desplazarFilaColumnaHaciaLaDiagonalInferiorDerecha(fila, columna, cantidadDePosiciones);
	
	}
	
	public void desplazarFilaColumnaHaciaLaDiagionalInferiorIzquierda(int fila, int columna, int cantidadDePosiciones) throws MovimientosPorTurnoExcedidosError, PosicionOcupadaError, PosicionDesocupadaError {
		
		
		this.jugadorActual.desplazarFilaColumnaHaciaLaDiagonalInferiorIzquierda (fila, columna, cantidadDePosiciones);
		
	}

	
}
