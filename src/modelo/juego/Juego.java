package modelo.juego;

import modelo.jugador.Jugador;
import modelo.jugador.PosicionOcupadaError;
import modelo.mapa.Mapa;
import modelo.mapa.Posicion;
import modelo.unidad.PosicionFueraDelMapaError;
import modelo.unidad.Posicionable;
import modelo.unidad.Unidad;
import modelo.edificio.Edificio;
import modelo.edificio.TamanioIncorrectoError;

public class Juego {
	
	private Mapa mapa;
	private ListaCircular<Jugador> jugadores;
	private Jugador jugadorActual;
	
	public Juego () {
		
		this.mapa = new Mapa ();
        this.mapa.iniciarMapaVacio();
        this.jugadores = new ListaCircular<Jugador>();
        Jugador jugador1 = new Jugador(this.mapa, "ABC");
        Jugador jugador2 = new Jugador(this.mapa, "XYZ");
        jugadores.insertarPrimero(jugador2);
        jugadores.insertarPrimero(jugador1);

		this.jugadorActual = new Jugador (mapa,"Pepito");
	}

	public void agregarUnidadEnFilaColumna(Unidad unidad, int fila, int columna) throws PosicionFueraDelMapaError, PosicionOcupadaError {
		
		this.mapa.posicionarEnFilaColumna(unidad, fila, columna);
		this.jugadorActual.agregarPosicionableEnFilaColumna (unidad, fila, columna);
		
	}
	
	public void agregarEdifcioDesdeHasta (Edificio edificio, int desdeX, int desdeY, int hastaX, int hastaY) throws PosicionOcupadaError, PosicionFueraDelMapaError {
		
		this.mapa.ponerEdificioDesdeHasta(edificio, desdeX, desdeY, hastaX, hastaY);
	}

	public void iniciarJuego() throws PosicionFueraDelMapaError, PosicionOcupadaError, TamanioIncorrectoError {
		
		Jugador jugadorActual = this.jugadores.devolverPrimero();
		
		jugadorActual.crearCastilloDesde(1, 1);
		jugadorActual.crearPlazaCentralDesde(1, 8);
		jugadorActual.iniciarAldeanosDesde(5, 5);
		
		this.jugadores.siguiente();
		jugadorActual = this.jugadores.devolverPrimero();
		
		//jugadorActual.crearCastilloDesdeHasta(47, 47, 50, 50);
		jugadorActual.crearCastilloDesde(this.mapa.getFilas() - 3, this.mapa.getColumnas() - 3);
		//jugadorActual.crearPlazaCentralDesdeHasta(49, 42, 50, 43);
		jugadorActual.crearPlazaCentralDesde(this.mapa.getFilas() - 1, this.mapa.getColumnas() - 8);
		//jugadorActual.iniciarAldeanosDesde(46, 44);
		jugadorActual.iniciarAldeanosDesde(this.mapa.getFilas() - 4, this.mapa.getColumnas() - 6);	
						
	}
	
	public Posicionable obtenerPosicionableEn(Posicion posicion) {
		return this.mapa.obtenerPosicionableEn(posicion);
	}

	public void desplazarUnidadDesdeHasta (int desdeX, int desdeY, int hastaX, int hastaY) {
		
		this.jugadorActual.posicionarDesdeEnHasta (desdeX, desdeY, hastaX, hastaY);
	}
	
	

}
