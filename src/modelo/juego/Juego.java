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

	
}
