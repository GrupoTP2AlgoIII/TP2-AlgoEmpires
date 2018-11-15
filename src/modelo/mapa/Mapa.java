package modelo.mapa;

import java.util.HashMap;

import java.util.Map;

import modelo.jugador.PosicionOcupadaError;
import modelo.unidad.PosicionFueraDelMapaError;
import modelo.unidad.Posicionable;
import modelo.unidad.Unidad;
import modelo.vacio.Vacio;


public class Mapa {
	
	private Map <Posicion, Posicionable> mapa; // <clave, valor>
	private final int filas;
	private final int columnas;
	
	public Mapa () {
		this.mapa = new HashMap <Posicion, Posicionable>();
		this.filas = 50;
		this.columnas = 50;
	}
	
	public void iniciarMapaVacio () { 
		
		for (int i = 1; i <= this.filas; i++) {
			for (int j = 1; j <= this.columnas; j++) {
				
				Posicion posicion = new Posicion(i, j);
				Posicionable vacio = new Vacio(i, j); 
				this.mapa.put(posicion, vacio);
			}
		}
	}
	
	public int obtenerTamanioMapa() {
		
		return this.mapa.size();
	}

	public boolean estaOcupado(Posicion posicion) {
		
		return (this.mapa.get(posicion).getClass() != Vacio.class);
	}


	public void posicionarEnFilaColumna(Posicionable posicionable, int fila, int columna) throws PosicionFueraDelMapaError, PosicionOcupadaError {
		
		Posicion posicionDelPosicionable = new Posicion (fila, columna);
		
		if (posicionDelPosicionable.noPerteneceAlRango(this.filas, this.columnas)) {
			
			throw new PosicionFueraDelMapaError ();
		}
		
		if (this.estaOcupado(posicionDelPosicionable)) {
			
			throw new PosicionOcupadaError ();
		}
		
		this.mapa.put(posicionDelPosicionable, posicionable);
		
	}
	
	// Agrego este metodo
	// MODULARIZAR
	public void moverDesdeHasta(int desdeX, int desdeY, int hastaX, int hastaY) throws PosicionFueraDelMapaError, PosicionOcupadaError, PosicionNoAdyacenteError {
		
		Posicion posicionDesde = new Posicion (desdeX, desdeY);
		Posicionable posicionable = this.mapa.get(posicionDesde);
		
		if (posicionDesde.noPerteneceAlRango(this.filas, this.columnas)) {
			
			throw new PosicionFueraDelMapaError ();
		}
		
//		if (this.estaOcupado(posicionDesde)) {
//			
//			throw new PosicionOcupadaError ();
//		}
		
		Posicion posicionHasta = new Posicion (hastaX, hastaY);
		
		if(posicionHasta.noPerteneceAlRango(this.filas, this.columnas)) {
			
			throw new PosicionFueraDelMapaError ();
		}
		
//		if (this.estaOcupado(posicionHasta)) {
//			
//			throw new PosicionOcupadaError ();
//		}
		
		if (! posicionHasta.esAdyacenteA(posicionDesde)) {
			
			throw new PosicionNoAdyacenteError();
		}
		
		this.mapa.put(posicionHasta, posicionable);
		
		Posicionable vacio = new Vacio(desdeX, desdeY);
		this.mapa.put(posicionDesde, vacio);
		
	}

	public void desplazarFilaColumnaHaciaLaIzquierda(int fila, int columna, int cantidadDePosiciones) throws PosicionFueraDelMapaError, PosicionOcupadaError {
		
		Posicion posicionInicial = new Posicion (fila, columna);
		
		if (posicionInicial.noPerteneceAlRango (this.filas, this.columnas)) {
			
			throw new PosicionFueraDelMapaError ();
		}
		
		posicionInicial.desplazarHaciaLaIzquierda(cantidadDePosiciones);
		
		if (posicionInicial.noPerteneceAlRango (this.filas, this.columnas)) {
			
			throw new PosicionFueraDelMapaError ();
		}
		
		if (this.estaOcupado(posicionInicial)) {
			
			throw new PosicionOcupadaError ();
		}
		 
	}

	public void desplazarFilaColumnaHaciaLaDerecha(int fila, int columna, int cantidadDePosiciones) throws PosicionFueraDelMapaError, PosicionOcupadaError {
		
		Posicion posicionInicial = new Posicion (fila, columna);
		
		if (posicionInicial.noPerteneceAlRango (this.filas, this.columnas)) {
			
			throw new PosicionFueraDelMapaError ();
		}
		
		posicionInicial.desplazarHaciaLaDerecha(cantidadDePosiciones);
		
		if (posicionInicial.noPerteneceAlRango (this.filas, this.columnas)) {
			
			throw new PosicionFueraDelMapaError ();
			
		}
		
		if (this.estaOcupado(posicionInicial)) {
			
			throw new PosicionOcupadaError ();
		}
		
	}
	

