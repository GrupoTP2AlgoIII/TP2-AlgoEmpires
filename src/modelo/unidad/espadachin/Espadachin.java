package modelo.unidad.espadachin;

import modelo.ataque.Ataque;
import modelo.unidad.Posicionable;
import modelo.unidad.Unidad;

public class Espadachin extends Unidad {

	public Espadachin() {
		this.vida = 100;
		this.costo = 50;
		this.ataque = new Ataque(15,25);
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
