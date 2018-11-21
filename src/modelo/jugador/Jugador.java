package modelo.jugador;

import modelo.edificio.Edificio;

import modelo.edificio.cuartel.Cuartel;
import modelo.edificio.TamanioIncorrectoError;
import modelo.edificio.castillo.Castillo;
import modelo.mapa.Mapa;
import modelo.mapa.Posicion;
import modelo.unidad.MovimientosPorTurnoExcedidosError;
import modelo.unidad.Posicionable;
import modelo.unidad.aldeano.Aldeano;
import modelo.unidad.PosicionFueraDelMapaError;


import java.util.HashMap;
import java.util.Map;



public class Jugador {
	private Map  <Posicion, Posicionable> posicionables;
	private Mapa mapa;
	private String nombre;


	public Jugador () {
		this.posicionables = new HashMap <Posicion, Posicionable> ();
	}



	public Jugador (String nombre) {
		this.posicionables = new HashMap <Posicion, Posicionable> ();
		this.nombre = nombre;
	}

	public String getNombre(){
		return this.nombre;
	}
	public Jugador(Mapa mapa) {

		this.posicionables = new HashMap <Posicion, Posicionable> ();
		this.mapa = mapa;	}
	
	
	public Edificio construirCuartel(int fila,int columna) {
		
		Edificio cuartel = new Cuartel();
		Posicionable posicionable = cuartel;
		this.agregarPosicionableEnFilaColumna(posicionable, fila, columna);
		return cuartel;
		
	}
	
	public void avanzarTurno() {
		//lo que deberia hacer es recorrer el diccionario y avanzar el turno de cada posicionable
		Posicion posicionDelPosicionable = new Posicion (1,1);	//temporal
		this.posicionables.get(posicionDelPosicionable).avanzarTurno();
	}

	public void agregarPosicionableEnFilaColumna(Posicionable posicionable, int fila, int columna) {
		
		Posicion posicionDelPosicionable = new Posicion (fila, columna);
		
		this.posicionables.put(posicionDelPosicionable, posicionable);
		
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

	public void iniciarUnidades() throws PosicionFueraDelMapaError, PosicionOcupadaError {
	
		for (int i = 5; i <= 7; i++ ) {
		    Posicionable aldeano = new Aldeano();
		    this.agregarPosicionableEnFilaColumna(aldeano, 5, i);
		    this.mapa.posicionarEnFilaColumna(aldeano, 5, i);
        }

		/*
        Posicionable aldeano1 = new Aldeano();
        Posicionable aldeano2 = new Aldeano();
        Posicionable aldeano3 = new Aldeano();

        this.agregarPosicionableEnFilaColumna(aldeano1, 5,5);
        this.agregarPosicionableEnFilaColumna(aldeano2, 5,6);
        this.agregarPosicionableEnFilaColumna(aldeano3, 5,7);
        this.mapa.posicionarEnFilaColumna(aldeano1, 5, 5);
        this.mapa.posicionarEnFilaColumna(aldeano2, 5, 6);
        this.mapa.posicionarEnFilaColumna(aldeano3, 5, 7);
        */
		
	}

	public void iniciarEdificios() throws TamanioIncorrectoError, PosicionFueraDelMapaError, PosicionOcupadaError {

		this.crearCastilloDesdeHasta(1,1,4,4);
		//this.crearPlazaCentralDesdeHasta(1,6,2,7);	
	}

	public void crearCastilloDesdeHasta(int desdeX, int desdeY, int hastaX, int hastaY) throws TamanioIncorrectoError, PosicionFueraDelMapaError, PosicionOcupadaError{

		Castillo castillo = new Castillo();

		if (! castillo.tieneTamanioCorrecto(desdeX, desdeY, hastaX, hastaY)){
			throw new TamanioIncorrectoError();
		}

		Posicion posicionDesde = new Posicion (desdeX, desdeY);
		Posicion posicionHasta = new Posicion (hastaX, hastaY);

		if (posicionDesde.noPerteneceAlRango(this.mapa.getFilas(), this.mapa.getColumnas())){
			throw new PosicionFueraDelMapaError ();
		}

		if (posicionHasta.noPerteneceAlRango(this.mapa.getFilas(), this.mapa.getColumnas())){
			throw new PosicionFueraDelMapaError ();
		}

		this.mapa.ponerEdificioDesdeHasta(castillo, desdeX, desdeY, hastaX, hastaY);
		this.agregarEdificioAPosicionables(castillo, desdeX, desdeY, hastaX, hastaY);

	}

	private void agregarEdificioAPosicionables(Posicionable edificio, int desdeX, int desdeY, int hastaX, int hastaY){

		for (int i = desdeX; i <= hastaX; i++){
			for (int j = desdeY; j <= hastaY; j++){
				this.agregarPosicionableEnFilaColumna(edificio, i, j);
			}
		}

	}
}
