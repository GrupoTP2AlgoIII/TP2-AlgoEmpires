package modelo.unidad;

import modelo.ataque.Ataque;
import modelo.edificio.Edificio;
import modelo.mapa.Posicion;

public abstract class Posicionable {
	
	protected Posicion posicion;
	
	public Posicionable () {
		
		this.posicion = new Posicion ();
	}
 
    public Posicionable (int fila, int columna) {
		this.posicion = new Posicion(fila, columna);
	}
	
	public Posicionable(Posicion posicion) {
		this.posicion = posicion;
	}

	public void posicionarEnFilaColumna(int fila, int columna) {
		
		this.posicion.posicionarEnFilaColumna (fila, columna);
		
	}
	
	public void posicionarEnPosicion (Posicion otraPosicion) {
		this.posicion = otraPosicion;
	}


	public Posicion getPosicion() {
		
		return this.posicion;
		
	}

	public abstract int avanzarTurno();

	public abstract int getVida();

	public abstract void atacado(Ataque ataque);
	
	public abstract boolean estaOcupado();
	
	public abstract boolean estaEnRangoDePosicion (Posicion posicion, int alcanceEnFila, int alcanceEnColumna);

	public abstract void desplazarHasta(Posicion hasta);

	public abstract void recibirPosicionable();
	
	public  Unidad crearUnidad(char tipo) {
		throw new CrearUnidadException();
	}

	public abstract int descontarOro(int oro);

	public abstract int decrementarProduccion(int produccionDeOro);
	
	public abstract int aumentarProduccionDeOro(int produccionDeOro);

	public Edificio construir(char tipoConstruccion) {
		throw new ConstruccionEdificioException();
	}

}
