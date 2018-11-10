package modelo;

import java.util.HashMap;
import java.util.Map;


public class Mapa {
	
	private Map <Posicion, Casillero> mapa; // <clave, valor>
	private final int filas;
	private final int columnas;
	
	Mapa () {
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
}
