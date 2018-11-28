package modelo.unidad;

import modelo.ataque.Ataque;
import modelo.mapa.Posicion;

public abstract class Unidad extends Posicionable {
	
	protected int cantidadDeMovimientos;
	protected int movimientosPermitidos;
	protected int vida;
	protected int costo;
	protected Ataque ataque;
	protected int alcance;
	
	public Unidad () {
		
		this.cantidadDeMovimientos = 0;
		this.movimientosPermitidos = 1;
	}


	// Agrego este constructor
	public Unidad(int x, int y) {
		super (x, y);
		this.cantidadDeMovimientos = 0;
		this.movimientosPermitidos = 1;
	}
	
	
	public void desplazarHasta (Posicion hasta) {
		if (this.cantidadDeMovimientos >= this.movimientosPermitidos) {
			
			throw new MovimientosPorTurnoExcedidosError ();
			
		}
		
		this.cantidadDeMovimientos ++;
		this.posicionarEnPosicion(hasta);
		
	}
	
	public void recibirPosicionable () {
		throw new DesplazarAPosicionOcupadaError ();
	}
	
	public abstract void atacar (Posicionable posicionable);
	
	/*
     * devuelve si el posicionable se encuentra dentro de la cuadricula formada por el alcanceEnFila y alcanceEnColumna
     * a partri de la posicion.
     */

	public boolean estaEnRangoDePosicion (Posicion posicion, int alcanceEnFila, int alcanceEnColumna) {
		
		return this.posicion.perteneceALaCuadricula(posicion, alcanceEnFila, alcanceEnColumna);
	}
	
	public void atacado(Ataque ataque) {
		this.vida -= ataque.getAtaqueUnidad();
		
	}

	public int getVida() {
		return this.vida;
	}
	
	public int avanzarTurno() {
		return 0;
	}
	
	@Override
	public boolean estaOcupado() {
		return true;		
	}


	public abstract int descontarOro(int oro);




}
