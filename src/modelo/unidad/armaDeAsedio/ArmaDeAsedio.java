package modelo.unidad.armaDeAsedio;

import modelo.ataque.Ataque;
import modelo.edificio.Edificio;
import modelo.mapa.Posicion;
import modelo.unidad.MovimientosPorTurnoExcedidosError;
import modelo.unidad.Posicionable;
import modelo.unidad.Unidad;

public class ArmaDeAsedio extends Unidad {

	private int alcance = 5;
	private EstadoArmaDeAsedio estado;
	
	public ArmaDeAsedio() {
		this.vida = 150;
		this.costo = 200;
		this.ataque = new Ataque(75,0, this.alcance);
		
	}
	
	public ArmaDeAsedio(int fila, int columna) {
		
		super (fila, columna);
		this.vida = 150;
		this.costo = 200;
		this.ataque = new Ataque(75,0, this.alcance);
		this.estado = new ArmaDeAsedioDesmontada (1);
		this.cantidadDeMovimientos = 0;
		this.movimientosPermitidos = 1;
		
	}
	
	@Override
	public void atacar(Posicionable posicionable) {
		
		estado.atacar(posicionable, this.posicion, this.alcance, this.ataque);

	}
	
	@Override
	public void atacar (Edificio edificio, Posicion posicionAtacado) {
		estado.atacar(edificio, posicionAtacado,  this.posicion, this.alcance, this.ataque);
	}
	
	@Override
	public void atacar (Unidad unidad, Posicion posicionAtacado) {
		estado.atacar(unidad, posicionAtacado, this.posicion, this.alcance, this.ataque);
	}

	public void montar() {	
		this.estado = new ArmaDeAsedioMontada (1);
		
	}
	
	public int avanzarTurno () {	
		estado.avanzarTurno();
		return 0;
	}
	
	@Override
	public void desplazarHasta (Posicion hasta) {
		if (this.cantidadDeMovimientos >= this.movimientosPermitidos) {
			
			throw new MovimientosPorTurnoExcedidosError ();
			
		}
		
		this.cantidadDeMovimientos ++;
		
		estado.desplazarPosicionHasta (hasta, this.posicion);
		
	}

	

}
