package modelo.unidad.arquero;

import modelo.ataque.Ataque;
import modelo.unidad.Posicionable;
import modelo.unidad.Unidad;

public class Arquero extends Unidad {

	
	public Arquero() {
		this.vida = 75;
		this.costo = 75;
		this.ataque = new Ataque(10,15);
	}
	
	@Override
	public int avanzarTurno() {
		return 0;
	}

	@Override
	public int getVida() {
		return this.vida;
	}
	
	public void atacar(Posicionable posicionable) {
		posicionable.atacado(ataque);
	}

	@Override
	public void atacado(Ataque ataque) {
		this.vida -= ataque.getAtaqueUnidad();
		
	}
	

}
