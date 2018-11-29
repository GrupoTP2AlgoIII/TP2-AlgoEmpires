package modelo.unidad;

import modelo.ataque.Ataque;
import modelo.edificio.Edificio;
import modelo.mapa.Posicion;

public abstract class Unidad extends Posicionable {
	
	protected int cantidadDeMovimientos;
	protected int movimientosPermitidos;
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
	
	public void recibirDanio (int danio) {
		this.vida -= danio;
	}
	
	public void recibirDanioDe (Posicionable posicionable) {
		posicionable.atacar(this);
	}
	
	public void recibirDanioDe (Unidad unidad) {
		unidad.atacar(this);
	}
	
	public void recibirDanioDe (Edificio edificio) {
		edificio.atacar(this);
	}
	
	public void atacar (Posicionable posicionable) {
		posicionable.recibirDanioDe(this);
	}
	
	public void atacar (Unidad unidad) {
		this.ataque.atacar(unidad);
	}
	
	public void atacar (Edificio edificio) {
		this.ataque.atacar(edificio);
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
	
	/*
     * devuelve si el posicionable se encuentra dentro de la cuadricula formada por el alcanceEnFila y alcanceEnColumna
     * a partri de la posicion.
     */

	public boolean estaEnRangoDePosicion (Posicion posicion, int alcanceEnFila, int alcanceEnColumna) {
		
		return this.posicion.perteneceALaCuadricula(posicion, alcanceEnFila, alcanceEnColumna);
	}

	public int getVida() {
		return this.vida;
	}
	







}
