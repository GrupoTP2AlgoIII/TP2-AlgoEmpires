package modelo.unidad.espadachin;

import modelo.unidad.Posicionable;
import modelo.unidad.Unidad;

public class Espadachin extends Unidad {

	@Override
	public int avanzarTurno() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getVida() {
		return this.vida;
	}

	@Override
	public void restarVida(int vidaARestar) {
		this.vida -= vidaARestar;
		
	}
	
	@Override
	public void atacar(Posicionable posicionable) {
		posicionable.restarVida(25);
		
	}
}