	public void desplazarFilaColumnaHaciaArriba(int fila, int columna, int cantidadDePosiciones) throws PosicionFueraDelMapaError, PosicionOcupadaError {

		Posicion posicionInicial = new Posicion (fila, columna);
		
		if (posicionInicial.noPerteneceAlRango (this.filas, this.columnas)) {
			
			throw new PosicionFueraDelMapaError ();
		}
		
		posicionInicial.desplazarHaciaArriba(cantidadDePosiciones);
		
		if (posicionInicial.noPerteneceAlRango (this.filas, this.columnas)) {
			
			throw new PosicionFueraDelMapaError ();
		}
		
		if (this.estaOcupado(posicionInicial)) {
			
			throw new PosicionOcupadaError ();
		}
		
		
	}

	public void posicionarPosicionableEnPosicion(Posicionable posicionable, Posicion posicion) throws PosicionOcupadaError {
		
		if (this.estaOcupado(posicion)) {
			
			throw new PosicionOcupadaError ();
		}

		this.mapa.put(posicion,  posicionable);
		
	}

	public void desplazarFilaColumnaHaciaAbajo(int fila, int columna, int cantidadDePosiciones) throws PosicionFueraDelMapaError, PosicionOcupadaError {

		Posicion posicionInicial = new Posicion (fila, columna);
		
		if (posicionInicial.noPerteneceAlRango (this.filas, this.columnas)) {
			
			throw new PosicionFueraDelMapaError ();
		}
		
		posicionInicial.desplazarHaciaAbajo(cantidadDePosiciones);
		
		if (posicionInicial.noPerteneceAlRango (this.filas, this.columnas)) {
			
			throw new PosicionFueraDelMapaError ();
		}
		
		if (this.estaOcupado(posicionInicial)) {
			
			throw new PosicionOcupadaError ();
		}
	}

	public void desplazarFilaColumnaHaciaLaDiagonalSuperiorDerecha(int fila, int columna, int cantidadDePosiciones) throws PosicionFueraDelMapaError, PosicionOcupadaError {
		
		Posicion posicionInicial = new Posicion (fila, columna);
		
		if (posicionInicial.noPerteneceAlRango (this.filas, this.columnas)) {
			
			throw new PosicionFueraDelMapaError ();
		}
		
		posicionInicial.desplazarHaciaLaDiagonalSuperiorDerecha(cantidadDePosiciones);
		
		if (posicionInicial.noPerteneceAlRango (this.filas, this.columnas)) {
			
			throw new PosicionFueraDelMapaError ();
		}
		
		if (this.estaOcupado(posicionInicial)) {
			
			throw new PosicionOcupadaError ();
		}
	}

	public void desplazarFilaColumnaHaciaLaDiagonalSuperiorIzquierda(int fila, int columna, int cantidadDePosiciones) throws PosicionFueraDelMapaError, PosicionOcupadaError {

		Posicion posicionInicial = new Posicion (fila, columna);
		
		if (posicionInicial.noPerteneceAlRango (this.filas, this.columnas)) {
			
			throw new PosicionFueraDelMapaError ();
		}
		
		posicionInicial.desplazarHaciaLaDiagonalSuperiorIzquierda(cantidadDePosiciones);
		
		if (posicionInicial.noPerteneceAlRango (this.filas, this.columnas)) {
			
			throw new PosicionFueraDelMapaError ();
		}
		
		if (this.estaOcupado(posicionInicial)) {
			
			throw new PosicionOcupadaError ();
		}
	}

	public void desplazarFilaColumnaHaciaLaDiagonalInferiorDerecha(int fila, int columna, int cantidadDePosiciones) throws PosicionFueraDelMapaError, PosicionOcupadaError {

		Posicion posicionInicial = new Posicion (fila, columna);
		
		if (posicionInicial.noPerteneceAlRango (this.filas, this.columnas)) {
			
			throw new PosicionFueraDelMapaError ();
		}
		
		posicionInicial.desplazarHaciaLaDiagonalInferiorDerecha(cantidadDePosiciones);
		
		if (posicionInicial.noPerteneceAlRango (this.filas, this.columnas)) {
			
			throw new PosicionFueraDelMapaError ();
		}
		
		if (this.estaOcupado(posicionInicial)) {
			
			throw new PosicionOcupadaError ();
		}
		
	}

	public void desplazarFilaColumnaHaciaLaDiagonalInferiorIzquierda(int fila, int columna, int cantidadDePosiciones) throws PosicionFueraDelMapaError, PosicionOcupadaError {
		
		Posicion posicionInicial = new Posicion (fila, columna);
		
		if (posicionInicial.noPerteneceAlRango (this.filas, this.columnas)) {
			
			throw new PosicionFueraDelMapaError ();
		}
		
		posicionInicial.desplazarHaciaLaDiagonalInferiorIzquierda(cantidadDePosiciones);
		
		if (posicionInicial.noPerteneceAlRango (this.filas, this.columnas)) {
			
			throw new PosicionFueraDelMapaError ();
		}
		
		if (this.estaOcupado(posicionInicial)) {
			
			throw new PosicionOcupadaError ();
		}
		
	}
	
	public Posicionable obtenerPosicionableEn(Posicion posicion) {
		return (this.mapa.get(posicion));
	}
	
	
	
}

