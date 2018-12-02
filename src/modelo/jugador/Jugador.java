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
import modelo.vacio.Vacio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



public class Jugador {
	private Map  <Posicion, Posicionable> posicionables;
	private Mapa mapa;
	private String nombre;
	private InventarioJugador inventario;
	private Jugador enemigo;
	private Poblacion poblacion;
	private Castillo castillo;

	public Jugador(Mapa mapa, String nombreJugador, String nombreEnemigo) {

		this.mapa = mapa;
		this.nombre = nombreJugador;
		
		this.iniciarAtributos();
			
		this.enemigo = new Jugador (mapa, nombreEnemigo);

	}
	
	public Jugador (Mapa mapa, String nombre) {
		
		this.mapa = mapa;
		this.nombre = nombre;
		
		this.iniciarAtributos();	
		
	}
	
	private void iniciarAtributos () {
		
		this.posicionables = new HashMap <Posicion, Posicionable> ();

		int oroInicial = 200;
		int poblacionInicial = 3; //3 aldeanos
		int produccionOroInicial = 60; //3 aldeanos

		this.inventario = new InventarioJugador(oroInicial,poblacionInicial,produccionOroInicial);

		this.poblacion = new Poblacion(this.posicionables);
		
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
	
	// ESTE METODO SE TIENE QUE IR, AVANZAR TURNO DELEGA LA LOGICA A POBLACION Y DEVUELVE EL ENEMIGO
	public Jugador jugadorSiguiente() {
		return this.enemigo;
	}


	public String getNombre(){
		return this.nombre;
	}

	//PARA QUE ANDE ATAQUE
	public void construirEdificioPropio(Posicion posicionAldeano,Posicion posicionDeConstruccion,char tipoConstruccion) {
		posicionAldeano.comprobarAdyacencia(posicionDeConstruccion);
		Posicionable aldeano = this.posicionables.get(posicionAldeano);
		Edificio edificio = aldeano.construirPropio(tipoConstruccion, this);
		this.inventario.descontarOro(edificio);
		Map <Posicion, Posicionable> edificioAgregado = this.mapa.ponerEdificio(edificio,posicionDeConstruccion);
		this.posicionables.putAll(edificioAgregado);
	}

	public void crearUnidadPropia(Posicion posicionEdificio,char tipoUnidad){
		Posicionable edificio = this.posicionables.get(posicionEdificio);
		Unidad unidad =  edificio.crearUnidadPropia(tipoUnidad, this);
		this.inventario.descontarOro(unidad);
		this.inventario.aumentarPoblacion(unidad);
		this.mapa.buscarPosicionYUbicar(unidad,posicionEdificio);
		this.posicionables.put(unidad.getPosicion(),unidad);
	}

	public void avanzarTurno() {
		this.quitarPosicionablesDestruidos();
		Posicionable anterior = null;
		for (Posicionable actual : posicionables.values()){
			if(anterior != actual) {
				int produccionRecursoUnidad =actual.avanzarTurno();
				this.inventario.aumentarOro(produccionRecursoUnidad);
			}
			anterior = actual;
		}

		this.castillo.atacarEnemigosAlAlcance();
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

	public void agregarPosicionableEnFilaColumna(Posicionable posicionable, int fila, int columna) {

		Posicion posicionDelPosicionable = new Posicion (fila, columna);

		this.mapa.posicionarEnFilaColumna(posicionable, fila, columna);
		this.posicionables.put(posicionDelPosicionable, posicionable);
		

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
		ArrayList<Posicionable> atacables = new ArrayList<Posicionable>();
		atacables = this.mapa.crearRangoDeAtacablesEn(desdeX, desdeY, castillo.calcularLado(), castillo.calcularRango());
		//atacables = this.mapa.crearRangoDeAtacablesEn(desdeX, desdeY, castillo); le paso el castillo al mapa
		castillo.setAtacables(atacables);
		this.castillo = castillo;
		Map <Posicion, Posicionable> castilloConstruido = this.mapa.ponerEdificio(castillo, posicionDesde);
		this.posicionables.putAll(castilloConstruido);
		//this.agregarEdificioDesdeHasta(castillo, desdeX, desdeY, desdeX+castillo.calcularLado(), desdeY+castillo.calcularLado()); no es necesario usar los metodos de arriba

	}

	public void crearPlazaCentralPropiaDesde(int desdeX, int desdeY) {

		Edificio plazaCentral = new PlazaCentral(0,this);
		Posicion posicionDesde = new Posicion (desdeX, desdeY);
		Map <Posicion, Posicionable> plazaConstruida = this.mapa.ponerEdificio(plazaCentral, posicionDesde);
		this.posicionables.putAll(plazaConstruida);
	}

	public void posicionarDesdeEnHasta(int desdeX, int desdeY, int hastaX, int hastaY) {

		if (hastaX > desdeX + 1 || hastaX < desdeX - 1 || hastaY > desdeY + 1 || hastaY < desdeY - 1) {
			throw new PosicionNoAdyacenteError ();
		}
		this.mapa.posicionarDesdeEnHasta (new Posicion (desdeX, desdeY),new Posicion (hastaX, hastaY));

	}


	//METODOS PARA PRUEBAS

	public int getPoblacion() {
		return this.inventario.getPoblacion();
	}
	
	public Poblacion obtenerPoblacion(){
		return this.poblacion;
	}
	
	public Posicionable getPosicionable (Posicion posicion) {
		return this.posicionables.get(posicion);
	}
	
	public void setEnemigo (Jugador jugadorEnemigo) {
		this.enemigo = jugadorEnemigo;
	}
	
}