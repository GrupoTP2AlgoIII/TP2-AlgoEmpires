package modelo.juego;

import modelo.jugador.Jugador;
import modelo.jugador.PosicionOcupadaError;
import modelo.mapa.Mapa;
import modelo.mapa.Posicion;
import modelo.unidad.PosicionFueraDelMapaError;
import modelo.unidad.Posicionable;
import modelo.unidad.Unidad;
import modelo.edificio.Edificio;

public class Juego {
	
	private Mapa mapa;
	private Jugador jugadorActual;
	
	public Juego (String nombreJugador1, String nombreJugador2) {
		
		this.mapa = new Mapa ();
        this.jugadorActual = new Jugador (this.mapa, nombreJugador1, nombreJugador2);
        this.iniciarJuego();
        
	}
	
	public void iniciarJuego() {
		this.jugadorActual.iniciarPosicionables();
	}
	
	public void desplazarUnidadDesdeHasta (int desdeX, int desdeY, int hastaX, int hastaY) {
		
		this.jugadorActual.posicionarDesdeEnHasta (desdeX, desdeY, hastaX, hastaY);
	}

	public void agregarUnidadEnFilaColumna(Unidad unidad, int fila, int columna) {
		
		this.jugadorActual.agregarPosicionableEnFilaColumna (unidad, fila, columna);
		
	}
	
	public void agregarEdificioDesdeHasta (Edificio edificio, int desdeX, int desdeY, int hastaX, int hastaY) throws PosicionOcupadaError, PosicionFueraDelMapaError {
		
		this.mapa.ponerEdificioDesdeHasta(edificio, desdeX, desdeY, hastaX, hastaY);
	}

	public Posicionable obtenerPosicionableEn(Posicion posicion) {
		return this.mapa.obtenerPosicionableEn(posicion);
	}

	public void avanzarTurno () {
		this.jugadorActual.avanzarTurno();
		this.jugadorActual = this.jugadorActual.jugadorSiguiente();
		
		// Esto podria quedar
		// this.JugadorActual = jugadorActual.avanzarTurno(); si el metodo en la clase Jugador devuelve el enemigo
	}
	
	// METODOS PARA LA VISTA
	
	public int obtenerOroJugadorActual() {
		return this.jugadorActual.obtenerOro();
	}
	
	public int obtenerCantidadPoblacionJugadorActual() {
		return this.jugadorActual.obtenerCantidadPoblacion();
	}
	
	public int obtenerVidaPosicionableEn (int x, int y) {
		return this.mapa.obtenerPosicionableEn(new Posicion(x,y)).getVida();
	}


}
