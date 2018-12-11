package modelo.unidad;

import modelo.ataque.Ataque;
import modelo.edificio.Edificio;
import modelo.jugador.Jugador;
import modelo.jugador.JugadorSinOroException;
import modelo.mapa.Posicion;

public abstract class Posicionable {

	protected Posicion posicion;
	protected int vida;
	protected int costo;


	public Posicionable () {

		this.posicion = new Posicion ();
	}

	public Posicionable (int fila, int columna) {
		this.posicion = new Posicion(fila, columna);
	}

	public Posicionable(Posicion posicion) {
		this.posicion = posicion;
	}

	public abstract void recibirDanio (int danio);
	public abstract void recibirDanioDe (Posicionable posicionable);
	public abstract void recibirDanioDe (Unidad unidad);
	public abstract void recibirDanioDe (Edificio edificio);

	public abstract void atacar (Posicionable posicionable);
	public abstract void atacar(Edificio edificio, Posicion posicion);
	public abstract void atacar(Unidad unidad, Posicion posicion2);

	
	public void posicionarEnFilaColumna(int fila, int columna) {

		this.posicion.posicionarEnFilaColumna (fila, columna);

	}

	public void posicionarEnPosicion (Posicion otraPosicion) {
		this.posicion = otraPosicion;
	}

	public int avanzarTurno() {
		return 0;
	}

	public Posicion getPosicion(){
		return this.posicion;
	}

	public abstract void desplazarHasta(Posicion hasta);

	public abstract void recibirPosicionable();

	//Para que funcione ataque
	public  Unidad crearUnidadPropia(char tipo, Jugador jugador) {
		throw new CrearUnidadException();
	}


	public int descontarOro(int oro) {
		if(oro >= this.costo) {
			oro -= this.costo;
			return oro;
		}else
			throw new JugadorSinOroException();
	}

	public int produccionDeOro() {
		return 0;
	}

	public Edificio construir(char tipoConstruccion) {
		throw new ConstruccionEdificioException();
	}

	public Edificio construirPropio(char tipoConstruccion, Jugador jugador) {
		throw new ConstruccionEdificioException();
	}

	//METODOS DE PRUEBAS

	public int getVida() {
		return this.vida;
	}
	
	public int getRango() {	 
		 return this.getAtaque().getRango();
	}

	protected abstract Ataque getAtaque();

	public int getAtaqueUnidad() {
		 return this.getAtaque().getAtaqueUnidad();
	}

	public int getAtaqueEdificio() {
		 return this.getAtaque().getAtaqueEdificio();
	}

	public abstract String obtenerColor();

	public void montar() {
		throw new PosicionableNoSePuedeMontar();		
	}

	public void desarmar() {
		throw new PosicionableNoSePuedeDesmontar();		
	}

	public int decrementarPoblacion() {
		return 0;
	}

	public void reparar(Posicionable posicionableEdificio) {
		throw new PosicionableNoPuedeReparar();		
	}

	public void aceptaReparacion() {
		throw new PosicionableNoAceptaReparacionException();
		
	}

	public void actualizar() {
		
	}
}
