package modelo.jugador;

import modelo.edificio.cuartel.Cuartel;
import modelo.mapa.Mapa;
import modelo.mapa.Posicion;
import modelo.unidad.MovimientosPorTurnoExcedidosError;
import modelo.unidad.Posicionable;
import modelo.unidad.Unidad;

import java.util.HashMap;
import java.util.Map;


public class Jugador {
	private Cuartel jugadores [];
	private boolean jugadorActual;
	private Map  <Posicion, Posicionable> posicionables;
	private Mapa mapa;
	
	
	public Jugador () {
		
		this.jugadores = new Cuartel[2];
		this.jugadorActual = true;
		this.posicionables = new HashMap <Posicion, Posicionable> ();
	}
	public Jugador(Mapa mapa) {
		this.jugadores = new Cuartel[2];
		this.jugadorActual = true;
		this.posicionables = new HashMap <Posicion, Posicionable> ();
		this.mapa = mapa;
	}
	
	public Cuartel construirCuartel() {
		Cuartel cuartel = new Cuartel();
		if(this.jugadorActual) {
			this.jugadores[0] = cuartel;
		}else {
			this.jugadores[1] = cuartel;
		}
		return cuartel;
	}
	
	public void avanzarTurno() {
		Cuartel aux;
		if(this.jugadorActual) {
			aux = this.jugadores[0];
			aux.avanzarTurno();
			this.jugadores[0]=aux;
		}else{
			aux = this.jugadores[1];
			aux.avanzarTurno();
			this.jugadores[1]=aux;
		}
	
		this.jugadorActual = !(this.jugadorActual);
	}

	public void agregarPosicionableEnFilaColumna(Unidad unidad, int fila, int columna) {
		
		Posicion posicionDelPosicionable = new Posicion (fila, columna);
		
		this.posicionables.put(posicionDelPosicionable, unidad);
		
	}

	public void desplazarFilaColumnaHaciaArriba(int fila, int columna, int cantidadDePosiciones) throws MovimientosPorTurnoExcedidosError, PosicionDesocupadaError, PosicionOcupadaError {
		
		Posicion posicionDesplazable = new Posicion (fila, columna);
		
		if (!this.mapa.estaOcupado (posicionDesplazable)) {
			
			throw new PosicionDesocupadaError ();
			
		}
		
		Posicionable posicionableEnPosicion = this.posicionables.get(posicionDesplazable);
		posicionableEnPosicion.desplazarHaciaArriba (1);
		posicionDesplazable.desplazarHaciaArriba (1);
		this.mapa.posicionarPosicionableEnPosicion (posicionableEnPosicion, posicionDesplazable);
		
		
	}
	
	public void desplazarFilaColumnaHaciaAbajo(int fila, int columna, int cantidadDePosiciones) throws MovimientosPorTurnoExcedidosError, PosicionOcupadaError, PosicionDesocupadaError {
		
		Posicion posicionDesplazable = new Posicion (fila, columna);
		
		if (!this.mapa.estaOcupado (posicionDesplazable)) {
			
			throw new PosicionDesocupadaError ();
			
		}
		
		Posicionable posicionableEnPosicion = this.posicionables.get(posicionDesplazable);
		posicionableEnPosicion.desplazarHaciaAbajo (1);
		posicionDesplazable.desplazarHaciaAbajo (1);
		this.mapa.posicionarPosicionableEnPosicion (posicionableEnPosicion, posicionDesplazable);
		
		
	}
	
	public void desplazarFilaColumnaHaciaLaDerecha(int fila, int columna, int cantidadDePosiciones) throws MovimientosPorTurnoExcedidosError, PosicionOcupadaError, PosicionDesocupadaError {
		
		Posicion posicionDesplazable = new Posicion (fila, columna);
		
		if (!this.mapa.estaOcupado (posicionDesplazable)) {
			
			throw new PosicionDesocupadaError ();
			
		}
		
		Posicionable posicionableEnPosicion = this.posicionables.get(posicionDesplazable);
		posicionableEnPosicion.desplazarHaciaLaDerecha (1);
		posicionDesplazable.desplazarHaciaLaDerecha (1);
		this.mapa.posicionarPosicionableEnPosicion (posicionableEnPosicion, posicionDesplazable);
		
		
	}
	
