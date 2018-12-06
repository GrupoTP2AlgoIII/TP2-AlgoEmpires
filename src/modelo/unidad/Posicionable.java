package modelo.unidad;

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

	//public abstract boolean estaEnRangoDePosicion (Posicion posicion, int alcanceEnFila, int alcanceEnColumna);

	public abstract void desplazarHasta(Posicion hasta);

	public abstract void recibirPosicionable();

	public  Unidad crearUnidad(char tipo) {
		throw new CrearUnidadException();
	}

	//Para que funcione ataque
	public  Unidad crearUnidadPropia(char tipo, Jugador jugador)
	{
		throw new CrearUnidadException();
	}


	public int descontarOro(int oro) {
		if(oro >= this.costo) {
			oro -= this.costo;
			return oro;
		}else
			throw new JugadorSinOroException();
	}

	public int decrementarProduccion(int produccionDeOro) {
		return produccionDeOro;
	}

	public int aumentarProduccionDeOro(int produccionDeOro) {
		return produccionDeOro;
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

}
