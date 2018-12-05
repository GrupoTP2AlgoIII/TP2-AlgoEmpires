package modelo.jugador;

import modelo.edificio.Edificio;

import modelo.edificio.castillo.Castillo;
import modelo.edificio.plazaCentral.PlazaCentral;
import modelo.mapa.Mapa;
import modelo.mapa.Posicion;
import modelo.mapa.PosicionNoAdyacenteError;
import modelo.unidad.Posicionable;
import modelo.unidad.Unidad;
import modelo.unidad.aldeano.Aldeano;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



public class Jugador {
	private Mapa mapa;
	private String nombre;
	private Jugador enemigo;
	private Poblacion poblacion;
	private Castillo castillo;

	public Jugador(Mapa mapa, String nombreJugador, String nombreEnemigo) {

		this.mapa = mapa;
		this.nombre = nombreJugador;
		
		this.iniciarAtributos();
			
		this.enemigo = new Jugador (mapa, nombreEnemigo, this);

	}
	
	public Jugador (Mapa mapa, String nombre, Jugador jugador) {
		
		this.mapa = mapa;
		this.nombre = nombre;
		
		this.iniciarAtributos();
		
		this.enemigo = jugador;
		
	}
	
	private void iniciarAtributos () {

		this.poblacion = new Poblacion(new HashMap <Posicion, Posicionable> ());

		this.castillo = new Castillo(0);
		
	}
	
	public void iniciarPosicionables () {
		
		this.crearCastilloDesde(4, 4);
		this.crearPlazaCentralPropiaDesde(1, 8);
		this.iniciarAldeanosPropiosDesde(8, 6);		
				
		this.enemigo.crearCastilloDesde(this.mapa.getFilas() - 6, this.mapa.getColumnas() - 6);		
		this.enemigo.crearPlazaCentralPropiaDesde(this.mapa.getFilas() - 1, this.mapa.getColumnas() - 8);
		this.enemigo.iniciarAldeanosPropiosDesde(this.mapa.getFilas() - 7, this.mapa.getColumnas() - 7);
	}
	
	//PARA QUE ANDE ATAQUE
	public void construirEdificioPropio(Posicion posicionAldeano,Posicion posicionDeConstruccion,char tipoConstruccion) {
		posicionAldeano.comprobarAdyacencia(posicionDeConstruccion);
		Posicionable aldeano = this.poblacion.obtenerPosicionable(posicionAldeano);
		Edificio edificio = aldeano.construirPropio(tipoConstruccion, this);
		this.poblacion.descontarOro(edificio);
		Map <Posicion, Posicionable> edificioAgregado = this.mapa.ponerEdificio(edificio,posicionDeConstruccion);
		this.poblacion.agregarEdificio(edificioAgregado);
	}

	public void crearUnidadPropia(Posicion posicionEdificio,char tipoUnidad){
		Posicionable edificio = this.poblacion.obtenerEdificio(posicionEdificio);
		Unidad unidad =  edificio.crearUnidadPropia(tipoUnidad, this);
		this.poblacion.descontarOro(unidad);
		this.mapa.buscarPosicionYUbicar(unidad,posicionEdificio);
		this.poblacion.aumentarPoblacion(unidad);
	}

	public void avanzarTurno() {
		this.poblacion.avanzarTurno();
		this.castillo.atacarEnemigosAlAlcance();
	}

	/*
	private void quitarPosicionablesDestruidos() {
		this.poblacion.quitarPosicionablesDestruidos();
	}
*/

	public void agregarPosicionableEnFilaColumna(Posicionable posicionable, int fila, int columna) {

		Posicion posicionDelPosicionable = new Posicion (fila, columna);

		this.mapa.posicionarEnFilaColumna(posicionable, fila, columna);
		this.poblacion.agregarPosicionable(posicionDelPosicionable, posicionable);

	}

	public void iniciarAldeanosPropiosDesde(int x, int y)  {

		for (int i = y; i <= (y +2); i++ ) {
			Unidad aldeano = new Aldeano(this);
			this.agregarPosicionableEnFilaColumna(aldeano, x, i);
			//this.inventario.aumentarPoblacion(aldeano);
		}

	}

	public void crearCastilloDesde(int desdeX, int desdeY) {
		
		Castillo castillo = new Castillo(0);
		Posicion posicionDesde = new Posicion (desdeX, desdeY);
		//ArrayList<Posicionable> atacables = new ArrayList<Posicionable>();
		HashMap<Posicion, Posicionable> atacables = new HashMap<Posicion, Posicionable>();
		atacables = this.mapa.crearRangoDeAtacablesEn(desdeX, desdeY, castillo.calcularLado(), castillo.calcularRango());		
		castillo.setAtacables(atacables);
		this.castillo = castillo;
		Map <Posicion, Posicionable> castilloConstruido = this.mapa.ponerEdificio(castillo, posicionDesde);
		this.poblacion.agregarEdificio(castilloConstruido);
		
	}

	public void crearPlazaCentralPropiaDesde(int desdeX, int desdeY) {

		Edificio plazaCentral = new PlazaCentral(0,this);
		Posicion posicionDesde = new Posicion (desdeX, desdeY);
		Map <Posicion, Posicionable> plazaConstruida = this.mapa.ponerEdificio(plazaCentral, posicionDesde);
		this.poblacion.agregarEdificio(plazaConstruida);
	}

	public void posicionarDesdeEnHasta(int desdeX, int desdeY, int hastaX, int hastaY) {

		if (hastaX > desdeX + 1 || hastaX < desdeX - 1 || hastaY > desdeY + 1 || hastaY < desdeY - 1) {
			throw new PosicionNoAdyacenteError ();
		}
		this.mapa.posicionarDesdeEnHasta (new Posicion (desdeX, desdeY),new Posicion (hastaX, hastaY));

	}
	
	//METODOS PARA PRUEBAS

	public int getPoblacion() {
		return this.poblacion.getCantidad();
	}
	
	public Poblacion obtenerPoblacion(){
		return this.poblacion;
	}
	
	public Posicionable getPosicionable (Posicion posicion) {
		return this.poblacion.obtenerPosicionable(posicion);
	}
	
	public Jugador jugadorSiguiente() {
		return this.enemigo;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public void castilloAtacar () {
		this.castillo.atacarEnemigosAlAlcance();
	}
	
	
}