package modelo.unidad.armaDeAsedio;

import modelo.ataque.Ataque;
import modelo.edificio.Edificio;
import modelo.mapa.Posicion;
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
		this.estado = new ArmaDeAsedioDesmontada ();
		this.cantidadDeMovimientos = 0;
		this.movimientosPermitidos = 1;
		
	}
	
	@Override
	public void desplazarHasta(Posicion hasta) {
		this.posicion = estado.desplazarPosicionHasta(hasta, this.posicion);
	}
	
	public void atacar(Edificio atacado) {
		
		estado.atacar(atacado,this, this.posicion, this.alcance, this.ataque);

	}

	public void atacar(Unidad atacado) {
		
		estado.atacar(atacado,this, this.posicion, this.alcance, this.ataque);

	}
	
	
	
	public void montar() {	
		this.estado = new ArmaDeAsedioMontandose();
		
	}
	
	public void desarmar () {
		this.estado = new ArmaDeAsedioDesmontandose();
	}
	
	public int avanzarTurno () {	
		this.estado = this.estado.avanzarTurno();
		this.cantidadDeMovimientos = 0;
		return 0;
	}
	


	

}
