package modelo.mapa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import modelo.edificio.Edificio;
import modelo.unidad.DesplazarAPosicionOcupadaError;
import modelo.unidad.PosicionFueraDelMapaError;
import modelo.unidad.Posicionable;
import modelo.unidad.Unidad;
import modelo.unidad.aldeano.Aldeano;
import modelo.vacio.Vacio;


public class Mapa {
	
	private Map <Posicion, Posicionable> mapa; // <clave, valor>
	private Map <Posicion, Posicionable> mapaAux;
	private final int filas;
	private final int columnas;

	public Mapa () {
		this.mapa = new HashMap <Posicion, Posicionable>();
		this.mapaAux = new HashMap <Posicion, Posicionable>();
		this.filas = 30;
		this.columnas = 30;
		this.iniciarMapaVacio();
	}
	
	private void iniciarMapaVacio () { 
		
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

	public void buscarPosicionYUbicar(Unidad unidad,Posicion posicion) {
		
		 ArrayList <Posicion> posicionesDeSpawn = posicion.generarPosicionesDeSpawn();		 	 
		 boolean repetir = true;
		   while(repetir){	   
			   try {
				Posicion posicionActual =  posicionesDeSpawn.remove(0);
		    	this.posicionarPosicionableEnPosicion(unidad,posicionActual);
		   		unidad.posicionarEnPosicion(posicionActual);
		    	repetir = false;
		       } catch(DesplazarAPosicionOcupadaError e){
		    	   
		       }
		   }	
	}

	public void posicionarEnFilaColumna(Posicionable posicionable, int fila, int columna) {
		
		Posicion posicionDelPosicionable = new Posicion (fila, columna);
		
		if (!this.mapa.containsKey(posicionDelPosicionable)) {
			
			throw new PosicionFueraDelMapaError ();
		}
		
		this.mapa.get(posicionDelPosicionable).recibirPosicionable();
		this.mapa.put(posicionDelPosicionable, posicionable);
		this.mapaAux.put(posicionDelPosicionable, posicionable);
	}
	
	public void posicionarPosicionableEnPosicion(Posicionable posicionable, Posicion posicion)  {
		
		if (!this.mapa.containsKey(posicion)) {
			throw new PosicionFueraDelMapaError();
		}
		
		this.mapa.get(posicion).recibirPosicionable();
		this.mapa.put(posicion,  posicionable);
		this.mapaAux.put(posicion, posicionable);
		
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

		// Si hay posicion ocupada, arroja error
		for (int i = desdeX; i <= hastaX; i++) {
			for (int j = desdeY; j <= hastaY; j++) {
				Posicion posicion = new Posicion(i,j);
				this.mapa.get(posicion).recibirPosicionable();				
			}
		}

		for (int i = desdeX; i <= hastaX; i++){
			for (int j = desdeY; j <= hastaY; j++){
				this.posicionarEnFilaColumna(edificio, i, j);
			}
		}
	}

	public void posicionarDesdeEnHasta(Posicion desde, Posicion hasta) {
		
		if (!this.mapa.containsKey(desde) || !this.mapa.containsKey(hasta)) {
			throw new PosicionFueraDelMapaError ();
		}
		
		Posicionable posicionableADesplazar = this.mapa.get(desde);
		Posicionable posicionableEnPosicionHasta = this.mapa.get(hasta);
		posicionableEnPosicionHasta.recibirPosicionable();
		posicionableADesplazar.desplazarHasta (hasta);
		this.mapa.replace(hasta,posicionableEnPosicionHasta,posicionableADesplazar);
		this.mapa.replace(desde,posicionableADesplazar,new Vacio(desde));
		
	}

	public Map <Posicion, Posicionable> ponerEdificio(Edificio edificio, Posicion posicionDeConstruccion) {
	
		this.mapaAux.clear();
		
		ArrayList<Posicion> posicionesDelEdificio = edificio.calcularPosiciones(posicionDeConstruccion);
		while(!posicionesDelEdificio.isEmpty()) {	   
			Posicion posicionActual = posicionesDelEdificio.remove(0);
		 	this.posicionarPosicionableEnPosicion(edificio,posicionActual);
			edificio.posicionarEnPosicion(posicionActual);
		}	
		return this.mapaAux;	
	}
	
	public HashMap<Posicion, Posicionable> crearRangoDeAtacablesEn(int desdeX, int desdeY, int lado, int rango){
		
		//ArrayList<Posicionable> atacables = new ArrayList<Posicionable>();
		HashMap<Posicion, Posicionable> atacables = new HashMap <Posicion, Posicionable>();
		
		int hastaX = desdeX + lado;
		int hastaY = desdeY + lado;
				
		for (int i = (desdeX - rango); i <= (hastaX + rango); i++) {
			for (int j = (desdeY - rango); j <= (hastaY + rango); j++) {
				Posicion posicion = new Posicion (i,j);
				//atacables.add( this.obtenerPosicionableEn(posicion));
				atacables.put(posicion, this.obtenerPosicionableEn(posicion));
			}
		}
		
		return atacables;
		
	}

//	public void atacar(int desdeX, int desdeY, int hastaX, int hastaY) {
//		
//		Posicion posicionAtacante = new Posicion (desdeX, desdeY);
//		Posicion posicionRecibeElAtaque = new Posicion (hastaX, hastaY);
//		
//		Posicionable atacante = this.mapa.get(posicionAtacante);
//		Posicionable recibeElAtaque = this.mapa.get(posicionRecibeElAtaque);
//		
//		atacante.atacar(recibeElAtaque, posicionRecibeElAtaque);
//		
//		
//	}
	
	public void actualizarMapa() {
		for(Posicion actual : this.mapa.keySet()) {
			Posicionable posicionableActual = this.mapa.get(actual);
			if(posicionableActual.getVida() <= 0) {
				this.mapa.put(actual, new Vacio(actual));
			}
		}
	}

	public void sePuedeConstruirEn(Posicion posicionDeConstruccion, char tipoConstruccion) {
		Aldeano aldeano = new Aldeano();
		Edificio unEdificio = aldeano.construir(tipoConstruccion);
		ArrayList<Posicion> posicionesDelEdificio = unEdificio.calcularPosiciones(posicionDeConstruccion);	  
		for(Posicion validar : posicionesDelEdificio) {	   
			this.mapa.get(validar).recibirPosicionable();
		}
		
	}

}
