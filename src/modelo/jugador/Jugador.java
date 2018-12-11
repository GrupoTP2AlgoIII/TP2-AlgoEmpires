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
import java.util.HashMap;
import java.util.Map;



public class Jugador {
	private Mapa mapa;
	private String nombre;
	private Jugador enemigo;
	private Poblacion poblacion;
	private Castillo castillo;
	private String color = "red";
	
	public Jugador(Mapa mapa, String nombreJugador, String nombreEnemigo) {

		this.mapa = mapa;
		this.nombre = nombreJugador;
		String colorEnemigo = "lightblue";
		
		this.iniciarAtributos();
			
		this.enemigo = new Jugador (mapa, nombreEnemigo, this, colorEnemigo);

	}
	
	public Jugador (Mapa mapa, String nombre, Jugador jugador, String color) {
		
		this.mapa = mapa;
		this.nombre = nombre;
		this.color = color;
		
		this.iniciarAtributos();
		
		this.enemigo = jugador;
		
	}
	
	private void iniciarAtributos () {

		this.poblacion = new Poblacion(new HashMap <Posicion, Posicionable> ());
		
	}
	
	public void iniciarPosicionables () {
		
		this.crearCastilloDesde(4, 4);
		this.crearPlazaCentralPropiaDesde(4, 10);
		this.iniciarAldeanosPropiosDesde(8, 6);	
				
		this.enemigo.crearCastilloDesde(this.mapa.getFilas() - 6, this.mapa.getColumnas() - 6);		
		this.enemigo.crearPlazaCentralPropiaDesde(this.mapa.getFilas() - 6, this.mapa.getColumnas() - 10);
		this.enemigo.iniciarAldeanosPropiosDesde(this.mapa.getFilas() - 7, this.mapa.getColumnas() - 7);
	}
	
	//PARA QUE ANDE ATAQUE
	public void construirEdificioPropio(Posicion posicionAldeano,Posicion posicionDeConstruccion,char tipoConstruccion) {
		//posicionAldeano.comprobarAdyacencia(posicionDeConstruccion);
		this.mapa.sePuedeConstruirEn(posicionDeConstruccion,tipoConstruccion);
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
	
	public void montarArmaDeAsedio(Posicion posicionDelArma) {
		Posicionable armaDeAsedio = this.poblacion.obtenerPosicionable(posicionDelArma);
		armaDeAsedio.montar();
	}
	
	public void desmontarArmaDeAsedio (Posicion posicionDelArma) {
		Posicionable armaDeAsedio = this.poblacion.obtenerPosicionable(posicionDelArma);
		armaDeAsedio.desarmar();
	}
	
	public void atacar (Posicion atacante,Posicion atacado) {
		this.poblacion.posicionablePerteneceAJugador(atacante);
		Posicionable posicionableAtacante = this.poblacion.obtenerPosicionable(atacante);
		Posicionable posicionableAtacado = this.mapa.obtenerPosicionableEn(atacado);
		posicionableAtacante.atacar(posicionableAtacado);	
	}
	
	public void reparar (Posicion aldeano,Posicion edificio) {
		this.poblacion.posicionablePerteneceAJugador(aldeano);
		this.poblacion.posicionablePerteneceAJugador(edificio);
		aldeano.comprobarAdyacencia(edificio);
		Posicionable posicionableAldeano = this.mapa.obtenerPosicionableEn(aldeano);
		Posicionable posicionableEdificio = this.mapa.obtenerPosicionableEn(edificio);
		posicionableAldeano.reparar(posicionableEdificio);
	}

	public void avanzarTurno() {
		HashMap<Posicion, Posicionable> atacables = this.mapa.crearRangoDeAtacablesEn(castillo.posicionDesde(), castillo.calcularLado(), castillo.calcularRango());		
		this.castillo.atacarEnemigosAlAlcance(atacables);
		this.poblacion.actualizar();
		this.poblacion.avanzarTurno();
	}

	public void agregarPosicionableEnFilaColumna(Posicionable posicionable, int fila, int columna) {

		Posicion posicionDelPosicionable = new Posicion (fila, columna);

		this.mapa.posicionarEnFilaColumna(posicionable, fila, columna);
		this.poblacion.agregarPosicionable(posicionDelPosicionable, posicionable);

	}
	
	public void actualizar() {
		this.poblacion.quitarPosicionablesDestruidos();
		this.poblacion.actualizar();
	}

	public void iniciarAldeanosPropiosDesde(int x, int y)  {

		for (int i = y; i <= (y +2); i++ ) {
			Unidad aldeano = new Aldeano(this,new Posicion(x,i));
			this.agregarPosicionableEnFilaColumna(aldeano,x,i);
			this.poblacion.aumentarPoblacion(aldeano);
		}

	}

	public void crearCastilloDesde(int desdeX, int desdeY) {
		
		Posicion desde = new Posicion(desdeX,desdeY);
		castillo = new Castillo(0, this,desde);
		Map <Posicion, Posicionable> castilloConstruido = this.mapa.ponerEdificio(castillo, desde);
		this.poblacion.agregarEdificio(castilloConstruido);
		
	}

	public void crearPlazaCentralPropiaDesde(int desdeX, int desdeY) {

		Edificio plazaCentral = new PlazaCentral(0,this);
		Posicion posicionDesde = new Posicion (desdeX, desdeY);
		Map <Posicion, Posicionable> plazaConstruida = this.mapa.ponerEdificio(plazaCentral, posicionDesde);
		this.poblacion.agregarEdificio(plazaConstruida);
	}

	public void posicionarDesdeEnHasta(Posicion desde,Posicion hasta) {
		int desdeX = desde.getFila();
		int desdeY = desde.getColumna();
		int hastaX = hasta.getFila();
		int hastaY = hasta.getColumna();
		
		if(!this.poblacion.posicionableEstaEnPoblacion(desde)) {
			throw new PosicionNoPerteneceAJugadorException();
		}
				
		if (hastaX > desdeX + 1 || hastaX < desdeX - 1 || hastaY > desdeY + 1 || hastaY < desdeY - 1) {
			throw new PosicionNoAdyacenteError ();
		}
		
		this.mapa.posicionarDesdeEnHasta (desde,hasta);
		this.poblacion.reemplazarPosicionDesdeEnHasta (desde,hasta);

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
	
	
	// Metodos para vista
	
	public int obtenerOro() {
		return this.poblacion.obtenerOro();
	}
	
	public int obtenerCantidadPoblacion() {
		return this.poblacion.obtenerCantidadPoblacion();
	}
	
	public String obtenerColor() {
		return this.color;
	}

	public void perderLaPartida() {
		
		throw new JuegoFinalizadoException (this.enemigo.getNombre());
	}
	
}