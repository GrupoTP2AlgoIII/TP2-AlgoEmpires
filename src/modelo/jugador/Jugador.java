package modelo.jugador;

import modelo.edificio.Edificio;

import modelo.edificio.cuartel.Cuartel;
import modelo.edificio.TamanioIncorrectoError;
import modelo.edificio.castillo.Castillo;
import modelo.edificio.plazaCentral.PlazaCentral;
import modelo.mapa.Mapa;
import modelo.mapa.Posicion;
import modelo.mapa.PosicionNoAdyacenteError;
import modelo.unidad.Posicionable;
import modelo.unidad.Unidad;
import modelo.unidad.aldeano.Aldeano;
import modelo.vacio.Vacio;
import modelo.unidad.PosicionFueraDelMapaError;


import java.util.HashMap;
import java.util.Map;



public class Jugador {
	private Map  <Posicion, Posicionable> posicionables;
	private Mapa mapa;
	private String nombre;
	private InventarioJugador inventario;

	public Jugador(Mapa mapa,String nombre) {

		this.posicionables = new HashMap <Posicion, Posicionable> ();
		this.mapa = mapa;
		this.nombre = nombre;
		
		int oroInicial = 200;
		int poblacionInicial = 3; //3 aldeanos
		int produccionOroInicial = 60; //3 aldeanos
		
		this.inventario = new InventarioJugador(oroInicial,poblacionInicial,produccionOroInicial);
	}


	public String getNombre(){
		return this.nombre;
	}
	
	public Edificio construirCuartel(int fila,int columna) {
		//se debe pasar el aldeano que construye
		Edificio cuartel = new Cuartel();
		Posicionable posicionable = cuartel;
		this.agregarPosicionableEnFilaColumna(posicionable, fila, columna);
		return cuartel;
		
	}
	
	public void crearAldeano(Posicion plazaCentral){
		Posicionable plaza = this.posicionables.get(plazaCentral);

		Unidad aldeano =  plaza.crearAldeano();
		this.inventario.descontarOro(aldeano);
		this.inventario.aumentarPoblacion();
		this.inventario.aumentarProduccionDeOro();
	
		this.mapa.buscarPosicionYUbicar(aldeano,plazaCentral);
		this.posicionables.put(aldeano.getPosicion(),aldeano);
	}
	
	public void avanzarTurno() {
		
		this.actualizarPosicionables();
		posicionables.forEach((k,v) -> {
			this.inventario.aumentarOro(v.avanzarTurno());
		});
		
		//this.CastilloAtacarEnSuRango();
	}
	
//	public void CastilloAtacarEnSuRango(){
//		
//		
//	}
	
	//elimina a los posicionables con vida cero y lo pone en vacio
	private void actualizarPosicionables() {
		int produccionOroAldeano = 20;
		Posicionable vacio = new Vacio();
		posicionables.forEach((k,v) -> {
			if(v.getVida() <= 0) {
				if(v.avanzarTurno() == produccionOroAldeano) {
					this.inventario.decrementarProduccionDeOro();
				}
				posicionables.replace(k,v, vacio);
				this.inventario.decrementarPoblacion();
			}
		});
	}

	public void agregarPosicionableEnFilaColumna(Posicionable posicionable, int fila, int columna) {
		
		Posicion posicionDelPosicionable = new Posicion (fila, columna);
		
		this.posicionables.put(posicionDelPosicionable, posicionable);
		
	}
	
	// Borrar el metodo agregar edificio a posicionables y agregarle la linea del mapa al metodo de arriba
	public void agregarEdificioDesdeHasta (Edificio edificio, int desdeX, int desdeY, int hastaX, int hastaY) {
		
		for (int i = desdeX; i <= hastaX; i++) {
			for (int j = desdeY; j <= hastaY; j++) {
				Posicion posicion = new Posicion (i,j);
				this.posicionables.put(posicion, edificio);
				this.mapa.posicionarEnFilaColumna(edificio, i, j);
			}
		}
		
	}

	public void iniciarAldeanosDesde(int x, int y)  {
	
		for (int i = y; i <= (y + 2); i++ ) {
		    Posicionable aldeano = new Aldeano();
		    this.agregarPosicionableEnFilaColumna(aldeano, x, i);
		    this.mapa.posicionarEnFilaColumna(aldeano, x, i);
        }
		
	}


	public void crearCastilloDesdeHasta(int desdeX, int desdeY, int hastaX, int hastaY) {

		Edificio castillo = new Castillo(0);
		
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
	
	public void crearPlazaCentralDesdeHasta(int desdeX, int desdeY, int hastaX, int hastaY) {
		
		Edificio plazaCentral = new PlazaCentral(0);

		if (! plazaCentral.tieneTamanioCorrecto(desdeX, desdeY, hastaX, hastaY)){
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

		this.mapa.ponerEdificioDesdeHasta(plazaCentral, desdeX, desdeY, hastaX, hastaY);
		this.agregarEdificioAPosicionables(plazaCentral, desdeX, desdeY, hastaX, hastaY);
	}

	private void agregarEdificioAPosicionables(Posicionable edificio, int desdeX, int desdeY, int hastaX, int hastaY) {

		for (int i = desdeX; i <= hastaX; i++){
			for (int j = desdeY; j <= hastaY; j++){
				this.agregarPosicionableEnFilaColumna(edificio, i, j);
			}
		}

	}

	
	public Map <Posicion, Posicionable> getPosicionables() {
		return this.posicionables;
	}

	
//METODOS PARA PRUEBAS


	public int getPoblacion() {
		return this.inventario.getPoblacion();
	}


	public void posicionarDesdeEnHasta(int desdeX, int desdeY, int hastaX, int hastaY) {
		
		if (hastaX > desdeX + 1 || hastaX < desdeX - 1 || hastaY > desdeY + 1 || hastaY < desdeY - 1) {
			throw new PosicionNoAdyacenteError ();
		}
		this.mapa.posicionarDesdeEnHasta (new Posicion (desdeX, desdeY),new Posicion (hastaX, hastaY));
		
	}
	
	
	
}
