package modelo.unidad.armaDeAsedio;

import modelo.edificio.Edificio;
import modelo.unidad.Unidad;

public class ArmaDeAsedio extends Unidad {

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


}
