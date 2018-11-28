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

		return (this.mapa.get(posicion).estaOcupado());

	}
	
	public void buscarPosicionYUbicar(Unidad unidad,Posicion posicion) throws PosicionOcupadaError {
		
		//busco la posicion desocupada para crear una unidad
		Posicion posicionAux = new Posicion(posicion.getFila(), posicion.getColumna());
		posicionAux.desplazarHaciaAbajo(1);
		int contador = 1;
		while(this.estaOcupado(posicionAux)) {
			posicionAux.desplazarHaciaLaDerecha(1);
			contador++;
			if(contador > 5) {
				posicionAux.desplazarHaciaLaIzquierda(5);
				posicionAux.desplazarHaciaAbajo(1);
				contador = 1;
			}
		}		
		this.posicionarPosicionableEnPosicion(unidad, posicionAux);
		unidad.posicionarEnPosicion(posicionAux);
		
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

	public int getFilas() {
		return this.filas;
	}

	public int getColumnas() {
		return this.columnas;
	}

	public void ponerEdificioDesdeHasta(Posicionable edificio, int desdeX, int desdeY, int hastaX, int hastaY) throws PosicionOcupadaError, PosicionFueraDelMapaError{

		if (this.hayPosicionOcupadaEnElRango(desdeX, desdeY, hastaX, hastaY)){
			throw new PosicionOcupadaError();
		}

		for (int i = desdeX; i <= hastaX; i++){
			for (int j = desdeY; j <= hastaY; j++){
				this.posicionarEnFilaColumna(edificio, i, j);
			}
		}
	}

	private boolean hayPosicionOcupadaEnElRango(int desdeX, int desdeY, int hastaX, int hastaY){
	
		for (int i = desdeX; i <= hastaX; i++){
			for (int j = desdeY; j <= hastaY; j++){
				
				Posicion posicion = new Posicion(i,j);
				if (this.mapa.get(posicion).estaOcupado()){
					return true;
				}
			}
		}

		return false;


	}
	
	
	
}

