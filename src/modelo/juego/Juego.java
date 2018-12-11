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
        this.jugadorActual.iniciarPosicionables();
        
	}
	
	public void desplazarUnidadDesdeHasta (int desdeX, int desdeY, int hastaX, int hastaY) {
		
		this.jugadorActual.posicionarDesdeEnHasta (new Posicion(desdeX,desdeY), new Posicion(hastaX,hastaY));
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
		this.actualizarJuego();
		this.jugadorActual = this.jugadorActual.jugadorSiguiente();
		this.jugadorActual.actualizar();
		
	}	
	
//	public void atacar (int desdeX, int desdeY, int hastaX, int hastaY) {
//		
//		this.mapa.atacar (desdeX, desdeY, hastaX, hastaY);
//	}
	
	public void crearUnidadPropia (Posicion posicionEdificio, char tipoUnidad) {
		
		this.jugadorActual.crearUnidadPropia(posicionEdificio, tipoUnidad);
	}
	
	public void crearEdificioPropio (Posicion posicionAldeano, Posicion posicionDeConstruccion, char tipoConstruccion) {
		
		this.jugadorActual.construirEdificioPropio(posicionAldeano, posicionDeConstruccion, tipoConstruccion);
	}
	
	// Metodo para un test
	
	public void cambiarJugadorActual() {
		this.jugadorActual = jugadorActual.jugadorSiguiente();
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
	
	public String obtenerNombreJugadorActual() {
		return this.jugadorActual.getNombre();
	}
	
	public Posicionable obtener (int x,int y) {
		Posicion esta = new Posicion(x,y);
		return (this.mapa.obtenerPosicionableEn(esta));
	}
	
	public String obtenerColorJugadorActual() {
		return this.jugadorActual.obtenerColor();
	}

	public int obtenerProduccionOro() {
		return this.jugadorActual.obtenerPoblacion().obtenerProduccionOro();
	}
	
	public Jugador obtenerJugadorActual() {
		return this.jugadorActual;
	}
	
	public Mapa obtenerMapa() {
		return this.mapa;
	}
	
	public void actualizarJuego() {
		this.jugadorActual.actualizar();
		this.mapa.actualizarMapa();
	}
	
}
