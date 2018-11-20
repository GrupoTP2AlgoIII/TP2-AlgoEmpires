package modelo.unidad.arquero;

import modelo.unidad.Posicionable;
import modelo.unidad.Unidad;

public class Arquero extends Unidad {

	private int vida = 75;
	private int costo = 75;
	
	
	@Override
	public int avanzarTurno() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getVida() {
		return this.vida;
	}
	
	public void atacar(Posicionable posicionable) {
		posicionable.restarVida(15);
	}
	
	@Override
	public void restarVida(int vidaARestar) {
		this.vida -= vidaARestar;
		
	}
}
