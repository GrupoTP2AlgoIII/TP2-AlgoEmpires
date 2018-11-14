package modelo.jugador;

import modelo.edificio.Edificio;
import modelo.edificio.cuartel.Cuartel;
import modelo.mapa.Mapa;
import modelo.mapa.Posicion;
import modelo.unidad.MovimientosPorTurnoExcedidosError;
import modelo.unidad.Posicionable;
import modelo.unidad.Unidad;
import modelo.unidad.aldeano.Aldeano;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Jugador {
	private Map  <Posicion, Posicionable> posicionables;
	private Mapa mapa;
	private List<Edificio> listaCuarteles;		//temporal hasta que funcione el diccionario de posicionables

	public Jugador () {
		this.posicionables = new HashMap <Posicion, Posicionable> ();
		this.listaCuarteles = new ArrayList<Edificio>();
	}
	public Jugador(Mapa mapa) {

		this.posicionables = new HashMap <Posicion, Posicionable> ();
		this.mapa = mapa;
		this.listaCuarteles = new ArrayList<Edificio>();	}
	
	
	public Edificio construirCuartel() {
		
		int vidaCuartel = 450;
		Edificio cuartel = new Cuartel(vidaCuartel);
		this.listaCuarteles.add(cuartel);
		//Posicionable posicionable = cuartel;
		//this.agregarPosicionableEnFilaColumna(posicionable, fila, columna);
		return cuartel;
		
	}
	
	public void avanzarTurno() {
		for (int i = 0; i <= this.listaCuarteles.size()-1; i++) {
            this.listaCuarteles.get(i).avanzarTurno();
        }		
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

	public void iniciarUnidades(Mapa mapa) {
	
		for (int i = 5; i <= 8; i++ ) {
		    Aldeano aldeano = new Aldeano();
		    this.agregarPosicionableEnFilaColumna(aldeano, 5, i);
        }
		
	}
}
