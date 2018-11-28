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
	
	public void buscarPosicionYUbicar(Unidad unidad,Posicion posicion) {
		
		//busco la posicion desocupada para crear una unidad
		Posicion posicionAux = new Posicion(posicion.getFila(), posicion.getColumna());
		posicionAux.posicionarEnFilaColumna(posicionAux.getFila() + 1, posicionAux.getColumna());
		int contador = 1;
		while(this.estaOcupado(posicionAux)) {
			posicionAux.posicionarEnFilaColumna(posicionAux.getFila(), posicionAux.getColumna() + 1);
			contador++;
			if(contador > 5) {
				posicionAux.posicionarEnFilaColumna(posicionAux.getFila(), posicionAux.getColumna() - 5);
				posicionAux.posicionarEnFilaColumna(posicionAux.getFila() + 1, posicionAux.getColumna());
				contador = 1;
			}
		}		
		this.posicionarPosicionableEnPosicion(unidad, posicionAux);
		unidad.posicionarEnPosicion(posicionAux);
		
	}


	public void posicionarEnFilaColumna(Posicionable posicionable, int fila, int columna) {
		
		Posicion posicionDelPosicionable = new Posicion (fila, columna);
		
		if (!this.mapa.containsKey(posicionDelPosicionable)) {
			
			throw new PosicionFueraDelMapaError ();
		}
		
		this.mapa.get(posicionDelPosicionable).recibirPosicionable();
		this.mapa.put(posicionDelPosicionable, posicionable);
		
	}
	
	public void posicionarPosicionableEnPosicion(Posicionable posicionable, Posicion posicion)  {
		
		if (this.estaOcupado(posicion)) {
			
			throw new PosicionOcupadaError ();
		}

		this.mapa.put(posicion,  posicionable);
		
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

	public void ponerEdificioDesdeHasta(Posicionable edificio, int desdeX, int desdeY, int hastaX, int hastaY) {

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

	public void posicionarDesdeEnHasta(Posicion desde, Posicion hasta) {
		
		if (!this.mapa.containsKey(desde) || !this.mapa.containsKey(hasta)) {
			throw new PosicionFueraDelMapaError ();
		}
		
		Posicionable posicionableADesplazar = this.mapa.get(desde);
		Posicionable posicionableEnPosicionHasta = this.mapa.get(hasta);
		posicionableADesplazar.desplazarHasta (hasta);
		posicionableEnPosicionHasta.recibirPosicionable();
		this.mapa.put(hasta, posicionableADesplazar);
		this.mapa.put(desde, new Vacio ());
		
	}
}

