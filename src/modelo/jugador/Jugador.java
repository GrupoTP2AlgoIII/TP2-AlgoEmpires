package modelo.jugador;

import modelo.edificio.Edificio;

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

	
	public void construirEdificio(Posicion posicionAldeano,Posicion posicionDeConstruccion,char tipoConstruccion) throws PosicionOcupadaError, PosicionFueraDelMapaError {
		posicionAldeano.comprobarAdyacencia(posicionDeConstruccion);
		Posicionable aldeano = this.posicionables.get(posicionAldeano);
		Edificio edificio = aldeano.construir(tipoConstruccion);
		this.inventario.descontarOro(edificio);
		Map <Posicion, Posicionable> edificioAgregado = this.mapa.ponerEdificio(edificio,posicionDeConstruccion);
		this.posicionables.putAll(edificioAgregado);
	}
	
	public void crearUnidad(Posicion posicionEdificio,char tipoUnidad) throws PosicionFueraDelMapaError, PosicionOcupadaError {
		Posicionable edificio = this.posicionables.get(posicionEdificio);

		Unidad unidad =  edificio.crearUnidad(tipoUnidad);
		this.inventario.descontarOro(unidad);
		this.inventario.aumentarPoblacion(unidad);
		this.mapa.buscarPosicionYUbicar(unidad,posicionEdificio);
		this.posicionables.put(unidad.getPosicion(),unidad);
	}
	
	public void avanzarTurno() {		
		this.quitarPosicionablesDestruidos();
		Posicionable anterior = null;
        for (Posicion posicion : posicionables.keySet()){
            Posicionable actual = posicionables.get(posicion);
            if(anterior != actual) {  	
				int produccionRecursoUnidad =actual.avanzarTurno();
				this.inventario.aumentarOro(produccionRecursoUnidad);
			}
			anterior = actual;        
        }		
		//this.CastilloAtacarEnSuRango();
	}
	
	private void quitarPosicionablesDestruidos() {
		Posicionable vacio = new Vacio();
		for (Posicion posicion : posicionables.keySet()){
			Posicionable actual = posicionables.get(posicion);
			if(actual.getVida() <= 0) {
				this.inventario.decrementarProduccionDeOro(actual);
				posicionables.replace(posicion,actual, vacio);
				this.inventario.decrementarPoblacion();
			}
		}
	}


//	public void CastilloAtacarEnSuRango(){
//		
//		
//	}
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
