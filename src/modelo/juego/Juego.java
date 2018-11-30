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
	//private ListaCircular<Jugador> jugadores;
	private Jugador jugadorActual;
	
	public Juego () {
		
		this.mapa = new Mapa ();
        this.mapa.iniciarMapaVacio();
        //this.jugadores = new ListaCircular<Jugador>();
        Jugador jugador1 = new Jugador(this.mapa, "ABC");
        Jugador jugador2 = new Jugador(this.mapa, "XYZ");
        jugador1.setEnemigo(jugador2);
        jugador2.setEnemigo(jugador1);
        //jugadores.insertarPrimero(jugador2);
        //jugadores.insertarPrimero(jugador1);

		//this.jugadorActual = new Jugador (mapa,"Pepito");
        this.jugadorActual = jugador1;
	}

	public void agregarUnidadEnFilaColumna(Unidad unidad, int fila, int columna) throws PosicionFueraDelMapaError, PosicionOcupadaError {
		
		this.mapa.posicionarEnFilaColumna(unidad, fila, columna);
		this.jugadorActual.agregarPosicionableEnFilaColumna (unidad, fila, columna);
		
	}
	
	public void agregarEdifcioDesdeHasta (Edificio edificio, int desdeX, int desdeY, int hastaX, int hastaY) throws PosicionOcupadaError, PosicionFueraDelMapaError {
		
		this.mapa.ponerEdificioDesdeHasta(edificio, desdeX, desdeY, hastaX, hastaY);
	}

	public void iniciarJuego() {
		
		//Jugador jugadorActual = this.jugadores.devolverPrimero();
		
		jugadorActual.crearCastilloDesde(4, 4);
		jugadorActual.crearPlazaCentralPropiaDesde(1, 8);
		jugadorActual.iniciarAldeanosPropiosDesde(8, 6);
		
		//this.jugadores.siguiente();
		//jugadorActual = this.jugadores.devolverPrimero();
		jugadorActual = this.jugadorActual.jugadorSiguiente();
		
		jugadorActual.crearCastilloDesde(this.mapa.getFilas() - 6, this.mapa.getColumnas() - 6);		
		jugadorActual.crearPlazaCentralPropiaDesde(this.mapa.getFilas() - 1, this.mapa.getColumnas() - 8);
		jugadorActual.iniciarAldeanosPropiosDesde(this.mapa.getFilas() - 7, this.mapa.getColumnas() - 7);	
						
	}
	
	public Posicionable obtenerPosicionableEn(Posicion posicion) {
		return this.mapa.obtenerPosicionableEn(posicion);
	}

	public void desplazarUnidadDesdeHasta (int desdeX, int desdeY, int hastaX, int hastaY) {
		
		this.jugadorActual.posicionarDesdeEnHasta (desdeX, desdeY, hastaX, hastaY);
	}
	
	public void avanzarTurno () {
		this.jugadorActual.avanzarTurno();
		this.jugadorActual = this.jugadorActual.jugadorSiguiente();
	}

}
