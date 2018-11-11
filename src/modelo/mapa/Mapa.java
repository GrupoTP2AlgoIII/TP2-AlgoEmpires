package modelo.mapa;

import java.util.HashMap;


import java.util.Map;

import modelo.unidad.PosicionFueraDelMapaError;
import modelo.unidad.Posicionable;


public class Mapa {
	
	private Map <Posicion, Casillero> mapa; // <clave, valor>
	private final int filas;
	private final int columnas;
	
	public Mapa () {
		this.mapa = new HashMap <Posicion, Casillero>();
		this.filas = 50;
		this.columnas = 50;
	}
	
	public void iniciarMapa () { 
		
		//esto despues sera un submetodo llamado iniciar mapa vacio
		//y va a haber otro metodo para poner las unidades y edificios basicos
		for (int i = 1; i <= this.filas; i++) {
			for (int j = 1; j <= this.columnas; j++) {
				
				Posicion posicion = new Posicion(i,j);
				Casillero casillero = new Casillero(posicion);
				this.mapa.put(posicion, casillero);
			}
		}
	}
	
	public int obtenerTamanioMapa() {
		
		return this.mapa.size();
	}

/*
	public void posicionarEnFilaColumna(Posicionable posicionable, int fila, int columna) throws PosicionFueraDelMapaError {
		
		Posicion posicionDelPosicionable = new Posicion (fila, columna);
		
		if (posicionDelPosicionable.noPerteneceAlRango(this.filas, this.columnas)) {
			
			throw new PosicionFueraDelMapaError ();
		}
		
		Casillero casilleroDelPosicionable = new Casillero (posicionDelPosicionable, posicionable);
		
		this.mapa.put(posicionDelPosicionable, casilleroDelPosicionable);
		
	}

	public void desplazarFilaColumnaHaciaLaIzquierda(int fila, int columna, int cantidadDePosiciones) throws PosicionFueraDelMapaError {
		
		Posicion posicionInicial = new Posicion (fila, columna);
		
		if (posicionInicial.noPerteneceAlRango (this.filas, this.columnas)) {
			
			throw new PosicionFueraDelMapaError ();
		}
		
		posicionInicial.desplazarHaciaLaIzquierda(cantidadDePosiciones);
		
		if (posicionInicial.noPerteneceAlRango (this.filas, this.columnas)) {
			
			throw new PosicionFueraDelMapaError ();
		}
		
		
		//  el casillero que se encuentra en la posicion (fila, columna) ahora debe estar en posicion (fila, columna -1 ).
		 //La clase posicion ya tiene implementado desplazarHaciaLaIzquierda.
		 
		
		
	}

	public void desplazarFilaColumnaHaciaLaDerecha(int fila, int columna, int cantidadDePosiciones) {
		
		// analogo a desplazar anterior
		
	}

	public void desplazarFilaColumnaHaciaArriba(int fila, int columna, int cantidadDePosiciones) {

		// analogo a desplazar anteior
	}

	public void desplazarFilaColumnaHaciaAbajo(int fila, int columna, int cantidadDePosiciones) {

		// analogo a desplazar anterior
	}

	public void desplazarFilaColumnaHaciaLaDiagonalSuperiorDerecha(int fila, int columna, int cantidadDePosiciones) {
		// analogo a desplazar anterior
		
	}

	public void desplazarFilaColumnaHaciaLaDiagonalSuperiorIzquierda(int fila, int columna, int cantidadDePosiciones) {
		//analogo a desplazar anterior
	}

	public void desplazarFilaColumnaHaciaLaDiagonalInferiorDerecha(int fila, int columna, int cantidadDePosiciones) {
		//analogo a desplazar anterior
		
	}

	public void desplazarFilaColumnaHaciaLaDiagonalInferiorIzquierda(int fila, int columna, int cantidadDePosiciones) {
		//analogo a desplazar anterior
		
	}
*/
	
}