	public void desplazarFilaColumnaHaciaLaIzquierda(int fila, int columna, int cantidadDePosiciones) throws MovimientosPorTurnoExcedidosError, PosicionOcupadaError, PosicionDesocupadaError {
		
		Posicion posicionDesplazable = new Posicion (fila, columna);
		
		if (!this.mapa.estaOcupado (posicionDesplazable)) {
			
			throw new PosicionDesocupadaError ();
			
		}
		
		Posicionable posicionableEnPosicion = this.posicionables.get(posicionDesplazable);
		posicionableEnPosicion.desplazarHaciaLaIzquierda (1);
		posicionDesplazable.desplazarHaciaLaIzquierda (1);
		this.mapa.posicionarPosicionableEnPosicion (posicionableEnPosicion, posicionDesplazable);
		
		
	}
	
	public void desplazarFilaColumnaHaciaLaDiagonalSuperiorDerecha(int fila, int columna, int cantidadDePosiciones) throws MovimientosPorTurnoExcedidosError, PosicionOcupadaError, PosicionDesocupadaError {
		
		Posicion posicionDesplazable = new Posicion (fila, columna);
		
		if (!this.mapa.estaOcupado (posicionDesplazable)) {
			
			throw new PosicionDesocupadaError ();
			
		}
		
		Posicionable posicionableEnPosicion = this.posicionables.get(posicionDesplazable);
		posicionableEnPosicion.desplazarHaciaLaDiagonalSuperiorDerecha (1);
		posicionDesplazable.desplazarHaciaLaDiagonalSuperiorDerecha (1);
		this.mapa.posicionarPosicionableEnPosicion (posicionableEnPosicion, posicionDesplazable);
		
		
	}
	
	public void desplazarFilaColumnaHaciaLaDiagonalSuperiorIzquierda(int fila, int columna, int cantidadDePosiciones) throws MovimientosPorTurnoExcedidosError, PosicionOcupadaError, PosicionDesocupadaError {
		
		Posicion posicionDesplazable = new Posicion (fila, columna);
		
		if (!this.mapa.estaOcupado (posicionDesplazable)) {
			
			throw new PosicionDesocupadaError ();
			
		}
		
		Posicionable posicionableEnPosicion = this.posicionables.get(posicionDesplazable);
		posicionableEnPosicion.desplazarHaciaLaDiagonalSuperiorIzquierda(1);
		posicionDesplazable.desplazarHaciaLaDiagonalSuperiorIzquierda (1);
		this.mapa.posicionarPosicionableEnPosicion (posicionableEnPosicion, posicionDesplazable);
		
		
	}
	
	public void desplazarFilaColumnaHaciaLaDiagonalInferiorIzquierda(int fila, int columna, int cantidadDePosiciones) throws MovimientosPorTurnoExcedidosError, PosicionOcupadaError, PosicionDesocupadaError {
		
		Posicion posicionDesplazable = new Posicion (fila, columna);
		
		if (!this.mapa.estaOcupado (posicionDesplazable)) {
			
			throw new PosicionDesocupadaError ();
			
		}
		
		Posicionable posicionableEnPosicion = this.posicionables.get(posicionDesplazable);
		posicionableEnPosicion.desplazarHaciaLaDiagonalInferiorIzquierda (1);
		posicionDesplazable.desplazarHaciaLaDiagonalInferiorIzquierda (1);
		this.mapa.posicionarPosicionableEnPosicion (posicionableEnPosicion, posicionDesplazable);
		
		
	}
	
	public void desplazarFilaColumnaHaciaLaDiagonalInferiorDerecha(int fila, int columna, int cantidadDePosiciones) throws MovimientosPorTurnoExcedidosError, PosicionOcupadaError, PosicionDesocupadaError {
		
		Posicion posicionDesplazable = new Posicion (fila, columna);
		
		if (!this.mapa.estaOcupado (posicionDesplazable)) {
			
			throw new PosicionDesocupadaError ();
			
		}
		
		Posicionable posicionableEnPosicion = this.posicionables.get(posicionDesplazable);
		posicionableEnPosicion.desplazarHaciaLaDiagonalInferiorIzquierda (1);
		posicionDesplazable.desplazarHaciaLaDiagonalInferiorIzquierda(1);
		this.mapa.posicionarPosicionableEnPosicion (posicionableEnPosicion, posicionDesplazable);
		
		
	}
}
