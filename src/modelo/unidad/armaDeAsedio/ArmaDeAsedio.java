package modelo.unidad.armaDeAsedio;

import modelo.ataque.ArmaDeAsedioDesmontadaNoPuedeAtacarError;
import modelo.ataque.AtacandoEnPosicionFueraDelAlcanceError;
import modelo.ataque.Ataque;
import modelo.mapa.Posicion;
import modelo.unidad.MovimientosPorTurnoExcedidosError;
import modelo.unidad.Posicionable;
import modelo.unidad.Unidad;
import modelo.unidad.aldeano.AldeanoNoPuedeAtacarError;

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
	
	public void atacar(Posicionable posicionable) throws AtacandoEnPosicionFueraDelAlcanceError, AldeanoNoPuedeAtacarError, ArmaDeAsedioDesmontadaNoPuedeAtacarError {
		
		estado.atacar(posicionable, this.posicion, this.alcance, this.ataque);

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

	@Override
	public int descontarOro(int oro) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
