package modelo.unidad.armaDeAsedio;

import modelo.ataque.Ataque;
import modelo.unidad.Unidad;

public class ArmaDeAsedio extends Unidad {

	
	public ArmaDeAsedio() {
		this.vida = 150;
		this.costo = 200;
		this.ataque = new Ataque(75,0);
		
	}
	@Override
	public int avanzarTurno() {
		return 0;
	}

	@Override
	public int getVida() {
		return this.vida;
	}

	@Override
	public void atacado(Ataque ataque) {
		this.vida -= ataque.getAtaqueUnidad();
		
	}
	



}
